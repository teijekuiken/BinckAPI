package BinckMap.BinckAPI.services;

import BinckMap.BinckAPI.DAO.StoryRepository;
import BinckMap.BinckAPI.controller.StoryRequestBody;
import BinckMap.BinckAPI.entity.Story;
import BinckMap.BinckAPI.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class StoryServices {
    @Autowired
    private StoryRepository storyRepository;

    @Autowired
    private UserDetailsService userDetailsService;

    public Story getStoryById(UUID storyId){
        Optional<Story> story = storyRepository.findById(storyId);
        if(story.isEmpty()){
            return null;
        }
        return story.get();
    }

    public List<Story> getAllStories(){
        List<Story> stories = storyRepository.findAll();
        return stories;
    }

    public Story setStory(StoryRequestBody storyRequestBody){
        User user = userDetailsService.getUserById(storyRequestBody.getId());
        Story story = new Story(storyRequestBody.getSubject(), storyRequestBody.getVerhaal(), user, storyRequestBody.getPublicationdate(), storyRequestBody.getCreationDate());

        storyRepository.save(story);

        return story;
    }

}
