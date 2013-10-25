package Model;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: Maarten
 * Date: 25/10/13
 * Time: 11:16
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name="Model.Klant")
public class Klant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer klantID;
    private String naam;
    private String klantType;
}
