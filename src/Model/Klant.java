package model;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: Maarten
 * Date: 25/10/13
 * Time: 11:16
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "Klant")
public class Klant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer klantID;
    private String naam;
    private String klantType;

    public Klant() {
    }

    public Integer getKlantID() {
        return klantID;
    }

    public void setKlantID(Integer klantID) {
        this.klantID = klantID;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getKlantType() {
        return klantType;
    }

    public void setKlantType(String klantType) {
        this.klantType = klantType;
    }
}
