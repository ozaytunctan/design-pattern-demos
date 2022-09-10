package com.otunctan.dp.notification.context;

import com.otunctan.dp.notification.NotificationType;
import com.otunctan.dp.notification.Notification;
import com.otunctan.dp.notification.exceptions.NotificationNotFoundException;
import com.otunctan.dp.notification.impl.NotificationSender;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

@Component
@Configuration
public class NotificationSenderContext implements NotificationContext {


    private final List<NotificationSender> notificationSenders;
    private Map<NotificationType, NotificationSender> notificationSenderMap;
    private NotificationSender notificationSender = null;


    public NotificationSenderContext(List<NotificationSender> notificationSenders) {
        this.notificationSenders = notificationSenders;
        this.notificationSenderMap = new EnumMap<NotificationType, NotificationSender>(NotificationType.class);
        this.registerNotifications(notificationSenders);
    }


    @Override
    public void registerNotifications(List<NotificationSender> notificationSenders) {
        if (notificationSenders != null && !notificationSenders.isEmpty()) {
            notificationSenders.forEach(notificationSender -> {
                        this.notificationSenderMap.put(notificationSender.getNotificationType(), notificationSender);
                    }
            );
        }
    }


    @Override
    public NotificationSender getNotificationSender() {
        return this.notificationSender;
    }

    public static NotificationSenderContext getNotificationContext() {
        return new NotificationSenderContext(new ArrayList<>());
    }

    @Override
    public void sendNotify(Notification notification) throws NotificationNotFoundException {
        if (notification == null || notification.getNotificationType() == null) {
            throw new NotificationNotFoundException("Notification type is null");
        }

        NotificationType notificationType = notification.getNotificationType();
        this.notificationSender = notificationSenderMap.getOrDefault(notificationType, null);

        if (this.notificationSender == null) {
            throw new NotificationNotFoundException("Notification type not found. type: " + notificationType);
        }

        //sen notification
        this.notificationSender.send(notification);
    }
}
