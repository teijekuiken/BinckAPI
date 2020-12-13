package BinckMap.BinckAPI.controller.model;

import BinckMap.BinckAPI.Interfaces.IAreaRequestBody;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AreaRequestBody implements IAreaRequestBody {

    private String name;
    private String description;

    public AreaRequestBody(@JsonProperty("name") String name,
                           @JsonProperty("description") String description) {
        this.name = name;
        this.description = description;
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
}
