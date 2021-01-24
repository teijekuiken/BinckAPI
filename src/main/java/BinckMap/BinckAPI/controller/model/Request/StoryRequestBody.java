package BinckMap.BinckAPI.controller.model.Request;

import BinckMap.BinckAPI.Interfaces.IStoryRequestBody;
import BinckMap.BinckAPI.entity.Area;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.UUID;


public class StoryRequestBody implements IStoryRequestBody {

    private UUID userId;
    private long areaId;
    private long buildingId;
    private long companyId;
    private String subject;
    private String verhaal;
    private Date publicationDate;
    private Date creationDate;

    public StoryRequestBody(@JsonProperty("userId") UUID userid,
                            @JsonProperty("areaId") long areaId,
                            @JsonProperty("buildingId") long buildingId,
                            @JsonProperty("companyId") long companyId,
                            @JsonProperty("subject") String subject,
                            @JsonProperty("verhaal") String verhaal) {
        this.userId = userid;
        this.areaId = areaId;
        this.buildingId = buildingId;
        this.companyId = companyId;
        this.subject = subject;
        this.verhaal = verhaal;
//        this.publicationDate = publicationDate;
//        this.creationDate = creationDate;
    }


    public StoryRequestBody() {
    }

    public UUID getId() {
        return userId;
    }

    public void setId(UUID id) {
        this.userId = id;
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

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public long getAreaId() {
        return areaId;
    }

    public void setAreaId(long areaId) {
        this.areaId = areaId;
    }

    public long getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(long buildingId) {
        this.buildingId = buildingId;
    }

    public long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(long companyId) {
        this.companyId = companyId;
    }
}