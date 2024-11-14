package uni.sliit.pafproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "comments")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    @Id
    private String commentId;
    private String commentDescription;
    private String commentUserId;
    private String commentPostId;
    private String commentHref;
    private String commentSelf;
}
