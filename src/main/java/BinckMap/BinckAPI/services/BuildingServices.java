package BinckMap.BinckAPI.services;

import BinckMap.BinckAPI.DAO.BuildingRepository;
import BinckMap.BinckAPI.DAO.StoryRepository;
import BinckMap.BinckAPI.controller.model.Request.BuildingRequestBody;
import BinckMap.BinckAPI.entity.Building;
import BinckMap.BinckAPI.services.model.BuildingResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BuildingServices {

    @Autowired
    private BuildingRepository buildingRepository;

    @Autowired
    private StoryRepository storyRepository;

    public Building getBuildingById(long buildingId){
        Optional<Building> building = buildingRepository.findById(buildingId);
        if(building.isEmpty()){
            return null;
        }
        return building.get();
    }

    public Building getBuildingByName(String name, List<Building> buildings){
        for (Building building : buildings){
            building.getName().equals(name);{
                return building;
            }
        } return null;
    }

    public List<Building> getAllBuildings(){
        List<Building> buildings = buildingRepository.findAll();
        return buildings;
    }

    public BuildingResponseBody setBuilding(BuildingRequestBody buildingRequestBody) {
        Building building = new Building(buildingRequestBody.getName(), buildingRequestBody.getDescription(), buildingRequestBody.getLat1(), buildingRequestBody.getLong1(), buildingRequestBody.getLat2(), buildingRequestBody.getLong2());

        buildingRepository.save(building);

        BuildingResponseBody buildingResponseBody = new BuildingResponseBody(building.getName(), building.getDescription(), building.getLat1(), building.getLong1(), building.getLat2(), building.getLong2());
        return buildingResponseBody;
    }
    
}
