package Model;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: Carlo
 * Date: 25/10/13
 * Time: 10:14
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "Model.Festival")
public class Festival {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer festivalID;
    private String naam;
    private String locatie;
    private Integer maxToeschouwers;
}
