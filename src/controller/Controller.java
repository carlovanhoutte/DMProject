package controller;

import model.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
import persistence.HibernateUtil;

import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: Maarten
 * Date: 5/11/13
 * Time: 14:32
 * To change this template use File | Settings | File Templates.
 */
public class Controller {

    Session session;
    Transaction tx;


    public Controller() {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        tx = session.beginTransaction();
    }

    public void slaagPassageOp(Zone zonein, Zone zoneUit, RFID rfid) {
        TrackingRecord trackingRecord = new TrackingRecord();
        trackingRecord.setTijdstip(new Date(System.currentTimeMillis()));
        trackingRecord.setZoneIn(zonein);
        trackingRecord.setZoneUit(zoneUit);
        trackingRecord.setRfid(rfid);
        session.saveOrUpdate(trackingRecord);
        nextTransaction();
    }

    public void registratieVerkoop(Klant klant, int aantal, TicketType ticketType, Set<Festivaldag> dagen) {
        Bestelling bestelling = new Bestelling();
        bestelling.setHoeveelheid(aantal);
        bestelling.setKlant(klant);
        bestelling.setTotaalprijs(aantal * ticketType.getPrijs());
        for (int i = 0; i < aantal; i++) {
            Ticket ticket = new Ticket();
            ticket.setTicketType(ticketType);
            ticket.setBestelling(bestelling);
            ticket.setFestivaldagen(dagen);
            bestelling.addTicket(ticket);
        }
        nextTransaction();
    }

    public Optreden zoekOptreden(Zone zone, Date date) {
        String queryString = "from Optreden o "
                + "WHERE o.zone.naam = :searchString "
                + "AND o.starttijdstipOptreden < :date AND o.eindtijdstip > : date";
        List<Optreden> optredens = session.createQuery(queryString).setString("searchString", zone.getNaam()).setDate("date", date).list();
        nextTransaction();
        return optredens.get(0);
    }

    public String zoekFestival(Artiest artiest, Date t1, Date t2) {
        String queryString = "from Festival f join f.zones z join z.optredens o "
                + "WHERE o.artiest.naam = :parArtiest "
                + "AND o.starttijdstipOptreden > :d1 AND o.eindtijdstip < :d2 ";

        List<Festival> festivals = session.createQuery(queryString).setString("parArtiest", artiest.getNaam()).setDate("d1", t1).setDate("d2", t2).list();

        String output = "\n";
        if (festivals.isEmpty()) {
            return "Geen resultaat";
        }
        for (Festival f : festivals) {
            output += f.getNaam() + ": " + f.getLocatie() + "\n";
        }
        nextTransaction();
        return output;
    }

    public void nextTransaction() {
        tx.commit();
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        tx = session.beginTransaction();
    }

}
