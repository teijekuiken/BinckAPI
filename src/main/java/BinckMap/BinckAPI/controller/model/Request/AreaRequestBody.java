package BinckMap.BinckAPI.controller.model.Request;

import BinckMap.BinckAPI.Interfaces.IAreaRequestBody;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;

public class AreaRequestBody implements IAreaRequestBody {

    private String name;
    private String description;
    private String labelType;
    private String status;
    private String ontwikkelaar;
    private String programma;
    private double lat1;
    private double lat2;
    private double long1;
    private double long2;

    public AreaRequestBody(@JsonProperty("name") String name,
                           @JsonProperty("labelType") String labelType,
                           @JsonProperty("ontwikkelaar") String ontwikkelaar,
                           @JsonProperty("programma") String programma,
                           @JsonProperty("status") String status,
                           @JsonProperty("description") String description,
                           @JsonProperty("Lat1") double lat1,
                           @JsonProperty("Lon1") double long1,
                           @JsonProperty("Lat2") double lat2,
                           @JsonProperty("Lon2") double long2) {
        this.name = name;
        this.labelType = labelType;
        this.description = description;
        this.lat1 = lat1;
        this.long1 = long1;
        this.lat2 = lat2;
        this.long2 = long2;
        this.ontwikkelaar = ontwikkelaar;
        this.status = status;
        this.programma = programma;
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
    public double getLat1() {
        return lat1;
    }

    @Override
    public void setLat1(double lat1) {
        this.lat1 = lat1;
    }

    @Override
    public double getLat2() {
        return lat2;
    }

    @Override
    public void setLat2(double lat2) {
        this.lat2 = lat2;
    }

    @Override
    public double getLong1() {
        return long1;
    }

    @Override
    public void setLong1(double long1) {
        this.long1 = long1;
    }

    @Override
    public double getLong2() {
        return long2;
    }

    @Override
    public void setLong2(double long2) {
        this.long2 = long2;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOntwikkelaar() {
        return ontwikkelaar;
    }

    public void setOntwikkelaar(String ontwikkelaar) {
        this.ontwikkelaar = ontwikkelaar;
    }

    public String getProgramma() {
        return programma;
    }

    public void setProgramma(String programma) {
        this.programma = programma;
    }

    public String getLabelType() {
        return labelType;
    }

    public void setLabelType(String labelType) {
        this.labelType = labelType;
    }
}
