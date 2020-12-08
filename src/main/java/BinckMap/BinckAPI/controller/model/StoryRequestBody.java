package BinckMap.BinckAPI.controller.model;

import BinckMap.BinckAPI.Interfaces.IStoryRequestBody;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.UUID;

public class StoryRequestBody implements IStoryRequestBody {

    private UUID id;
    private String subject;
    private String verhaal;
    private Date publicationdate;
    private Date creationDate;

    public StoryRequestBody(@JsonProperty("userId")UUID id,
                            @JsonProperty("subject") String subject,
                            @JsonProperty("verhaal") String verhaal,
                            @JsonProperty("publicationdate") Date publicationdate,
                            @JsonProperty("creationDate") Date creationDate) {
        this.id = id;
        this.subject = subject;
        this.verhaal = verhaal;
        this.publicationdate = publicationdate;
        this.creationDate = creationDate;
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

    public String getVerhaal() {
        return verhaal;
    }

    public void setVerhaal(String verhaal) {
        this.verhaal = verhaal;
    }

    public Date getPublicationdate() {
        return publicationdate;
    }

    public void setPublicationdate(Date publicationdate) {
        this.publicationdate = publicationdate;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}
