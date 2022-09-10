package com.otunctan.dp.notification;

public class SiteNotification extends Notification {

    private String siteName;

    private String siteId;

    @Override
    public NotificationType getNotificationType() {
        return NotificationType.SITE;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }


    @Override
    public String toString() {
        return "SiteNotification{" +
                super.toString()+","+
                "siteName='" + siteName + '\'' +
                ", siteId='" + siteId + '\'' +
                '}';
    }
}
