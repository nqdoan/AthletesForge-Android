package trackconversion.model.dto;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "national_location")
@NamedQuery(name = "NationalLocation.getNationalLocation", query = "from NationalLocation")
public class NationalLocation implements Serializable {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long national_id;

    @Column
    private String location_name;

    @Column
    private String location_type;

    public Long getNational_id() {
        return national_id;
    }

    public void setNational_id(Long national_id) {
        this.national_id = national_id;
    }

    public String getLocation_name() {
        return location_name;
    }

    public void setLocation_name(String location_name) {
        this.location_name = location_name;
    }

    public String getLocation_type() {
        return location_type;
    }

    public void setLocation_type(String location_type) {
        this.location_type = location_type;
    }

}
