package System.repositories;

import System.entities.Story;
import System.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author : yahyai
 * @mailto : yibrahim.py@gmail.com
 * @created : 12/19/23
 **/
@Repository
public interface StoryRepository extends PagingAndSortingRepository<Story, Long>, CrudRepository<Story,Long> {

    Page<Story> findAllByUser(User user, Pageable pageable);

    Optional<Story> findById(Long id);

    Optional<Story> findByTitle(String title);
}
