package generator;

import model.*;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import persistence.HibernateUtil;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: Maarten
 * Date: 5/11/13
 * Time: 10:33
 * To change this template use File | Settings | File Templates.
 */
public class Generator {
    private static Random random = new Random();

    public Generator() {

    }

    public static void generate(){
        insertFestivals();
        insertFestivaldagen();
        insertZoneTypes();
        insertZones();
        insertArtiesten();
        insertOptredens();
        insertNummers();
        insertTicketTypes();
        insertRFIDs();
        insertTrackingRecords();
    }

    private static Festival generateFestival(String naam, String locatie) {
        Festival festival = new Festival();
        festival.setNaam(naam);
        festival.setLocatie(locatie);
        int maxToeschouwers = (random.nextInt(13) * 5000) + 20000;
        festival.setMaxToeschouwers(maxToeschouwers);
        return festival;
    }

    private static void insertFestivals() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.saveOrUpdate(generateFestival("Beyond Wonderland CA","San Bernardino"));
        session.saveOrUpdate(generateFestival("Ultra Music Festival","Miami"));
        session.saveOrUpdate(generateFestival("Daydream Festival","Lommel"));
        session.saveOrUpdate(generateFestival("Pinkpop","Landgraaf"));
        session.saveOrUpdate(generateFestival("Rock Werchter","Werchter"));
        session.saveOrUpdate(generateFestival("Download","Donington Park"));
        session.saveOrUpdate(generateFestival("Defqon 1","Biddingenhuizen"));
        session.saveOrUpdate(generateFestival("Tomorrowland","Boom"));
        session.saveOrUpdate(generateFestival("Sziget","Budapest"));
        session.saveOrUpdate(generateFestival("Pukkelpop","Hasselt"));
        tx.commit();
    }

    private static void insertFestivaldagen() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("from Festival");
        List <Festival> festivals = query.list();
        for (Festival festival : festivals) {
            int aantalDagen = (random.nextInt(3)+1);
            int startDag = (random.nextInt(30)+1);
            int maand = (random.nextInt(4)+5);
            for (int jaar=2012; jaar<2014; jaar++) {
                Calendar cal = Calendar.getInstance();
                cal.set(jaar, maand, startDag);
                for(int i=0; i<aantalDagen; i++) {
                    Festivaldag festivaldag = new Festivaldag();
                    cal.add(Calendar.DATE,1);
                    festivaldag.setDatum(cal.getTime());
                    festival.addFestivaldag(festivaldag);
                }
            }
        session.saveOrUpdate(festival);
        }
        tx.commit();
    }

    private static void insertZoneTypes() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        ZoneType podium = new ZoneType();
        podium.setNaam("Podium");
        session.saveOrUpdate(podium);
        ZoneType kleedkamer = new ZoneType();
        kleedkamer.setNaam("Kleedkamer");
        session.saveOrUpdate(kleedkamer);
        tx.commit();
    }

    private static void insertZones() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("from Festival");
        List <Festival> festivals = query.list();
        Query query1 = session.createQuery("from ZoneType");
        List <ZoneType> zoneTypes = query1.list();
        tx.commit();
        for (Festival festival : festivals) {
            for (int i = 0; i<2; i++) {
                session = HibernateUtil.getSessionFactory().getCurrentSession();
                Transaction tx1 = session.beginTransaction();
                Zone zone = new Zone();
                zone.setNaam("Podium " + (i+1));
                zone.setFestival(festival);
                zone.setZoneType(zoneTypes.get(0));
                int capaciteit = (random.nextInt(10)+11) * 1000;
                zone.setCapaciteit(capaciteit);
                session.saveOrUpdate(zone);
                tx1.commit();
            }

            for (int i = 0; i<10; i++) {
                session = HibernateUtil.getSessionFactory().getCurrentSession();
                Transaction tx1 = session.beginTransaction();
                Zone zone = new Zone();
                zone.setNaam("Kleedkamer " + (i+1));
                zone.setFestival(festival);
                zone.setZoneType(zoneTypes.get(1));
                zone.setCapaciteit(10);
                session.saveOrUpdate(zone);
                tx1.commit();
            }
        }
    }

    private static Artiest generateArtiest(String naam) {
        Artiest artiest = new Artiest();
        artiest.setNaam(naam);
        int aantalPersonen = (random.nextInt(10)+1);
        artiest.setAantalPersonen(aantalPersonen);
        artiest.setBio("Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.");
        return artiest;
    }

    private static void insertArtiesten() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.saveOrUpdate(generateArtiest("Daft Punk"));
        session.saveOrUpdate(generateArtiest("The Prodigy"));
        session.saveOrUpdate(generateArtiest("Slash"));
        session.saveOrUpdate(generateArtiest("Afrojack"));
        session.saveOrUpdate(generateArtiest("Tiësto"));
        session.saveOrUpdate(generateArtiest("Sebastian Ingrosso"));
        session.saveOrUpdate(generateArtiest("Hardwell"));
        session.saveOrUpdate(generateArtiest("Dimitri Vegas & Like Mike"));
        session.saveOrUpdate(generateArtiest("Fedde Le Grand"));
        session.saveOrUpdate(generateArtiest("Otto Knows"));
        session.saveOrUpdate(generateArtiest("Nervo"));
        session.saveOrUpdate(generateArtiest("Mystique"));
        session.saveOrUpdate(generateArtiest("R3hab"));
        session.saveOrUpdate(generateArtiest("Steve Aoki"));
        session.saveOrUpdate(generateArtiest("Carl Cox"));
        session.saveOrUpdate(generateArtiest("South Central"));
        session.saveOrUpdate(generateArtiest("Markus Schulz"));
        session.saveOrUpdate(generateArtiest("Crookers"));
        session.saveOrUpdate(generateArtiest("Digitalism"));
        session.saveOrUpdate(generateArtiest("Bakermat"));
        session.saveOrUpdate(generateArtiest("Avicii"));
        session.saveOrUpdate(generateArtiest("Armin van Buuren"));
        session.saveOrUpdate(generateArtiest("Axwell"));
        session.saveOrUpdate(generateArtiest("Knife Party"));
        session.saveOrUpdate(generateArtiest("Chuckie"));
        session.saveOrUpdate(generateArtiest("Sander van Doorn"));
        session.saveOrUpdate(generateArtiest("Zedd"));
        session.saveOrUpdate(generateArtiest("Thomas Gold"));
        session.saveOrUpdate(generateArtiest("Benny Benassi"));
        session.saveOrUpdate(generateArtiest("Tommy Trash"));
        session.saveOrUpdate(generateArtiest("Martin Solveig"));
        tx.commit();
    }

    private static void insertOptredens() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("from Artiest");
        List <Artiest> artiesten = query.list();
        Query query1 = session.createQuery("from Festivaldag");
        List <Festivaldag> festivaldagen = query1.list();


        for (Festivaldag festivaldag : festivaldagen) {
            //Query query2 = session.createQuery("FROM zone inner join zonetype where zone.zoneTypeID = zonetype.zoneTypeID and zonetype.naam like 'podium' and zone.festivalID = '" + festivaldag.getFestival().getFestivalID()  + "'");
            Query query2 = session.createQuery("FROM Zone zone where zone.zoneType.naam like 'podium' AND zone.festival.festivalID = :festivalID");
            query2.setString("festivalID", festivaldag.getFestival().getFestivalID().toString());
            List <Zone> podia = query2.list();

            for (Zone podium : podia) {
                for (int i = 0; i<8; i++) {
                    Optreden optreden = new Optreden();
                    optreden.setArtiest(artiesten.get(random.nextInt(artiesten.size())));
                    optreden.setZone(podium);
                    optreden.setFestivaldag(festivaldag);
                    Date startTijdstipSoundcheck = new Date();
                    startTijdstipSoundcheck.setTime(festivaldag.getDatum().getTime());
                    startTijdstipSoundcheck.setHours(11 + i);
                    startTijdstipSoundcheck.setMinutes(45);
                    optreden.setStarttijdstipSoundcheck(startTijdstipSoundcheck);
                    Date startTijdstipOptreden = new Date();
                    startTijdstipOptreden.setTime(festivaldag.getDatum().getTime());
                    startTijdstipOptreden.setHours(12 + i);
                    startTijdstipOptreden.setMinutes(00);
                    optreden.setStarttijdstipOptreden(startTijdstipOptreden);
                    Date eindeTijdstip = new Date();
                    eindeTijdstip.setTime(festivaldag.getDatum().getTime());
                    eindeTijdstip.setHours(12 + i);
                    eindeTijdstip.setMinutes(45);
                    optreden.setEindtijdstip(eindeTijdstip);
                    optreden.setToelatingPers(true);
                    session.saveOrUpdate(optreden);
                }
            }
        }
        tx.commit();
    }

    private static void insertNummers() {
        int counter = 1;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("FROM Optreden");
        List <Optreden> optredens = query.list();
        for (Optreden optreden : optredens) {

            for (int i = 0; i<10; i++) {
                Nummer nummer = new Nummer();
                nummer.setAuteur("AuteurNaam");
                nummer.setNaam("Nummer " + counter);
                nummer.setDuur(240);
                nummer.setOptreden(optreden);
                counter++;
                session.saveOrUpdate(nummer);
            }
        }
        tx.commit();
    }

    private static void insertTicketTypes() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();

        Query query = session.createQuery("from Festivaldag");
        List <Festivaldag> festivaldagen = query.list();

        TicketType typeVIP = new TicketType();
        typeVIP.setNaam("VIP");
        typeVIP.setPrijs(520.00f);
        for (Festivaldag festivaldag : festivaldagen) {
        typeVIP.addFestivaldag(festivaldag);
        }

        TicketType typePers = new TicketType();
        typePers.setNaam("Pers");
        typePers.setPrijs(0.00f);
        for (Festivaldag festivaldag : festivaldagen) {
            typePers.addFestivaldag(festivaldag);
        }

        TicketType typeNormaal = new TicketType();
        typeNormaal.setNaam("Normaal");
        typeNormaal.setPrijs(240.00f);
        for (Festivaldag festivaldag : festivaldagen) {
            typeNormaal.addFestivaldag(festivaldag);
        }

        session.saveOrUpdate(typeVIP);
        session.saveOrUpdate(typePers);
        session.saveOrUpdate(typeNormaal);

        tx.commit();
    }

    private static void insertRFIDs() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();

        Query query = session.createQuery("From TicketType");
        List <TicketType> ticketTypes = query.list();

        for(int i=0; i<2000; i++) {
            RFID rfid = new RFID();
            rfid.setTicketType(ticketTypes.get(0));
            session.saveOrUpdate(rfid);
        }

        for(int i=0; i<2000; i++) {
            RFID rfid = new RFID();
            rfid.setTicketType(ticketTypes.get(1));
            session.saveOrUpdate(rfid);
        }

        for(int i=0; i<6000; i++) {
            RFID rfid = new RFID();
            rfid.setTicketType(ticketTypes.get(2));
            session.saveOrUpdate(rfid);
        }

        tx.commit();
    }

    private static void insertTrackingRecords() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();

        Query query = session.createQuery("from RFID");
        List <RFID> rfids = query.list();

        Query query1 = session.createQuery("from Festival");
        List <Festival> festivals = query1.list();

        for(RFID rfid : rfids) {
            for (int i=0; i<10; i++) {
                TrackingRecord trackingRecord = new TrackingRecord();
                trackingRecord.setRfid(rfid);
                Festival festival = festivals.get(random.nextInt(festivals.size()));
                Zone[] zones = festival.getZones().toArray(new Zone[festival.getZones().size()]);

                Zone zoneUit = zones[random.nextInt(zones.length)];
                Zone zoneIn = zones[random.nextInt(zones.length)];
                trackingRecord.setZoneUit(zoneUit);
                trackingRecord.setZoneIn(zoneIn);
                Festivaldag[] festivaldagen = festival.getFestivaldagen().toArray(new Festivaldag[festival.getFestivaldagen().size()]);
                Festivaldag festivaldag = festivaldagen[random.nextInt(festival.getFestivaldagen().size())];
                Date tijdstip = new Date();
                tijdstip.setTime(festivaldag.getDatum().getTime());
                tijdstip.setHours(11 + random.nextInt(8));
                tijdstip.setMinutes(random.nextInt(60));
                trackingRecord.setTijdstip(tijdstip);

                session.saveOrUpdate(trackingRecord);
            }
        }
        tx.commit();
    }
}
