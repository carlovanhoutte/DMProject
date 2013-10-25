package Model;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: Carlo
 * Date: 25/10/13
 * Time: 11:17
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "Nummer")
public class Nummer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer nummerID;
    private String naam;
    private String auteur;
    private Integer duur;
    @ManyToOne
    @Cascade({CascadeType.SAVE_UPDATE})
    @JoinColumn(name = "optredenID", nullable = false)
    private Optreden optreden;

    public Nummer() {
    }

    public Integer getNummerID() {
        return nummerID;
    }

    public void setNummerID(Integer nummerID) {
        this.nummerID = nummerID;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public Integer getDuur() {
        return duur;
    }

    public void setDuur(Integer duur) {
        this.duur = duur;
    }

    public Optreden getOptreden() {
        return optreden;
    }

    public void setOptreden(Optreden optreden) {
        this.optreden = optreden;
    }
}
