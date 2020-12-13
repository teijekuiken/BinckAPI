package BinckMap.BinckAPI.services.model;

import BinckMap.BinckAPI.Interfaces.IAreaResponseBody;

public class AreaResponseBody implements IAreaResponseBody {

    private String name;
    private String description;

    public AreaResponseBody(String name, String description) {
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
