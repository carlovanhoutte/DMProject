package model;

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
@Entity
@Table(name = "Nood")
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

    public Nood() {
    }

    public Integer getNoodID() {
        return noodID;
    }

    public void setNoodID(Integer noodID) {
        this.noodID = noodID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBeschrijving() {
        return beschrijving;
    }

    public void setBeschrijving(String beschrijving) {
        this.beschrijving = beschrijving;
    }

    public Optreden getOptreden() {
        return optreden;
    }

    public void setOptreden(Optreden optreden) {
        this.optreden = optreden;
    }
}
