package System.controllers;

import System.dtos.StoryDTO;
import System.entities.Story;
import System.objects.Success;
import System.services.StoryService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * @author : yahyai
 * @mailto : yibrahim.py@gmail.com
 * @created : 12/19/23
 **/
@RestController
@RequestMapping("/story")
@AllArgsConstructor
public class StoryController {
    private final StoryService storyService;

    @GetMapping("/top")
    public ResponseEntity<?> getTopStories(@RequestParam(required = false,defaultValue = "0") int page,
                                           @RequestParam(required = false,defaultValue = "20") int size){
        Page<Story> storyPage = storyService.getTopStories(page,size);
        List<Story> stories = storyPage.getContent();

        stories.sort(Comparator.comparingInt(story -> story.getReviews().size()));

        Map<String, Object> response = new HashMap<>();
        response.put("stories", stories);
        response.put("currentPage", storyPage.getNumber());
        response.put("totalItems", storyPage.getTotalElements());
        response.put("totalPages", storyPage.getTotalPages());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> postStory(@RequestBody StoryDTO storyDTO) {
        storyService.postStory(storyDTO);
        return new ResponseEntity<>(new Success(true), HttpStatus.OK);
    }
}
