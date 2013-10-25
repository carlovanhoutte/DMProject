package Model;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Carlo
 * Date: 25/10/13
 * Time: 11:09
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "Model.Optreden")
public class Optreden {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer optredenID;
    private Date starttijdstipSoundcheck;
    private Date starttijdstipOptreden;
    private Date eindtijdstip;
    private Boolean toelatingPers;
    @ManyToOne
    @Cascade(CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "zoneID", nullable = false)
    private Zone zone;
    @ManyToOne
    @Cascade(CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "artiestID", nullable = false)
    private Artiest artiest;
}
