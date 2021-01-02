package BinckMap.BinckAPI.controller;

import BinckMap.BinckAPI.entity.*;
import BinckMap.BinckAPI.services.AreaServices;
import BinckMap.BinckAPI.services.BuildingServices;
import BinckMap.BinckAPI.services.CompanyService;
import BinckMap.BinckAPI.services.StoryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
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
    private CompanyService companyService;

    @Autowired
    private StoryServices storyServices;

    @GetMapping("/homepage")
    public String homepage(Model model) {
        List<Area> areas = areaServices.getAllAreas();
        List<Building> buildings = buildingServices.getAllBuildings();
        List<Company> companies  = companyService.getAllCompanies();
        model.addAttribute("areas", areas);
        model.addAttribute("buildings", buildings);
        model.addAttribute("companies", companies);
        model.addAttribute("storyForm", new Story());

        return "homepage";
    }

    @PostMapping("/homepage")
    public String addStory(@ModelAttribute("storyForm") Story story) {
//todo de return staat tijdelijk op result ipv homepage, zodat je kan zien dat het werkt.
        storyServices.addStory(story);
        return "result";
    }
}
