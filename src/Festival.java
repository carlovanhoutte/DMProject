import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created with IntelliJ IDEA.
 * User: Carlo
 * Date: 25/10/13
 * Time: 10:14
 * To change this template use File | Settings | File Templates.
 */
public class Festival {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer festivalID;
    private String naam;
    private String locatie;
    private Integer maxToeschouwers;
}
