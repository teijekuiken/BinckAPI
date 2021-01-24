package BinckMap.BinckAPI.services;

import BinckMap.BinckAPI.DAO.BuildingRepository;
import BinckMap.BinckAPI.DAO.StoryRepository;
import BinckMap.BinckAPI.controller.model.Request.AreaRequestBody;
import BinckMap.BinckAPI.controller.model.Request.BuildingRequestBody;
import BinckMap.BinckAPI.entity.Area;
import BinckMap.BinckAPI.entity.Building;
import BinckMap.BinckAPI.services.model.BuildingResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public List<Building> setBuildings(List<BuildingRequestBody> buildingRequestBodies) {

        List<Building> buildings = new ArrayList();

        for(BuildingRequestBody buildingRequestBody : buildingRequestBodies){
            Building building = new Building();
            building.setName(buildingRequestBody.getName());
            building.setLabelType(buildingRequestBody.getLabelType());
            building.setOntwikkelaar(buildingRequestBody.getOntwikkelaar());
            building.setStatus(buildingRequestBody.getStatus());
            building.setProgramma(buildingRequestBody.getProgramma());
            building.setStatus(buildingRequestBody.getStatus());
            building.setDescription(buildingRequestBody.getDescription());
            building.setLat1(buildingRequestBody.getLat1());
            building.setLong1(buildingRequestBody.getLong1());
            building.setLat2(buildingRequestBody.getLat2());
            building.setLong2(buildingRequestBody.getLong2());

            buildings.add(building);
            buildingRepository.save(building);
        }

       return buildings;
    }
    
}
