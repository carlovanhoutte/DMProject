package controller;

import model.*;

import java.text.DateFormat;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Maarten
 * Date: 5/11/13
 * Time: 14:32
 * To change this template use File | Settings | File Templates.
 */
public class Controller {

    public Controller() {

    }

    public void slaagPassageOp(Zone zonein, Zone zoneUit, RFID rfid) {
        TrackingRecord trackingRecord = new TrackingRecord();
        trackingRecord.setTijdstip(new Date(System.currentTimeMillis()));
        trackingRecord.setZoneIn(zonein);
        trackingRecord.setZoneUit(zoneUit);
        trackingRecord.setRfid(rfid);
    }

    public void registratieVerkoop(Klant klant, int aantal, TicketType ticketType){

    }

}
