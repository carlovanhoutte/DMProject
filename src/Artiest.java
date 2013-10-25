import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: Carlo
 * Date: 25/10/13
 * Time: 11:08
 * To change this template use File | Settings | File Templates.
 */
public class Artiest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer artiestID;
    private String naam;
    private Integer aantalPersonen;
    private String bio;
    @ManyToOne
    @Cascade({CascadeType.SAVE_UPDATE})
    @JoinColumn(name = "optredenID", nullable = false)
    private Optreden optreden;
    @ManyToOne
    @Cascade({CascadeType.SAVE_UPDATE})
    @JoinColumn(name = "reservatieID", nullable = false)
    private KleedkamerReservatie kleedkamerReservatie;
}
