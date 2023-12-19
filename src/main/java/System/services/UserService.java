package System.services;

import System.controllers.exceptions.UserNotFoundException;
import System.entities.User;
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
public class UserService {
    private final UserRepository userRepository;

    public User getUserById(long id){
        Optional<User> user = userRepository.findById(id);
        if(user.isEmpty())
            throw new UserNotFoundException(id);
        return user.get();
    }
}
