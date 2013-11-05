package model;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Carlo
 * Date: 25/10/13
 * Time: 11:10
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "KleedkamerReservatie")
public class KleedkamerReservatie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer reservatieID;
    private Date begintijdstip;
    private Date eindtijdstip;
    @ManyToOne
    @Cascade(CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "zoneID", nullable = false)
    private Zone zone;
    @ManyToOne
    @Cascade(CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "artiestID", nullable = false)
    private Artiest artiest;

    public KleedkamerReservatie() {
    }

    public Integer getReservatieID() {
        return reservatieID;
    }

    public void setReservatieID(Integer reservatieID) {
        this.reservatieID = reservatieID;
    }

    public Date getBegintijdstip() {
        return begintijdstip;
    }

    public void setBegintijdstip(Date begintijdstip) {
        this.begintijdstip = begintijdstip;
    }

    public Date getEindtijdstip() {
        return eindtijdstip;
    }

    public void setEindtijdstip(Date eindtijdstip) {
        this.eindtijdstip = eindtijdstip;
    }

    public Zone getZone() {
        return zone;
    }

    public void setZone(Zone zone) {
        this.zone = zone;
    }

    public Artiest getArtiest() {
        return artiest;
    }

    public void setArtiest(Artiest artiest) {
        this.artiest = artiest;
    }
}
