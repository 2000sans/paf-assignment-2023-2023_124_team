package uni.sliit.pafproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "notifications")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Notification {
    @Id
    private String notificationId;
    private String notificationUserId;
    private String notificationPostId;
    private String notificationHref;
    private String notificationSelf;
}
