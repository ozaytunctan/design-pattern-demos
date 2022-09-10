package com.otunctan.dp.controller;


import com.otunctan.dp.notification.Notification;
import com.otunctan.dp.notification.context.NotificationContext;
import com.otunctan.dp.notification.exceptions.NotificationNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/notification")
public class NotificationController {

    private final NotificationContext notificationContext;

    public NotificationController(NotificationContext notificationContext) {
        this.notificationContext = notificationContext;
    }

    @PostMapping(path = "/send")
    public ResponseEntity<Boolean> sendNotification(@RequestBody Notification notification) throws NotificationNotFoundException {
        notificationContext.sendNotify(notification);
        return ResponseEntity.ok(true);
    }
}
