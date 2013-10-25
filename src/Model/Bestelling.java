package Model;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: Maarten
 * Date: 25/10/13
 * Time: 11:13
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "Model.Bestelling")
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
}
