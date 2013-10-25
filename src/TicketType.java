import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: Maarten
 * Date: 25/10/13
 * Time: 10:54
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "TicketType")
public class TicketType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ticketTypeID;
    private String naam;
    @ManyToMany
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    @JoinTable(name = "ZoneTicket",
        joinColumns = {@JoinColumn(name = "ticketTypeID")},
        inverseJoinColumns = {@JoinColumn(name = "zoneTypeID")})
    @OrderBy
    @OrderColumn()
    private Set<ZoneType> zoneTypes = new HashSet<ZoneType>();
}
