package BinckMap.BinckAPI.entity;

import javax.persistence.*;
import java.util.UUID;

@Entity

public class Story {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @Column
    private String subject;

    @Column
    private String story;

    public Story(UUID id, String subject, String story) {
        this.id = id;
        this.subject = subject;
        this.story = story;
    }

    public Story(){}

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
}
