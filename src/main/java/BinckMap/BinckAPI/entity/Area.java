package BinckMap.BinckAPI.entity;

import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "areas")
public class Area {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String labelType;

    @Column
    private String name;

    @Column(length = 50000)
    private String description;

    @Column(length = 50000)
    private String status;

    @Column
    private String ontwikkelaar;

    @Column(length = 50000)
    private String programma;

    @OneToMany
    @JoinColumn(name="area_id")
    private List<Story> stories;

    @Column
    private double lat1;

    @Column
    private double long1;

    @Column
    private double lat2;

    @Column
    private double long2;

    public Area(String name, String labelType, String ontwikkelaar, String programma, String status, String description, double lat1, double long1, double lat2, double long2) {
        this.name = name;
        this.description = description;
        this.programma = programma;
        this.ontwikkelaar = ontwikkelaar;
        this.status = status;
        this.lat1 = lat1;
        this.long1 = long1;
        this.lat2 = lat2;
        this.long2 = long2;
    }

    public Area() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Story> getStories() {
        return stories;
    }

    public void setStories(List<Story> stories) {
        this.stories = stories;
    }

    public double getLat1() {
        return lat1;
    }

    public void setLat1(double lat1) {
        this.lat1 = lat1;
    }

    public double getLong1() {
        return long1;
    }

    public void setLong1(double long1) {
        this.long1 = long1;
    }

    public double getLat2() {
        return lat2;
    }

    public void setLat2(double lat2) {
        this.lat2 = lat2;
    }

    public double getLong2() {
        return long2;
    }

    public void setLong2(double long2) {
        this.long2 = long2;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOntwikkelaar() {
        return ontwikkelaar;
    }

    public void setOntwikkelaar(String ontwikkelaar) {
        this.ontwikkelaar = ontwikkelaar;
    }

    public String getProgramma() {
        return programma;
    }

    public void setProgramma(String programma) {
        this.programma = programma;
    }

    public String getLabelType() {
        return labelType;
    }

    public void setLabelType(String labelType) {
        this.labelType = labelType;
    }
}
