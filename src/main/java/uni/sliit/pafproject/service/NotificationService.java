package uni.sliit.pafproject.service;


import uni.sliit.pafproject.externalfunctionalities.RandomIdGenerator;
import uni.sliit.pafproject.model.Notification;
import uni.sliit.pafproject.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {
    @Autowired
    private NotificationRepository notification_repository;
    //CRUD CREATE READ UPDATE DELETE

    public Notification addNotification(Notification notification){

        RandomIdGenerator obj = new RandomIdGenerator();
        String generatedNotificationId = obj.getGeneratedId("notification").toString();

        notification.setNotificationId(generatedNotificationId);

        notification.setNotificationHref("http://localhost:8080/notifications");
        notification.setNotificationSelf("http://localhost:8080/notifications/" + generatedNotificationId);

        return notification_repository.save(notification);
    }
    public List<Notification> findAllNotifications(){
        return notification_repository.findAll();

    }

    public Notification getNotificationByNotificationId(String notificationId){
        return notification_repository.findById(notificationId).get();
    }
    public List<Notification> getNotificationByUserId(String notificationUserId){
        return notification_repository.getsNotificationByNotificationUserId(notificationUserId);
    }

    public List<Notification> getNotificationByPostId(String notificationPostId){
        return notification_repository.getsNotificationByNotificationPostId(notificationPostId);
    }
    public Notification updateNotificationDetails(Notification notificationRequest){
        Notification existingNotification = notification_repository.findById(notificationRequest.getNotificationId()).get();
        /*  existingNotification.setNotificationPostId(notificationRequest.getNotificationPostId());    */
        return notification_repository.save(existingNotification);
    }

    public String deleteNotification(String notificationId){
        notification_repository.deleteById(notificationId);
        return notificationId + " notification deleted from database";
    }


}
