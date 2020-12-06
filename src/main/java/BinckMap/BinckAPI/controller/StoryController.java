package BinckMap.BinckAPI.controller;

import BinckMap.BinckAPI.entity.Story;
import BinckMap.BinckAPI.services.StoryServices;
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
    public ResponseEntity<Story> getStory(@PathVariable UUID storyId){

        Story story = storyServices.getStoryById(storyId);

        return ResponseEntity.ok(story);
    }

    @GetMapping("/story")
    public ResponseEntity<List<Story>> getAllStories(){
        List<Story> stories = storyServices.getAllStories();

        return ResponseEntity.ok(stories);
    }

    @PostMapping("/story")
    public ResponseEntity<Story> addStory(@RequestBody Story story){
        storyServices.setStory(story);
        return ResponseEntity.ok(story);
    }

}
