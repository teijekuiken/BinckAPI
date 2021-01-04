package BinckMap.BinckAPI.controller.model.Request;

import BinckMap.BinckAPI.Interfaces.ICompanyRequestBody;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CompanyRequestBody implements ICompanyRequestBody {

    private String name;
    private String description;
    private double lat1;
    private double lat2;
    private double long1;
    private double long2;

    public CompanyRequestBody(@JsonProperty("name") String name,
                               @JsonProperty("description") String description,
                               @JsonProperty("lat1") double lat1,
                               @JsonProperty("long1") double long1,
                               @JsonProperty("lat2") double lat2,
                               @JsonProperty("long2") double long2) {
        this.name = name;
        this.description = description;
        this.lat1 = lat1;
        this.long1 = long1;
        this.lat2 = lat2;
        this.long2 = long2;
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

    public double getLat1() {
        return lat1;
    }

    public void setLat1(double lat1) {
        this.lat1 = lat1;
    }

    public double getLat2() {
        return lat2;
    }

    public void setLat2(double lat2) {
        this.lat2 = lat2;
    }

    public double getLong1() {
        return long1;
    }

    public void setLong1(double long1) {
        this.long1 = long1;
    }

    public double getLong2() {
        return long2;
    }

    public void setLong2(double long2) {
        this.long2 = long2;
    }
}
