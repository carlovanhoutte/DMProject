import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: Carlo
 * Date: 25/10/13
 * Time: 11:04
 * To change this template use File | Settings | File Templates.
 */
public class Zone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer zoneID;
    private String naam;
    private Integer capaciteit;
    @ManyToOne
    @Cascade({CascadeType.SAVE_UPDATE})
    @JoinColumn(name = "festivalID", nullable = false)
    private Festival festival;
    @ManyToOne
    @Cascade({CascadeType.SAVE_UPDATE})
    @JoinColumn(name = "zoneTypeID", nullable = false)
    private ZoneType zoneType;
    @OneToOne
    @Cascade({CascadeType.SAVE_UPDATE})
    @JoinColumn(name = "zoneID")
    private Zone zone;
}
