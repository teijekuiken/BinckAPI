package BinckMap.BinckAPI.entity;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "areas")
public class Area {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @Column
    private String name;

    @Column
    private String description;

    @OneToMany(mappedBy = "area")
    private List<Story> stories;

    public Area(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Area() {

    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
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
}
