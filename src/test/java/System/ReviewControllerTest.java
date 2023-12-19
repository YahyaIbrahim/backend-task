package System;

import System.dtos.ReviewDTO;
import System.entities.Review;
import System.entities.Story;
import System.entities.User;
import System.services.ReviewService;
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
public class ReviewControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ReviewService reviewService;

    @Autowired
    private StoryService storyService;



    @Test
    void testPostReview() throws Exception {
        // Create a sample user
        User user = new User("john.doe");

        // Create a sample story
        Story story = new Story("Title", "Body", user);

        // Save the story
        storyService.saveStory(story);

        // Create a sample review
        ReviewDTO review = new ReviewDTO(4, "Good post", user.getId(), story.getId());

        // Convert the review object to JSON
        String reviewJson = objectMapper.writeValueAsString(review);

        // Post the review
        mockMvc.perform(post("/review/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(reviewJson))
                .andExpect(status().isOk());

        // Verify that the review is saved
        Review savedReview = reviewService.getByUserAndStory(user,story);
        assertNotNull(savedReview);
        assertEquals(4, savedReview.getRate());
        assertEquals("Good post", savedReview.getComment());
        assertEquals(user, savedReview.getUser());
        assertEquals(story, savedReview.getStory());
    }
}
