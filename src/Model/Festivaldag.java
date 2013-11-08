package model;

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
@Table(name = "Festivaldag")
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
            inverseJoinColumns = {@JoinColumn(name = "ticketTypeID")})
    @OrderBy
    @OrderColumn()
    private Set<TicketType> ticketTypes = new HashSet<TicketType>();

    public Festivaldag() {
    }

    public Integer getDagID() {
        return dagID;
    }

    public void setDagID(Integer dagID) {
        this.dagID = dagID;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public Festival getFestival() {
        return festival;
    }

    public void setFestival(Festival festival) {
        this.festival = festival;
    }

    public Set<TicketType> getTicketsTicketTypes() {
        return ticketTypes;
    }

    public void setTicketTypes(Set<TicketType> ticketTypes) {
        this.ticketTypes = ticketTypes;
    }

    public void addTicketTypes(TicketType ticketType) {
        ticketTypes.add(ticketType);
    }
}
