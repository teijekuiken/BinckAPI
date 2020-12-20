package BinckMap.BinckAPI.controller;

import BinckMap.BinckAPI.entity.Area;
import BinckMap.BinckAPI.entity.Building;
import BinckMap.BinckAPI.services.AreaServices;
import BinckMap.BinckAPI.services.BuildingServices;
import BinckMap.BinckAPI.services.StoryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class HomepageController {

    @Autowired
    private AreaServices areaServices;

    @Autowired
    private BuildingServices buildingServices;

    @Autowired
    private StoryServices storyServices;

    @GetMapping("/homepage")
    public String homepage(Model model) {
        List<Area> areas = areaServices.getAllAreas();
        List<Building> buildings = buildingServices.getAllBuildings();
        model.addAttribute("areas", areas);
        model.addAttribute("buildings", buildings);

        return "homepage";
    }

    //todo
    @PostMapping("/homepage")
    public void newStory(){
        // haal gebied/gebouw op
        //methode die kijkt of het een gebied of verhaal is
        //haal subject op
        //haal verhaal op
        //sla op in database
    }

}
