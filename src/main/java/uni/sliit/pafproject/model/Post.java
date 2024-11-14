package uni.sliit.pafproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "posts")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    @Id
    private String postId;
    private String postUserId;
    private String postTopic;
    private String postDescription;
    private int postLikeCount;
    private int postDisLikeCount;
    private int postNeutralCount;
    private String postHref;
    private String postSelf;
}
