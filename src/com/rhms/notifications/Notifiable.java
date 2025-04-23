package com.rhms.notifications;

// Interface for different types of notifications
public interface Notifiable {
    void sendNotification(String recipient, String subject, String message);
}