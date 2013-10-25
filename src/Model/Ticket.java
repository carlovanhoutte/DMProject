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
 * Time: 10:39
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "Ticket")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer barcode;
    @ManyToOne
    @Cascade({CascadeType.SAVE_UPDATE})
    @JoinColumn(name = "ticketTypeID", nullable = false)
    private TicketType ticketType;
    @ManyToOne
    @Cascade({CascadeType.SAVE_UPDATE})
    @JoinColumn(name = "bestellingID", nullable = false)
    private Bestelling bestellings;
    private Float prijs;
    @ManyToMany(mappedBy = "tickets")
    @Cascade({CascadeType.SAVE_UPDATE})
    private Set<Festivaldag> festivaldagen = new HashSet<Festivaldag>();

    public Ticket() {
    }

    public Integer getBarcode() {
        return barcode;
    }

    public void setBarcode(Integer barcode) {
        this.barcode = barcode;
    }

    public TicketType getTicketType() {
        return ticketType;
    }

    public void setTicketType(TicketType ticketType) {
        this.ticketType = ticketType;
    }

    public Bestelling getBestellings() {
        return bestellings;
    }

    public void setBestellings(Bestelling bestellings) {
        this.bestellings = bestellings;
    }

    public Float getPrijs() {
        return prijs;
    }

    public void setPrijs(Float prijs) {
        this.prijs = prijs;
    }

    public Set<Festivaldag> getFestivaldagen() {
        return festivaldagen;
    }

    public void setFestivaldagen(Set<Festivaldag> festivaldagen) {
        this.festivaldagen = festivaldagen;
    }

    public void addFestivaldag(Festivaldag festivaldag) {
        festivaldagen.add(festivaldag);
    }
}
