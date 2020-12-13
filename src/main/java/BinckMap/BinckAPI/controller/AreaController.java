package BinckMap.BinckAPI.controller;

import BinckMap.BinckAPI.controller.model.AreaRequestBody;
import BinckMap.BinckAPI.entity.Area;
import BinckMap.BinckAPI.services.AreaServices;
import BinckMap.BinckAPI.services.model.AreaResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class AreaController {

    @Autowired
    private AreaServices areaServices;

    @GetMapping("/area/{areaId}")
    public ResponseEntity<Area> getArea(@PathVariable UUID areaId) {

        Area area = areaServices.getAreaById(areaId);

        return ResponseEntity.ok(area);
    }

    @GetMapping("/area")
    public ResponseEntity<List<Area>> getAllAreas() {
        List<Area> stories = areaServices.getAllAreas();

        return ResponseEntity.ok(stories);
    }

    @PostMapping("/area")
    public AreaResponseBody addArea(@RequestBody AreaRequestBody areaRequestBody) {
        return areaServices.setArea(areaRequestBody);
    }
}
