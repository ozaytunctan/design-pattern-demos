package com.otunctan.dp.notification;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.io.Serializable;
import java.time.LocalDateTime;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "notificationType")
@JsonSubTypes({
        @JsonSubTypes.Type(value = SmsNotification.class, name = "SMS"),
        @JsonSubTypes.Type(value = EmailNotification.class, name = "MAIL"),
        @JsonSubTypes.Type(value = SiteNotification.class, name = "SITE")
})
public abstract class Notification implements Serializable {

    private String message;

    private LocalDateTime createdDate = LocalDateTime.now();

    private NotificationType notificationType;

    public abstract NotificationType getNotificationType();

    public void setNotificationType(NotificationType notificationType) {
        this.notificationType = notificationType;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return "message='" + message + '\'' +
                ", createdDate=" + createdDate +
                ", notificationType=" + getNotificationType();
    }
}
