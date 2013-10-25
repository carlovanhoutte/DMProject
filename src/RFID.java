import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: Carlo
 * Date: 25/10/13
 * Time: 11:22
 * To change this template use File | Settings | File Templates.
 */
public class RFID {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @Cascade({CascadeType.SAVE_UPDATE})
    @JoinColumn(name = "ticketTypeID", nullable = false)
    private TicketType ticketType;
}
