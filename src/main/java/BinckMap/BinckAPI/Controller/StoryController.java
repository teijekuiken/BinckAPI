package BinckMap.BinckAPI.Controller;

import BinckMap.BinckAPI.Controller.model.Story.StoryRequestBody;
import BinckMap.BinckAPI.Entity.Story;
import BinckMap.BinckAPI.Services.StoryServices;
import BinckMap.BinckAPI.Services.Model.Story.StoryResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class StoryController {

    @Autowired
    private StoryServices storyServices;

    @GetMapping("/story/{storyId}")
    public ResponseEntity<Story> getStory(@PathVariable UUID storyId) {

        Story story = storyServices.getStoryById(storyId);

        return ResponseEntity.ok(story);
    }

    @GetMapping("/story")
    public ResponseEntity<List<Story>> getAllStories() {
        List<Story> stories = storyServices.getAllStories();

        return ResponseEntity.ok(stories);
    }

    @PostMapping("/story")
    public StoryResponseBody addStory(@RequestBody StoryRequestBody storyRequestBody) {
        return storyServices.setStory(storyRequestBody);
    }

}
