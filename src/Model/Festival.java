package model;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: Carlo
 * Date: 25/10/13
 * Time: 10:14
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "Festival")
public class Festival {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer festivalID;
    private String naam;
    private String locatie;
    private Integer maxToeschouwers;
    @OneToMany(mappedBy = "festival")
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    private Set<Festivaldag> festivaldagen = new HashSet<Festivaldag>();
    @OneToMany(mappedBy = "festival")
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    private Set<Zone> zones = new HashSet<Zone>();

    public Festival() {
    }

    public Integer getFestivalID() {
        return festivalID;
    }

    public void setFestivalID(Integer festivalID) {
        this.festivalID = festivalID;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getLocatie() {
        return locatie;
    }

    public void setLocatie(String locatie) {
        this.locatie = locatie;
    }

    public Integer getMaxToeschouwers() {
        return maxToeschouwers;
    }

    public void setMaxToeschouwers(Integer maxToeschouwers) {
        this.maxToeschouwers = maxToeschouwers;
    }

    public Set<Festivaldag> getFestivaldagen() {
        return festivaldagen;
    }

    public void setFestivaldagen(Set<Festivaldag> festivaldagen) {
        this.festivaldagen = festivaldagen;
    }

    public Set<Zone> getZones() {
        return zones;
    }

    public void setZones(Set<Zone> zones) {
        this.zones = zones;
    }

    public void addFestivaldag(Festivaldag festivaldag) {
        festivaldagen.add(festivaldag);
    }

    public void addZone(Zone zone) {
        zones.add(zone);
    }
}
