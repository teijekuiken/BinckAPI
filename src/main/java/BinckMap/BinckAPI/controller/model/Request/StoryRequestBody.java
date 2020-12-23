package BinckMap.BinckAPI.controller.model.Request;

import BinckMap.BinckAPI.Interfaces.IStoryRequestBody;
import BinckMap.BinckAPI.entity.Area;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.UUID;



public class StoryRequestBody implements IStoryRequestBody {

    private UUID id;
    private String subject;
    private String verhaal;
    private Date publicationDate;
    private Date creationDate;

    public StoryRequestBody(@JsonProperty("userId")UUID id,
                            @JsonProperty("subject") String subject,
                            @JsonProperty("verhaal") String verhaal,
                            @JsonProperty("publicationDate") Date publicationDate,
                            @JsonProperty("creationDate") Date creationDate) {
        this.id = id;
        this.subject = subject;
        this.verhaal = verhaal;
        this.publicationDate = publicationDate;
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
}
