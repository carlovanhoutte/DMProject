package Model;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: Carlo
 * Date: 25/10/13
 * Time: 11:04
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "Zone")
public class Zone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer zoneID;
    private String naam;
    private Integer capaciteit;
    @ManyToOne
    @Cascade({CascadeType.SAVE_UPDATE})
    @JoinColumn(name = "festivalID", nullable = false)
    private Festival festival;
    @ManyToOne
    @Cascade({CascadeType.SAVE_UPDATE})
    @JoinColumn(name = "zoneTypeID", nullable = false)
    private ZoneType zoneType;
    @OneToOne
    @Cascade({CascadeType.SAVE_UPDATE})
    @JoinColumn(name = "zoneID")
    private Zone zone;
    @OneToMany(mappedBy = "zone")
    @Cascade({CascadeType.SAVE_UPDATE})
    private Set<Optreden> optredens = new HashSet<Optreden>();
    @OneToMany(mappedBy = "zone")
    @Cascade({CascadeType.SAVE_UPDATE})
    private Set<KleedkamerReservatie> reservaties = new HashSet<KleedkamerReservatie>();

    public Zone() {
    }

    public Integer getZoneID() {
        return zoneID;
    }

    public void setZoneID(Integer zoneID) {
        this.zoneID = zoneID;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public Integer getCapaciteit() {
        return capaciteit;
    }

    public void setCapaciteit(Integer capaciteit) {
        this.capaciteit = capaciteit;
    }

    public Festival getFestival() {
        return festival;
    }

    public void setFestival(Festival festival) {
        this.festival = festival;
    }

    public ZoneType getZoneType() {
        return zoneType;
    }

    public void setZoneType(ZoneType zoneType) {
        this.zoneType = zoneType;
    }

    public Zone getZone() {
        return zone;
    }

    public void setZone(Zone zone) {
        this.zone = zone;
    }

    public Set<Optreden> getOptredens() {
        return optredens;
    }

    public void setOptredens(Set<Optreden> optredens) {
        this.optredens = optredens;
    }

    public Set<KleedkamerReservatie> getReservaties() {
        return reservaties;
    }

    public void setReservaties(Set<KleedkamerReservatie> reservaties) {
        this.reservaties = reservaties;
    }

    public void addOptreden(Optreden optreden) {
        optredens.add(optreden);
    }

    public void addReservatie(KleedkamerReservatie kleedkamerReservatie) {
        reservaties.add(kleedkamerReservatie);
    }
}
