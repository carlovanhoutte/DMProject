package model;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: Carlo
 * Date: 25/10/13
 * Time: 11:09
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "Optreden")
public class Optreden {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer optredenID;
    private Date starttijdstipSoundcheck;
    private Date starttijdstipOptreden;
    private Date eindtijdstip;
    private Boolean toelatingPers;
    @ManyToOne
    @Cascade(CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "zoneID", nullable = false)
    private Zone zone;
    @ManyToOne
    @Cascade(CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "artiestID", nullable = false)
    private Artiest artiest;
    @OneToMany(mappedBy = "optreden")
    @Cascade({CascadeType.SAVE_UPDATE})
    private Set<Nood> noden = new HashSet<Nood>();
    @OneToMany(mappedBy = "optreden")
    @Cascade({CascadeType.SAVE_UPDATE})
    private Set<Nummer> nummers = new HashSet<Nummer>();
    @ManyToOne
    @Cascade(CascadeType.SAVE_UPDATE)
    private Festivaldag festivaldag;

    public Optreden() {
    }

    public Integer getOptredenID() {
        return optredenID;
    }

    public Festivaldag getFestivaldag() {
        return festivaldag;
    }

    public void setFestivaldag(Festivaldag festivaldag) {
        this.festivaldag = festivaldag;
    }

    public void setOptredenID(Integer optredenID) {
        this.optredenID = optredenID;

    }

    public Date getStarttijdstipSoundcheck() {
        return starttijdstipSoundcheck;
    }

    public void setStarttijdstipSoundcheck(Date starttijdstipSoundcheck) {
        this.starttijdstipSoundcheck = starttijdstipSoundcheck;
    }

    public Date getStarttijdstipOptreden() {
        return starttijdstipOptreden;
    }

    public void setStarttijdstipOptreden(Date starttijdstipOptreden) {
        this.starttijdstipOptreden = starttijdstipOptreden;
    }

    public Date getEindtijdstip() {
        return eindtijdstip;
    }

    public void setEindtijdstip(Date eindtijdstip) {
        this.eindtijdstip = eindtijdstip;
    }

    public Boolean getToelatingPers() {
        return toelatingPers;
    }

    public void setToelatingPers(Boolean toelatingPers) {
        this.toelatingPers = toelatingPers;
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

    public Set<Nood> getNoden() {
        return noden;
    }

    public void setNoden(Set<Nood> noden) {
        this.noden = noden;
    }

    public Set<Nummer> getNummers() {
        return nummers;
    }

    public void setNummers(Set<Nummer> nummers) {
        this.nummers = nummers;
    }

    public void addNood(Nood nood) {
        noden.add(nood);
    }

    public void addNummer(Nummer nummer) {
        nummers.add(nummer);
    }
}
