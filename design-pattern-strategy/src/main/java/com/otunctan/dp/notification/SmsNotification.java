package com.otunctan.dp.notification;

public class SmsNotification extends Notification {


    private String phoneNumber;

    public SmsNotification(){
        super();
    }
    @Override
    public NotificationType getNotificationType() {
        return NotificationType.SMS;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "SmsNotification{" +
                super.toString()+","+
                "phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
