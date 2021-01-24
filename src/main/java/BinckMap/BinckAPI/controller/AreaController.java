package BinckMap.BinckAPI.controller;

import BinckMap.BinckAPI.controller.model.Request.AreaRequestBody;
import BinckMap.BinckAPI.entity.Area;
import BinckMap.BinckAPI.services.AreaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class AreaController {

    @Autowired
    private AreaServices areaServices;

    @GetMapping("/area/{areaId}")
    public ResponseEntity<Area> getArea(@PathVariable long areaId) {

        Area area = areaServices.getAreaById(areaId);

        return ResponseEntity.ok(area);
    }

    @CrossOrigin
    @GetMapping("/area")
    public ResponseEntity<List<Area>> getAllAreas() {
        List<Area> areas = areaServices.getAllAreas();

        return ResponseEntity.ok(areas);
    }

    @PostMapping("/area")
    public List<Area> addAreas(@RequestBody List<AreaRequestBody> areas) {
        return areaServices.setAreas(areas);
    }
}
