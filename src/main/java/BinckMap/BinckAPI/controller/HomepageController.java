package BinckMap.BinckAPI.controller;

import BinckMap.BinckAPI.entity.Area;
import BinckMap.BinckAPI.entity.Building;
import BinckMap.BinckAPI.services.AreaServices;
import BinckMap.BinckAPI.services.BuildingServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomepageController {

    @Autowired
    private AreaServices areaServices;

    @Autowired
    private BuildingServices buildingServices;

    @GetMapping("/homepage")
    public String homepage(Model model) {
        List<Area> areas = areaServices.getAllAreas();
        List<Building> buildings = buildingServices.getAllBuildings();
        model.addAttribute("areas", areas);
        model.addAttribute("buildings", buildings);

        return "homepage";
    }
}
