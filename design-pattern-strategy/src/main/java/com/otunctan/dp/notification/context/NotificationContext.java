package com.otunctan.dp.notification.context;

import com.otunctan.dp.notification.Notification;
import com.otunctan.dp.notification.exceptions.NotificationNotFoundException;
import com.otunctan.dp.notification.impl.NotificationSender;

import java.util.List;

public interface NotificationContext {

   NotificationSender getNotificationSender();

   void sendNotify(Notification notification)throws NotificationNotFoundException;

   void registerNotifications(List<NotificationSender> notificationSenders);

}
