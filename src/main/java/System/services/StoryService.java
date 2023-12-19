package System.services;

import System.controllers.exceptions.RecordNotFoundException;
import System.dtos.StoryDTO;
import System.entities.Story;
import System.entities.User;
import System.repositories.StoryRepository;
import System.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
public class StoryService {
    private final StoryRepository storyRepository;
    private final UserRepository userRepository;

    public void postStory(StoryDTO storyDTO){
        Optional<User> user = userRepository.findById(storyDTO.getUserId());
        if(user.isPresent()){
            Story story = new Story();
            story.setBody(storyDTO.getBody());
            story.setTitle(storyDTO.getTitle());
            story.setUser(user.get());
            saveStory(story);
        }else {
            throw new RecordNotFoundException();
        }
    }

    public void saveStory(Story story){
        storyRepository.save(story);
    }

    public Optional<Story> getStoryById(Long id){
        return storyRepository.findById(id);
    }

    public Optional<Story> getStoryByTitle(String title){
        return storyRepository.findByTitle(title);
    }

    public Page<Story> getStoriesByUser(User user, int page, int size){
        return storyRepository.findAllByUser(user,PageRequest.of(page, size));
    }

    public Page<Story> getTopStories(int page, int size){
        return storyRepository.findAll(PageRequest.of(page, size));

    }
}
