package BinckMap.BinckAPI.services.model;

import BinckMap.BinckAPI.Interfaces.IBuildingResponseBody;

public class BuildingResponseBody implements IBuildingResponseBody {

    private String name;
    private String description;

    public BuildingResponseBody(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;

    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;

    }
    
}
