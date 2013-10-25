package Model;

import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: Maarten
 * Date: 25/10/13
 * Time: 11:22
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "Model.Festivaldag")
public class Festivaldag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer dagID;
    private Date datum;
    @ManyToOne
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    @JoinColumn(name = "festivalID", nullable = false)
    private Festival festival;
    @ManyToMany
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    @JoinTable(name = "DagTicket",
            joinColumns = {@JoinColumn(name = "dagID")},
            inverseJoinColumns = {@JoinColumn(name = "ticketID")})
    @OrderBy
    @OrderColumn()
    private Set<Ticket> tickets = new HashSet<Ticket>();
}
