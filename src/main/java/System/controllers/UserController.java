package System.controllers;

import System.entities.Story;
import System.entities.User;
import System.services.StoryService;
import System.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : yahyai
 * @mailto : yibrahim.py@gmail.com
 * @created : 12/19/23
 **/
@RestController
@RequestMapping("/timelines")
@AllArgsConstructor
public class UserController {
    private final StoryService storyService;
    private final UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserStories(@PathVariable String id,
                                            @RequestParam(required = false,defaultValue = "0") int page,
                                            @RequestParam(required = false,defaultValue = "20") int size){

        User user = userService.getUserById(Long.parseLong(id));

        Page<Story> storyPage = storyService.getStoriesByUser(user,page,size);
        List<Story> stories = storyPage.getContent();
        Map<String, Object> response = new HashMap<>();
        response.put("stories", stories);
        response.put("currentPage", storyPage.getNumber());
        response.put("totalItems", storyPage.getTotalElements());
        response.put("totalPages", storyPage.getTotalPages());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
