package BinckMap.BinckAPI.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "story")

public class Story {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @Column
    private String subject;

    @Column(length = 50000)
    private String story;

    @JsonIgnore
    @ManyToOne
    private User user;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="area_id", referencedColumnName = "id")
    private Area area;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="building_id", referencedColumnName = "id")
    private Building building;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="company_id", referencedColumnName = "id")
    private Company company;

    @Column
    private Date publicationDate;

    @Column
    private Date creationDate;

    @Column
    private boolean published;

    public Story(String subject, String story, User user, Building building) {
        this.subject = subject;
        this.story = story;
        this.user = user;
        this.building = building;
    }

    public Story() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getStory() {
        return story;
    }

    public void setStory(String story) {
        this.story = story;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public boolean isPublished() {
        return published;
    }

    public void setPublished(boolean published) {
        this.published = published;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
