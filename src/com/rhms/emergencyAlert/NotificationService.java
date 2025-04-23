package com.rhms.emergencyAlert;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.rhms.userManagement.Patient;

public class NotificationService {
    // Notification service configurations
    private static final String EMAIL_SERVER = "smtp.hospital.com";
    private static final String SMS_GATEWAY = "sms.hospital.com";

    // Sends emergency alert through email, SMS, and logs it
    public void sendEmergencyAlert(String message, Patient patient) {
        sendEmail(message, patient);
        sendSMS(message, patient);
        logAlert(message);
    }

    // Sends email notification
    private void sendEmail(String message, Patient patient) {
        System.out.println("Sending email alert to: " + patient.getEmail());
        System.out.println("Message: " + message);
    }

    // Sends SMS notification
    private void sendSMS(String message, Patient patient) {
        System.out.println("Sending SMS alert to: " + patient.getName());
        System.out.println("Message: " + message);
    }

    // Logs alert details with timestamp
    private void logAlert(String message) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println("Alert logged at " + now.format(formatter));
        System.out.println("Alert details: " + message);
    }
}