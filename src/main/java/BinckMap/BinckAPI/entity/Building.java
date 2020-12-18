package BinckMap.BinckAPI.entity;


import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "buildings")
public class Building {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @Column
    private String name;

    @Column
    private String description;

    @OneToMany(mappedBy = "building")
    private List<Story> stories;

    @Column
    private String Longtitude;

    @Column
    private String Lattitude;


    public Building(String name, String description, String longtitude, String lattitude) {
        this.name = name;
        this.description = description;
        this.Longtitude = longtitude;
        this.Lattitude = lattitude;
    }

    public Building() {
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

    public List<Story> getStories() {
        return stories;
    }

    public void setStories(List<Story> stories) {
        this.stories = stories;
    }

    public String getLongtitude() {
        return Longtitude;
    }

    public void setLongtitude(String longtitude) {
        Longtitude = longtitude;
    }

    public String getLattitude() {
        return Lattitude;
    }

    public void setLattitude(String lattitude) {
        Lattitude = lattitude;
    }
}
