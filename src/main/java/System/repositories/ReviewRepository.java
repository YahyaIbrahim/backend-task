package System.repositories;

import System.entities.Review;
import System.entities.Story;
import System.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * @author : yahyai
 * @mailto : yibrahim.py@gmail.com
 * @created : 12/19/23
 **/
@Repository
public interface ReviewRepository extends PagingAndSortingRepository<Review, Long>, CrudRepository<Review,Long> {

    Review findByUserAndStory(User user, Story story);
}
