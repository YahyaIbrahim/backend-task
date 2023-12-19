package System.services;

import System.dtos.ReviewDTO;
import System.entities.Review;
import System.entities.Story;
import System.entities.User;
import System.repositories.ReviewRepository;
import System.repositories.StoryRepository;
import System.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * @author : yahyai
 * @mailto : yibrahim.py@gmail.com
 * @created : 12/19/23
 **/
@Service
@Transactional
@AllArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final StoryRepository storyRepository;
    private final UserRepository userRepository;


    public void postReview(ReviewDTO reviewDTO){
        Optional<User> user = userRepository.findById(reviewDTO.getUserId());
        Optional<Story> story = storyRepository.findById(reviewDTO.getStoryId());

        if(user.isPresent() && story.isPresent()){
            Review review = new Review();
            review.setRate(reviewDTO.getRate());
            review.setComment(reviewDTO.getComment());
            review.setUser(user.get());
            review.setStory(story.get());
            reviewRepository.save(review);
        }
    }

    public Review getByUserAndStory(User user, Story story){
        return reviewRepository.findByUserAndStory(user,story);

    }
}
