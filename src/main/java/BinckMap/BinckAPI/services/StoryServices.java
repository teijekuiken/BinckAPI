package BinckMap.BinckAPI.services;

import BinckMap.BinckAPI.DAO.StoryRepository;
import BinckMap.BinckAPI.controller.model.Request.StoryRequestBody;
import BinckMap.BinckAPI.entity.Area;
import BinckMap.BinckAPI.entity.Building;
import BinckMap.BinckAPI.entity.Story;
import BinckMap.BinckAPI.entity.User;
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
        Building building = buildingServices.getBuildingById(storyRequestBody.getBuildingId());
        Story story = new Story();
        story.setBuilding(building);
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
