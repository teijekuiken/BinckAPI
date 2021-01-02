package BinckMap.BinckAPI.controller;

import BinckMap.BinckAPI.entity.Area;
import BinckMap.BinckAPI.entity.Building;
import BinckMap.BinckAPI.entity.Story;
import BinckMap.BinckAPI.services.AreaServices;
import BinckMap.BinckAPI.services.BuildingServices;
import BinckMap.BinckAPI.services.StoryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

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
        model.addAttribute("storyForm", new Story());

        return "homepage";
    }

    @PostMapping("/homepage")
    public String addStory(@ModelAttribute("storyForm") Story story) {
//todo de return staat tijdelijk op result ipv homepage, zodat je kan zien dat het werkt.
        storyServices.addStory(story.getArea(), story.getBuilding(), story.getSubject(), story.getStory());
        return "result";
    }
}
