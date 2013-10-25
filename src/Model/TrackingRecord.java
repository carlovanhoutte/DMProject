package Model;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Carlo
 * Date: 25/10/13
 * Time: 11:20
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "TrackingRecord")
public class TrackingRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer trackingRecordID;
    private Date tijdstip;
    @ManyToOne
    @Cascade({CascadeType.SAVE_UPDATE})
    @JoinColumn(name = "Id", nullable = false)
    private RFID rfid;
    @ManyToOne
    @Cascade({CascadeType.SAVE_UPDATE})
    @JoinColumn(name = "zoneID", nullable = false)
    private Zone zoneUit;
    @ManyToOne
    @Cascade({CascadeType.SAVE_UPDATE})
    @JoinColumn(name = "zoneID", nullable = false)
    private Zone zoneIn;

    public TrackingRecord() {
    }

    public Integer getTrackingRecordID() {
        return trackingRecordID;
    }

    public void setTrackingRecordID(Integer trackingRecordID) {
        this.trackingRecordID = trackingRecordID;
    }

    public Date getTijdstip() {
        return tijdstip;
    }

    public void setTijdstip(Date tijdstip) {
        this.tijdstip = tijdstip;
    }

    public RFID getRfid() {
        return rfid;
    }

    public void setRfid(RFID rfid) {
        this.rfid = rfid;
    }

    public Zone getZoneUit() {
        return zoneUit;
    }

    public void setZoneUit(Zone zoneUit) {
        this.zoneUit = zoneUit;
    }

    public Zone getZoneIn() {
        return zoneIn;
    }

    public void setZoneIn(Zone zoneIn) {
        this.zoneIn = zoneIn;
    }
}
