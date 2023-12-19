package System;

import System.dtos.StoryDTO;
import System.entities.Story;
import System.entities.User;
import System.services.StoryService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author : yahyai
 * @mailto : yibrahim.py@gmail.com
 * @created : 12/19/23
 **/
@SpringBootTest
public class StoryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private StoryService storyService;

    @Test
    void testPostStory() throws Exception {
        // Create a sample user
        User user = new User("john.doe");

        // Create a sample story
        StoryDTO story = new StoryDTO("Title", "Body", user.getId());

        // Convert the story object to JSON
        String storyJson = objectMapper.writeValueAsString(story);

        // Post the story
        mockMvc.perform(post("/story/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(storyJson))
                .andExpect(status().isOk());

        // Verify that the story is saved
        Story savedStory = storyService.getStoryByTitle(story.getTitle()).get();
        assertNotNull(savedStory);
        assertEquals("Title", savedStory.getTitle());
        assertEquals("Body", savedStory.getBody());
        assertEquals(user, savedStory.getUser());
    }
}
