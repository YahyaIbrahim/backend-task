package System.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import java.util.Set;

/**
 * @author : yahyai
 * @mailto : yibrahim.py@gmail.com
 * @created : 12/19/23
 **/
@Entity
@Table(name = "story")
@Getter
@Setter
@ToString
public class Story {
    @Id
    @Column(name = "id")
    @GeneratedValue(
            strategy = GenerationType.AUTO,
            generator = "native"
    )
    @GenericGenerator(
            name = "native"
    )
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "body")
    private String body;

    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JsonIgnore
    private User user;

    @OneToMany(mappedBy = "story",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Review> reviews;

    public Story(String title, String body, User user) {
        this.title = title;
        this.body = body;
        this.user = user;
    }

    public Story() {

    }
}
