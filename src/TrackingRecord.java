import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Carlo
 * Date: 25/10/13
 * Time: 11:20
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "TrackingRecord")
public class TrackingRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer trackingRecordID;
    private Date tijdstip;
    @ManyToOne
    @Cascade({CascadeType.SAVE_UPDATE})
    @JoinColumn(name = "Id", nullable = false)
    private RFID rfid;
    @ManyToOne
    @Cascade({CascadeType.SAVE_UPDATE})
    @JoinColumn(name = "zoneID", nullable = false)
    private Zone zoneUit;
    @ManyToOne
    @Cascade({CascadeType.SAVE_UPDATE})
    @JoinColumn(name = "zoneID", nullable = false)
    private Zone zoneIn;
}
