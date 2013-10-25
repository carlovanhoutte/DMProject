import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created with IntelliJ IDEA.
 * User: Maarten
 * Date: 25/10/13
 * Time: 11:16
 * To change this template use File | Settings | File Templates.
 */
public class Klant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer klantID;
    private String naam;
}
