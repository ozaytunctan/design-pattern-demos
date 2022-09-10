package com.otunctan.dp.notification;

import java.util.Arrays;

public class EmailNotification extends Notification {
    private String email;
    private String cc[] = {};

    public EmailNotification() {

    }

    @Override
    public NotificationType getNotificationType() {
        return NotificationType.MAIL;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String[] getCc() {
        return cc;
    }

    public void setCc(String[] cc) {
        this.cc = cc;
    }

    @Override
    public String toString() {
        return "EmailNotification{" +
                super.toString()+","+
                "email='" + email + '\'' +
                ", cc=" + Arrays.toString(cc) +
                '}';
    }
}
