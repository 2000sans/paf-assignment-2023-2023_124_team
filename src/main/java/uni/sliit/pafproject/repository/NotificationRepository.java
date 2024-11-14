package uni.sliit.pafproject.repository;

import uni.sliit.pafproject.model.Notification;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface NotificationRepository extends MongoRepository<Notification,String> {

    @Query("{notificationUserId:?0 }")
    List<Notification> getsNotificationByNotificationUserId(String notificationUserId);

    @Query("{notificationPostId:?0 }")
    List<Notification> getsNotificationByNotificationPostId(String notificationPostId);

}
