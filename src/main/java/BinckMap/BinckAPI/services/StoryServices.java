package BinckMap.BinckAPI.services;

import BinckMap.BinckAPI.DAO.StoryRepository;
import BinckMap.BinckAPI.controller.model.Request.StoryRequestBody;
import BinckMap.BinckAPI.entity.*;
import BinckMap.BinckAPI.services.model.StoryResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class StoryServices {
    @Autowired
    private StoryRepository storyRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private BuildingServices buildingServices;

    @Autowired
    private AreaServices areaServices;

    @Autowired
    private CompanyService companyService;


    public Story getStoryById(UUID storyId) {
        Optional<Story> story = storyRepository.findById(storyId);
        if (story.isEmpty()) {
            return null;
        }
        return story.get();
    }

    public List<Story> getAllStories() {
        List<Story> stories = storyRepository.findAll();
        return stories;
    }

    public StoryResponseBody setStory(StoryRequestBody storyRequestBody) {
        User user = userService.getUserById(storyRequestBody.getId());
        Story story = new Story();
        if(storyRequestBody.getAreaId() != 0) {
            Area area = areaServices.getAreaById(storyRequestBody.getAreaId());
            story.setArea(area);
        }
        if(storyRequestBody.getBuildingId() != 0) {
            Building building = buildingServices.getBuildingById(storyRequestBody.getBuildingId());
            story.setBuilding(building);
        }
        if(storyRequestBody.getCompanyId() != 0) {
            Company company = companyService.getCompanyById(storyRequestBody.getCompanyId());
            story.setCompany(company);
        }
        story.setUser(user);
        story.setSubject(storyRequestBody.getSubject());
        story.setStory(storyRequestBody.getVerhaal());

        storyRepository.save(story);

        StoryResponseBody storyResponseBody = new StoryResponseBody(user.getFirstName(), story.getSubject(), story.getStory());

        return storyResponseBody;
    }

    public void addStory(Story story) {
        Area area = new Area();

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();

        User user = userService.getUserByEmail(currentPrincipalName);
        story.setUser(user);
        storyRepository.save(story);
    }

}
