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
}
