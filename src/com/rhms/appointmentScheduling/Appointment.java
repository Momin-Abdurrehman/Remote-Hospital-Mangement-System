package com.rhms.appointmentScheduling;


import java.util.Date;

import com.rhms.userManagement.Doctor;
import com.rhms.userManagement.Patient;

public class Appointment {
    private Date appointmentDate;
    private Doctor doctor;
    private Patient patient;
    private String status; // Pending, Approved, Cancelled

    public Appointment(Date appointmentDate, Doctor doctor, Patient patient, String status) {
        this.appointmentDate = appointmentDate;
        this.doctor = doctor;
        this.patient = patient;
        this.status = status;
    }

    // Getters 
    public Date getAppointmentDate() { return appointmentDate; }
    public Doctor getDoctor() { return doctor; }
    public Patient getPatient() { return patient; }
    //Setters
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    // ovverrriden to String method
    public String toString() {
        return "Appointment with Dr. " + doctor.getName() + " on " + appointmentDate + " for " + patient.getName() + " - Status: " + status;
    }
}
