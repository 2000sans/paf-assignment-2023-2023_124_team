package uni.sliit.pafproject.controller;


import uni.sliit.pafproject.model.Notification;
import uni.sliit.pafproject.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notifications")
public class NotificationController {
    @Autowired
    private NotificationService notification_service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Notification createNotification(@RequestBody Notification notification){
        return notification_service.addNotification(notification);
    }
    @GetMapping
    public List<Notification> getNotifications(){
        return notification_service.findAllNotifications();

    }
    @GetMapping("/{notificationId}")
    public Notification getNotification(@PathVariable String notificationId){
        return notification_service.getNotificationByNotificationId(notificationId);
    }
    @GetMapping("/notification_user_id/{notificationUserId}")
    public List<Notification> findNotificationUsingNotificationUserId(@PathVariable String notificationUserId){
        return notification_service.getNotificationByUserId(notificationUserId);
    }

    @GetMapping("/notification_post_id/{notificationPostId}")
    public List<Notification> findNotificationUsingNotificationPostId(@PathVariable String notificationPostId){
        return notification_service.getNotificationByPostId(notificationPostId);
    }

    @PutMapping
    public Notification modifyNotification(@RequestBody Notification notification){
        return notification_service.updateNotificationDetails(notification);

    }
    @DeleteMapping("/{notificationId}")
    public String deleteNotification(@PathVariable String notificationId){
        return notification_service.deleteNotification(notificationId);
    }
}
