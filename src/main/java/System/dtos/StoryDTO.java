package System.dtos;

import System.entities.User;
import lombok.Data;
import lombok.Getter;

/**
 * @author : yahyai
 * @mailto : yibrahim.py@gmail.com
 * @created : 12/19/23
 **/
@Data
public class StoryDTO {
    private String title;
    private String body;
    private long userId;

    public StoryDTO(String title, String body, long userId) {
        this.title = title;
        this.body = body;
        this.userId = userId;
    }
}
