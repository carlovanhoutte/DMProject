package Model;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: Maarten
 * Date: 25/10/13
 * Time: 11:13
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "Bestelling")
public class Bestelling {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bestellingsID;
    private Integer hoeveelheid;
    private Float totaalprijs;
    @ManyToOne
    @Cascade({CascadeType.SAVE_UPDATE})
    @JoinColumn(name = "klantID", nullable = false)
    private Klant klant;
    @OneToMany(mappedBy = "bestelling")
    @Cascade({CascadeType.SAVE_UPDATE})
    private Set<Ticket> tickets = new HashSet<Ticket>();

    public Bestelling() {
    }

    public Integer getBestellingsID() {
        return bestellingsID;
    }

    public void setBestellingsID(Integer bestellingsID) {
        this.bestellingsID = bestellingsID;
    }

    public Integer getHoeveelheid() {
        return hoeveelheid;
    }

    public void setHoeveelheid(Integer hoeveelheid) {
        this.hoeveelheid = hoeveelheid;
    }

    public Float getTotaalprijs() {
        return totaalprijs;
    }

    public void setTotaalprijs(Float totaalprijs) {
        this.totaalprijs = totaalprijs;
    }

    public Klant getKlant() {
        return klant;
    }

    public void setKlant(Klant klant) {
        this.klant = klant;
    }

    public Set<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Set<Ticket> tickets) {
        this.tickets = tickets;
    }

    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
    }
}
