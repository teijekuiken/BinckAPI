package BinckMap.BinckAPI.Services;

import BinckMap.BinckAPI.DAO.StoryRepository;
import BinckMap.BinckAPI.Controller.model.Story.StoryRequestBody;
import BinckMap.BinckAPI.Entity.Story;
import BinckMap.BinckAPI.Entity.User;
import BinckMap.BinckAPI.Services.Model.Story.StoryResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class StoryServices {
    @Autowired
    private StoryRepository storyRepository;

    @Autowired
    private UserDetailsService userDetailsService;

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
        User user = userDetailsService.getUserById(storyRequestBody.getId());
        Story story = new Story(storyRequestBody.getSubject(), storyRequestBody.getVerhaal(), user, storyRequestBody.getPublicationDate(), storyRequestBody.getCreationDate());

        storyRepository.save(story);

        StoryResponseBody storyResponseBody = new StoryResponseBody(user.getFirstName(), story.getSubject(), story.getStory());

        return storyResponseBody;
    }

}
