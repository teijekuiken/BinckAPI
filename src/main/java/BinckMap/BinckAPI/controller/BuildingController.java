package BinckMap.BinckAPI.controller;

import BinckMap.BinckAPI.controller.model.Request.BuildingRequestBody;
import BinckMap.BinckAPI.entity.Building;
import BinckMap.BinckAPI.services.BuildingServices;
import BinckMap.BinckAPI.services.model.BuildingResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class BuildingController {

    @Autowired
    private BuildingServices buildingServices;

    @GetMapping("/building/{buildingId}")
    public ResponseEntity<Building> getBuilding(@PathVariable long buildingId) {

        Building building = buildingServices.getBuildingById(buildingId);

        return ResponseEntity.ok(building);
    }

    @CrossOrigin
    @GetMapping("/building")
    public ResponseEntity<List<Building>> getAllStories() {
        List<Building> buildings = buildingServices.getAllBuildings();

        return ResponseEntity.ok(buildings);
    }

    @PostMapping("/building")
    public BuildingResponseBody addBuilding(@RequestBody BuildingRequestBody buildingRequestBody) {
        return buildingServices.setBuilding(buildingRequestBody);
    }
    
}
