package com.otunctan.dp.notification.impl;

import com.otunctan.dp.notification.NotificationType;
import com.otunctan.dp.notification.Notification;

public interface NotificationSender  {

    void send(Notification notification);

    NotificationType getNotificationType();

}
