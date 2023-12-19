package System.dtos;

import lombok.Data;

/**
 * @author : yahyai
 * @mailto : yibrahim.py@gmail.com
 * @created : 12/19/23
 **/
@Data
public class ReviewDTO {
    private int rate;
    private String comment;
    private long userId;
    private long storyId;

    public ReviewDTO(int rate, String comment, long userId, long storyId) {
        this.rate = rate;
        this.comment = comment;
        this.userId = userId;
        this.storyId = storyId;
    }
}
