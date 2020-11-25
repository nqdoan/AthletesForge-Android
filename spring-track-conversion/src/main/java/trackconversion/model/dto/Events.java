package trackconversion.model.dto;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "events")
@NamedQuery(name = "Events.getAllEvents", query = "SELECT event_name FROM Events")

@NamedQuery(name = "Events.getInfoByEvent", query = "from Events WHERE event_name = :eventName")

public class Events implements Serializable {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long event_id;

    @Column
    private String event_name;

    @Column
    private BigDecimal men_u2f;

    @Column
    private BigDecimal men_bo2f;

    @Column
    private BigDecimal men_u2bo;

    @Column
    private BigDecimal men_f2bo;

    @Column
    private BigDecimal women_u2f;

    @Column
    private BigDecimal women_bo2f;

    @Column
    private BigDecimal women_u2bo;

    @Column
    private BigDecimal women_f2bo;

    public Long getEvent_id() {
        return event_id;
    }

    public void setEvent_id(Long event_id) {
        this.event_id = event_id;
    }

    public String getEvent_name() {
        return event_name;
    }

    public void setEvent_name(String event_name) {
        this.event_name = event_name;
    }

    public BigDecimal getMen_u2f() {
        return men_u2f;
    }

    public void setMen_u2f(BigDecimal men_u2f) {
        this.men_u2f = men_u2f;
    }

    public BigDecimal getMen_bo2f() {
        return men_bo2f;
    }

    public void setMen_bo2f(BigDecimal men_bo2f) {
        this.men_bo2f = men_bo2f;
    }

    public BigDecimal getMen_u2bo() {
        return men_u2bo;
    }

    public void setMen_u2bo(BigDecimal men_u2bo) {
        this.men_u2bo = men_u2bo;
    }

    public BigDecimal getMen_f2bo() {
        return men_f2bo;
    }

    public void setMen_f2bo(BigDecimal men_f2bo) {
        this.men_f2bo = men_f2bo;
    }

    public BigDecimal getWomen_u2f() {
        return women_u2f;
    }

    public void setWomen_u2f(BigDecimal women_u2f) {
        this.women_u2f = women_u2f;
    }

    public BigDecimal getWomen_bo2f() {
        return women_bo2f;
    }

    public void setWomen_bo2f(BigDecimal women_bo2f) {
        this.women_bo2f = women_bo2f;
    }

    public BigDecimal getWomen_u2bo() {
        return women_u2bo;
    }

    public void setWomen_u2bo(BigDecimal women_u2bo) {
        this.women_u2bo = women_u2bo;
    }

    public BigDecimal getWomen_f2bo() {
        return women_f2bo;
    }

    public void setWomen_f2bo(BigDecimal women_f2bo) {
        this.women_f2bo = women_f2bo;
    }



}
