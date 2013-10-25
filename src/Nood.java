import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: Carlo
 * Date: 25/10/13
 * Time: 11:19
 * To change this template use File | Settings | File Templates.
 */
public class Nood {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer noodID;
    private String type;
    private String beschrijving;
    @ManyToOne
    @Cascade({CascadeType.SAVE_UPDATE})
    @JoinColumn(name = "optredenID", nullable = false)
    private Optreden optreden;
}
