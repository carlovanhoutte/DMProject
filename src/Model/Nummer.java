package Model;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: Carlo
 * Date: 25/10/13
 * Time: 11:17
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "Model.Nummer")
public class Nummer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer nummerID;
    private String naam;
    private String auteur;
    private Integer duur;
    @ManyToOne
    @Cascade({CascadeType.SAVE_UPDATE})
    @JoinColumn(name = "optredenID", nullable = false)
    private Optreden optreden;
}
