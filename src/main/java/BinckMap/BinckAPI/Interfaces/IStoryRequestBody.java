package BinckMap.BinckAPI.Interfaces;

import java.util.Date;
import java.util.UUID;

public interface IStoryRequestBody {

    UUID getId();
    void setId(UUID id);

    String getSubject();
    void setSubject(String subject);

    String getVerhaal();
    void setVerhaal(String verhaal);

    Date getPublicationdate();
    void setPublicationdate(Date publicationdate);

    Date getCreationDate();
    void setCreationDate(Date creationDate);
}
