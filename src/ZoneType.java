import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: Maarten
 * Date: 25/10/13
 * Time: 10:56
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "ZoneType")
public class ZoneType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer zoneTypeId;
    private String naam;
    private String privelegetype;
    @ManyToMany(mappedBy = "zondeTypes")
    @Cascade(CascadeType.SAVE_UPDATE)
    private Set<TicketType> ticketTypes = new HashSet<TicketType>();
}
