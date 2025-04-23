package com.rhms.emergencyAlert;

import java.time.LocalDateTime;

import com.rhms.userManagement.Patient;

public class PanicButton {
    // Handles notifications and panic button state
    private NotificationService notificationService;
    private Patient patient;
    private boolean isActive;
    private LocalDateTime lastTriggered;

    // Constructor to initialize panic button for a patient
    public PanicButton(Patient patient) {
        this.patient = patient;
        this.notificationService = new NotificationService();
        this.isActive = true;
        this.lastTriggered = null;
    }

    // Triggers an emergency alert
    public void triggerAlert(String reason) {
        if (!isActive) {
            System.out.println("Panic button is currently disabled.");
            return;
        }

        lastTriggered = LocalDateTime.now();
        String alertMessage = String.format(
            "EMERGENCY: Manual alert triggered by patient %s\n" +
            "Reason: %s\n" +
            "Time: %s\n" +
            "Location: %s",
            patient.getName(),
            reason,
            lastTriggered.toString(),
            patient.getAddress()
        );

        notificationService.sendEmergencyAlert(alertMessage, patient);
    }

    // Enables the panic button
    public void enable() {
        if (isActive) {
            System.out.println("Panic button is already enabled for patient: " + patient.getName());
            return;
        }
        isActive = true;
        System.out.println("Panic button enabled for patient: " + patient.getName());
    }

    // Disables the panic button
    public void disable() {
        if (!isActive) {
            System.out.println("Panic button is already disabled for patient: " + patient.getName());
            return;
        }
        isActive = false;
        System.out.println("Panic button disabled for patient: " + patient.getName());
    }

    // Returns the last triggered timestamp
    public LocalDateTime getLastTriggered() {
        return lastTriggered;
    }

    // Checks if the panic button is active
    public boolean isActive() {
        return isActive;
    }

    // Returns the current status as a string
    public String getStatus() {
        return isActive ? "enabled" : "disabled";
    }
}