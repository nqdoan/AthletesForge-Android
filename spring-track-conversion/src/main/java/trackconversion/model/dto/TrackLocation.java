package trackconversion.model.dto;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "tracklocation")
@NamedQuery(name = "TrackLocation.getAllTracks", query = "SELECT school_name FROM TrackLocation")

@NamedQuery(name = "TrackLocation.getInfoByName", query = "from TrackLocation WHERE school_name = :schoolName")
public class TrackLocation implements Serializable {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long track_id;

    @Column
    private String school_name;

    @Column
    private String city_name;

    @Column
    private Long altitude;

    @Column
    private String indoor_type;

    @Column
    private String outdoor_type;

    @Column
    private BigDecimal men_conversion_indoor;

    @Column
    private BigDecimal women_conversion_indoor;

    @Column
    private BigDecimal men_conversion_outdoor;

    @Column
    private BigDecimal women_conversion_outdoor;

    public Long getTrack_id() {
        return track_id;
    }

    public void setTrack_id(Long track_id) {
        this.track_id = track_id;
    }

    public String getSchool_name() {
        return school_name;
    }

    public void setSchool_name(String school_name) {
        this.school_name = school_name;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public Long getAltitude() {
        return altitude;
    }

    public void setAltitude(Long altitude) {
        this.altitude = altitude;
    }

    public BigDecimal getMen_conversion_indoor() {
        return men_conversion_indoor;
    }

    public void setMen_conversion_indoor(BigDecimal men_conversion_indoor) {
        this.men_conversion_indoor = men_conversion_indoor;
    }

    public BigDecimal getWomen_conversion_indoor() {
        return women_conversion_indoor;
    }

    public void setWomen_conversion_indoor(BigDecimal women_conversion_indoor) {
        this.women_conversion_indoor = women_conversion_indoor;
    }

    public BigDecimal getMen_conversion_outdoor() {
        return men_conversion_outdoor;
    }

    public void setMen_conversion_outdoor(BigDecimal men_conversion_outdoor) {
        this.men_conversion_outdoor = men_conversion_outdoor;
    }

    public BigDecimal getWomen_conversion_outdoor() {
        return women_conversion_outdoor;
    }

    public void setWomen_conversion_outdoor(BigDecimal women_conversion_outdoor) {
        this.women_conversion_outdoor = women_conversion_outdoor;
    }

    public String getIndoor_type() {
        return indoor_type;
    }

    public void setIndoor_type(String indoor_type) {
        this.indoor_type = indoor_type;
    }

    public String getOutdoor_type() {
        return outdoor_type;
    }

    public void setOutdoor_type(String outdoor_type) {
        this.outdoor_type = outdoor_type;
    }

}
