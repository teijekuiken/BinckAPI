package BinckMap.BinckAPI.controller.model;

import BinckMap.BinckAPI.Interfaces.IBuildingRequestBody;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BuildingRequestBody implements IBuildingRequestBody {

    private String name;
    private String description;
    private String longtitude;
    private String lattitude;

    public BuildingRequestBody(@JsonProperty("name") String name,
                           @JsonProperty("description") String description,
                               @JsonProperty("longtitude") String longtitude,
                               @JsonProperty("lattitude") String lattitude) {
        this.name = name;
        this.description = description;
        this.longtitude = longtitude;
        this.lattitude = lattitude;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String Name) {
        this.name = name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;

    }

    @Override
    public String getLongtitude() {
        return longtitude;
    }

    @Override
    public void setLongtitude(String longtitude) {
        this.longtitude = longtitude;
    }

    @Override
    public String getLattitude() {
        return lattitude;
    }

    @Override
    public void setLattitude(String lattitude) {
        this.lattitude = lattitude;
    }
}
