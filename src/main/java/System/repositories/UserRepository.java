package System.repositories;

import System.entities.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author : yahyai
 * @mailto : yibrahim.py@gmail.com
 * @created : 12/19/23
 **/
@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long> {

    Optional<User> findById(Long id);
}
