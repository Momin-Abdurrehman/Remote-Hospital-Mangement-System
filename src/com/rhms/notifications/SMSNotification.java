package com.rhms.notifications;

public class SMSNotification implements Notifiable {

    // Sends an SMS notification with recipient, subject, and message
    @Override
    public void sendNotification(String recipient, String subject, String message) {    //simulates it as of now, no real implementation
        System.out.println("\n——————————————————————————————————————");
        System.out.println("           SMS Notification          ");
        System.out.println("——————————————————————————————————————");
        
        System.out.println("  To: " + recipient);             // Display recipient phone number
        System.out.println("  Subject: " + subject);         // Display message subject
        System.out.println("  Message: " + message);         // Display message content
        
        System.out.println("——————————————————————————————————————");
    }

    // Sends an SMS notification with a default subject "SMS Alert"
    public void sendNotification(String phoneNumber, String message) {
        sendNotification(phoneNumber, "SMS Alert", message);  // Default subject
    }
}
