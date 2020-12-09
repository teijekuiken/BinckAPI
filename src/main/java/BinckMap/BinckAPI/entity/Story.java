package BinckMap.BinckAPI.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

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

    @Column
    private String story;

    @ManyToOne
    private User user;

    @Column
    private Date publicationDate;

    @Column
    private Date creationDate;

    @Column
    private boolean published;

    public Story(String subject, String story, User user, Date publicationDate, Date creationDate) {
        this.subject = subject;
        this.story = story;
        this.user = user;
        this.publicationDate = publicationDate;
        this.creationDate = creationDate;
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
}
