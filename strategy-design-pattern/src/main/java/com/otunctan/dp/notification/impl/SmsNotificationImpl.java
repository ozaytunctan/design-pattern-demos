package com.otunctan.dp.notification.impl;

import com.otunctan.dp.notification.NotificationType;
import com.otunctan.dp.notification.Notification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class SmsNotificationImpl implements NotificationSender {


    private Logger logger = LoggerFactory.getLogger(SmsNotificationImpl.class);

    @Override
    public void send(Notification notification) {
        logger.info("Send Sms Notification:  "+ notification);
    }

    @Override
    public NotificationType getNotificationType() {
        return NotificationType.SMS;
    }


}
