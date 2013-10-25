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
 * Time: 11:08
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "Artiest")
public class Artiest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer artiestID;
    private String naam;
    private Integer aantalPersonen;
    private String bio;
    @OneToMany(mappedBy = "artiest")
    @Cascade({CascadeType.SAVE_UPDATE})
    private Set<Optreden> optredens = new HashSet<Optreden>();
    @OneToMany(mappedBy = "artiest")
    @Cascade({CascadeType.SAVE_UPDATE})
    private Set<KleedkamerReservatie> reservaties = new HashSet<KleedkamerReservatie>();

    public Artiest() {
    }

    public Integer getArtiestID() {
        return artiestID;
    }

    public void setArtiestID(Integer artiestID) {
        this.artiestID = artiestID;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public Integer getAantalPersonen() {
        return aantalPersonen;
    }

    public void setAantalPersonen(Integer aantalPersonen) {
        this.aantalPersonen = aantalPersonen;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
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

    public void addReservatie(KleedkamerReservatie reservatie) {
        reservaties.add(reservatie);
    }
}
