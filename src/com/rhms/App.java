package com.rhms;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.rhms.appointmentScheduling.Appointment;
import com.rhms.appointmentScheduling.AppointmentManager;
import com.rhms.doctorPatientInteraction.ChatClient;
import com.rhms.doctorPatientInteraction.ChatServer;
import com.rhms.doctorPatientInteraction.VideoCall;
import com.rhms.emergencyAlert.EmergencyAlert;
import com.rhms.emergencyAlert.PanicButton;
import com.rhms.healthDataHandling.VitalSign;
import com.rhms.notifications.EmailNotification;
import com.rhms.notifications.ReminderService;
import com.rhms.notifications.SMSNotification;
import com.rhms.userManagement.Doctor;
import com.rhms.userManagement.Patient;

public class App {
    private static ArrayList<Patient> patients = new ArrayList<>();
    private static ArrayList<Doctor> doctors = new ArrayList<>();
    private static AppointmentManager appointmentManager = new AppointmentManager();
    private static EmergencyAlert emergencyAlert = new EmergencyAlert();
    private static Scanner scanner = new Scanner(System.in);
    private static String userType = ""; // Store user type
    private static ChatServer chatServer = new ChatServer();
    private static Map<String, ChatClient> chatClients = new HashMap<>();
    private static ReminderService reminderService = new ReminderService();
    private static SMSNotification smsNotification = new SMSNotification();
    private static EmailNotification emailNotification = new EmailNotification();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n——————————————————————————————————————");
            System.out.println("         Welcome to RHMS System        ");
            System.out.println("——————————————————————————————————————");
            System.out.println("      Please select your user type     ");
            System.out.println("——————————————————————————————————————");
            System.out.println("  1. Patient");
            System.out.println("  2. Doctor");
            System.out.println("  3. Admin");
            System.out.println("  0. Exit System");
            System.out.println("——————————————————————————————————————");
            System.out.print("  Enter your choice: ");
        
            int userTypeChoice = scanner.nextInt();
            scanner.nextLine(); // Clear newline
        
            System.out.println(); // Add a blank line
        
            if (userTypeChoice == 0) {
                System.out.println("Thank you for using RHMS. Goodbye!");
                return;
            }
        
            switch (userTypeChoice) {
                case 1:
                    handlePatientMenu();
                    break;
                case 2:
                    handleDoctorMenu();
                    break;
                case 3:
                    handleAdminMenu();
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
        
    }
    
    private static void handleAdminMenu() {
        while (true) {
            System.out.println("\n——————————————————————————————————————");
            System.out.println("            RHMS Admin Menu            ");
            System.out.println("——————————————————————————————————————");
            System.out.println("  1. Register Patient");
            System.out.println("  2. Register Doctor");
            System.out.println("  3. Upload Vital Signs");
            System.out.println("  4. Schedule Appointment");
            System.out.println("  5. Send Notifications");
            System.out.println("  6. View All Appointments");
            System.out.println("  0. Back to User Selection");
            System.out.println("——————————————————————————————————————");
            System.out.print("  Enter your choice: ");
        
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
        
            System.out.println(); // Blank line for spacing
        
            switch (choice) {
                case 1:
                    registerPatient();
                    break;
                case 2:
                    registerDoctor();
                    break;
                case 3:
                    uploadVitals();
                    break;
                case 4:
                    scheduleAppointment();
                    break;
                case 5:
                    showNotificationMenu();
                    break;
                case 6:
                    viewAllAppointments();
                    break;
                case 0:
                    return; // Go back to main menu
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
        
    }
    
    private static void handlePatientMenu() {
        while (true) {
            System.out.println("\n——————————————————————————————————————");
            System.out.println("           RHMS Patient Menu           ");
            System.out.println("——————————————————————————————————————");
            System.out.println("  1. Schedule an Appointment");
            System.out.println("  2. View Patient Vitals");
            System.out.println("  3. Provide Doctor Feedback");
            System.out.println("  4. Trigger Emergency Alert");
            System.out.println("  5. Enable/Disable Panic Button");
            System.out.println("  6. Join Video Consultation");
            System.out.println("  7. Open Chat");
            System.out.println("  0. Back to User Selection");
            System.out.println("——————————————————————————————————————");
            System.out.print("  Enter your choice: ");
        
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
        
            System.out.println(); // Blank line for spacing
        
            switch (choice) {
                case 1:
                    scheduleAppointment();
                    break;
                case 2:
                    viewVitals();
                    break;
                case 3:
                    provideFeedback();
                    break;
                case 4:
                    triggerEmergencyAlert();
                    break;
                case 5:
                    togglePanicButton();
                    break;
                case 6:
                    joinVideoConsultation();
                    break;
                case 7:
                    openChat();
                    break;
                case 0:
                    return; // Go back to user selection
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
        
    }
    

        private static void handleDoctorMenu() {
            while (true) {
                System.out.println("\n——————————————————————————————————————");
                System.out.println("            RHMS Doctor Menu           ");
                System.out.println("——————————————————————————————————————");
                System.out.println("  1. Approve Appointment");
                System.out.println("  2. Cancel Appointment");
                System.out.println("  3. View Patient Vitals");
                System.out.println("  4. Start Video Consultation");
                System.out.println("  5. Open Chat");
                System.out.println("  0. Back to User Selection");
                System.out.println("——————————————————————————————————————");
                System.out.print("  Enter your choice: ");
        
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline
        
                System.out.println(); // Blank line for spacing
        
                switch (choice) {
                    case 1:
                        approveAppointment();
                        break;
                    case 2:
                        cancelAppointment();
                        break;
                    case 3:
                        viewVitals();
                        break;
                    case 4:
                        startVideoConsultation();
                        break;
                    case 5:
                        openChat();
                        break;
                    case 0:
                        return; // Go back to user selection
                    default:
                        System.out.println("Invalid choice! Please try again.");
                }
            }
        }
        
    

        private static void showAdminMenu() {
            System.out.println("\n——————————————————————————————————————");
            System.out.println("            RHMS Admin Menu            ");
            System.out.println("——————————————————————————————————————");
            System.out.println("  1. Register Patient");
            System.out.println("  2. Register Doctor");
            System.out.println("  3. Schedule Appointment");
            System.out.println("  4. Send Notifications");
            System.out.println("  5. View All Appointments");
            System.out.println("  0. Back to User Selection");
            System.out.println("——————————————————————————————————————");
            System.out.print("  Enter your choice: ");
        
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
        
            System.out.println(); // Blank line for spacing
        
            switch (choice) {
                case 1:
                    registerPatient();
                    break;
                case 2:
                    registerDoctor();
                    break;
                case 3:
                    scheduleAppointment();
                    break;
                case 4:
                    sendNotification(); // Send notifications
                    break;
                case 5:
                    viewAllAppointments();
                    break;
                case 0:
                    return; // Go back to user selection
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
        

        private static void showPatientMenu() {
            System.out.println("\n——————————————————————————————————————");
            System.out.println("             RHMS Patient Menu          ");
            System.out.println("——————————————————————————————————————");
            System.out.println("  1. Schedule an Appointment");
            System.out.println("  2. View Patient Vitals");
            System.out.println("  3. Provide Doctor Feedback");
            System.out.println("  4. Trigger Emergency Alert");
            System.out.println("  5. Enable/Disable Panic Button");
            System.out.println("  6. Join Video Consultation");
            System.out.println("  7. Open Chat");
            System.out.println("  9. Back to User Selection");
            System.out.println("  0. Exit");
            System.out.println("——————————————————————————————————————");
            System.out.print("  Enter your choice: ");
        }
        

        private static void showDoctorMenu() {
            System.out.println("\n——————————————————————————————————————");
            System.out.println("             RHMS Doctor Menu          ");
            System.out.println("——————————————————————————————————————");
            System.out.println("  1. Approve Appointment");
            System.out.println("  2. Cancel Appointment");
            System.out.println("  3. Upload Vital Signs");
            System.out.println("  4. View Patient Vitals");
            System.out.println("  5. Start Video Consultation");
            System.out.println("  6. Open Chat");
            System.out.println("  9. Back to User Selection");
            System.out.println("  0. Exit");
            System.out.println("——————————————————————————————————————");
            System.out.print("  Enter your choice: ");
        }
        

        private static void registerPatient() {
            System.out.println("\n——————————————————————————————————————");
            System.out.println("             Register New Patient      ");
            System.out.println("——————————————————————————————————————");
            
            System.out.print("  Enter Patient Name: ");
            String name = scanner.nextLine();
            
            System.out.print("  Enter Email: ");
            String email = scanner.nextLine();
            
            System.out.print("  Enter Password: ");
            String password = scanner.nextLine();
            
            System.out.print("  Enter Phone: ");
            String phone = scanner.nextLine();
            
            System.out.print("  Enter Address: ");
            String address = scanner.nextLine();
            
            System.out.print("  Enter User ID: ");
            int userID = scanner.nextInt();
            scanner.nextLine(); // Consume newline
        
            Patient patient = new Patient(name, email, password, phone, address, userID);
            patients.add(patient);
            
            System.out.println("——————————————————————————————————————");
            System.out.println("  Patient " + name + " registered successfully.");
            System.out.println("——————————————————————————————————————");
        }

        private static void registerDoctor() {
            System.out.println("\n——————————————————————————————————————");
            System.out.println("             Register New Doctor      ");
            System.out.println("——————————————————————————————————————");
        
            System.out.print("  Enter Doctor Name: ");
            String name = scanner.nextLine();
            
            System.out.print("  Enter Email: ");
            String email = scanner.nextLine();
            
            System.out.print("  Enter Password: ");
            String password = scanner.nextLine();
            
            System.out.print("  Enter Phone: ");
            String phone = scanner.nextLine();
            
            System.out.print("  Enter Address: ");
            String address = scanner.nextLine();
            
            System.out.print("  Enter User ID: ");
            int userID = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            System.out.print("  Enter Specialization: ");
            String specialization = scanner.nextLine();
            
            System.out.print("  Enter Years of Experience: ");
            int experienceYears = scanner.nextInt();
            scanner.nextLine(); // Consume newline
        
            Doctor doctor = new Doctor(name, email, password, phone, address, userID, specialization, experienceYears);
            doctors.add(doctor);
        
            System.out.println("——————————————————————————————————————");
            System.out.println("  Doctor " + name + " registered successfully.");
            System.out.println("——————————————————————————————————————");
        }
        

    private static void scheduleAppointment() {
        if (patients.isEmpty() || doctors.isEmpty()) {
            System.out.println("Error: Register at least one patient and one doctor first.");
            return;
        }

        System.out.print("Enter Patient Name: ");
        String patientName = scanner.nextLine();
        Patient patient = findPatient(patientName);
        if (patient == null) {
            System.out.println("Patient not found!");
            return;
        }

        System.out.print("Enter Doctor Name: ");
        String doctorName = scanner.nextLine();
        Doctor doctor = findDoctor(doctorName);
        if (doctor == null) {
            System.out.println("Doctor not found!");
            return;
        }

        System.out.print("Enter Appointment Date (yyyy-MM-dd): ");
        Date appointmentDate = null;
        while (appointmentDate == null) {
            try {
                String appointmentDateInput = scanner.nextLine();
                if (!appointmentDateInput.matches("\\d{4}-\\d{2}-\\d{2}")) {
                    throw new IllegalArgumentException("Invalid date format. Please use yyyy-MM-dd");
                }
                appointmentDate = java.sql.Date.valueOf(appointmentDateInput);
                
                // Check if date is in the future
                if (appointmentDate.before(new Date())) {
                    System.out.println("Cannot schedule appointment in the past.");
                    System.out.print("Enter Appointment Date (yyyy-MM-dd): ");
                    appointmentDate = null;
                    continue;
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
                System.out.print("Please enter date in format yyyy-MM-dd (e.g., 2024-04-20): ");
            }
        }

        String appointmentDetails = "Appointment on " + appointmentDate.toString();
        patient.scheduleAppointment(appointmentDetails);
        doctor.manageAppointment(appointmentDetails);

        Appointment appointment = new Appointment(appointmentDate, doctor, patient, "Pending");
        appointmentManager.getAppointments().add(appointment);

        // Send confirmation notifications
        String subject = "Appointment Confirmation";
        String message = String.format("Your appointment with Dr. %s is scheduled for %s", 
            doctor.getName(), appointmentDate.toString());
        
        emailNotification.sendNotification(patient.getEmail(), subject, message);
        smsNotification.sendNotification(patient.getPhone(), subject, message);
        
        System.out.println("Appointment scheduled successfully!");
    }

    private static void approveAppointment() {
        if (appointmentManager.getAppointments().isEmpty()) {
            System.out.println("No appointments found.");
            return;
        }
        appointmentManager.getAppointments().get(0).setStatus("Approved");
        System.out.println("Appointment Approved!");
    }

    private static void cancelAppointment() {
        if (appointmentManager.getAppointments().isEmpty()) {
            System.out.println("No appointments to cancel.");
            return;
        }
        appointmentManager.getAppointments().get(0).setStatus("Cancelled");
        System.out.println("Appointment Cancelled!");
    }

    private static void uploadVitals() {
        System.out.print("Enter Patient Name: ");
        String name = scanner.nextLine();
        Patient patient = findPatient(name);
        if (patient == null) {
            System.out.println("Patient not found!");
            return;
        }

        System.out.print("Enter Heart Rate: ");
        double heartRate = scanner.nextDouble();
        System.out.print("Enter Oxygen Level: ");
        double oxygenLevel = scanner.nextDouble();
        System.out.print("Enter Blood Pressure: ");
        double bloodPressure = scanner.nextDouble();
        System.out.print("Enter Temperature: ");
        double temperature = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        // Create vital sign record
        VitalSign vitals = new VitalSign(heartRate, oxygenLevel, bloodPressure, temperature);
        
        // Check for emergency conditions
        emergencyAlert.checkVitals(patient, vitals);

        // Store vitals record
        String vitalsRecord = String.format("HR: %.1f, O2: %.1f%%, BP: %.1f, Temp: %.1f°C", 
            heartRate, oxygenLevel, bloodPressure, temperature);
        patient.uploadMedicalRecord(vitalsRecord);

        System.out.println("Vitals uploaded successfully!");
    }

    private static void viewVitals() {
        System.out.print("Enter Patient Name: ");
        String name = scanner.nextLine();
        Patient patient = findPatient(name);
        if (patient == null) {
            System.out.println("Patient not found!");
            return;
        }

        System.out.println("\nMedical Records:");
        for (String record : patient.getDoctorFeedback()) {
            System.out.println(record);
        }
    }

    private static void provideFeedback() {
        System.out.print("Enter Doctor Name: ");
        String doctorName = scanner.nextLine();
        Doctor doctor = findDoctor(doctorName);
        if (doctor == null) {
            System.out.println("Doctor not found!");
            return;
        }

        System.out.print("Enter Patient Name: ");
        String patientName = scanner.nextLine();
        Patient patient = findPatient(patientName);
        if (patient == null) {
            System.out.println("Patient not found!");
            return;
        }

        System.out.print("Enter Feedback: ");
        String feedback = scanner.nextLine();

        doctor.provideFeedback(patient, feedback);
        System.out.println("Feedback recorded successfully!");
    }

    private static void triggerEmergencyAlert() {
        System.out.print("Enter patient name: ");
        String name = scanner.nextLine();
        Patient patient = findPatient(name);
        if (patient == null) {
            System.out.println("Patient not found!");
            return;
        }

        System.out.print("Enter emergency reason: ");
        String reason = scanner.nextLine();

        PanicButton panicButton = new PanicButton(patient);
        panicButton.triggerAlert(reason);
    }

    private static void togglePanicButton() {
        System.out.print("Enter patient name: ");
        String name = scanner.nextLine();
        Patient patient = findPatient(name);
        if (patient == null) {
            System.out.println("Patient not found!");
            return;
        }

        System.out.println("\nCurrent panic button status: " + patient.getPanicButton().getStatus());
        System.out.println("1. Enable Panic Button");
        System.out.println("2. Disable Panic Button");
        System.out.println("0. Back");
        System.out.print("Choose an option: ");
        
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        switch (choice) {
            case 1:
                patient.enablePanicButton();
                break;
            case 2:
                patient.disablePanicButton();
                break;
            case 0:
                return;
            default:
                System.out.println("Invalid choice!");
        }
    }

    private static void startVideoConsultation() {
        System.out.print("Enter patient name: ");
        String patientName = scanner.nextLine();
        Patient patient = findPatient(patientName);
        if (patient == null) {
            System.out.println("Patient not found!");
            return;
        }

        String meetingId = VideoCall.generateMeetingId();
        System.out.println("Starting video consultation...");
        System.out.println("Meeting ID: " + meetingId);
        
        VideoCall.startVideoCall(meetingId);
    }

    private static void joinVideoConsultation() {
        System.out.print("Enter meeting ID: ");
        String meetingId = scanner.nextLine();
        
        VideoCall.startVideoCall(meetingId);
    }

    private static void openChat() {
        System.out.print("Enter the name of user to chat with: ");
        String otherUser = scanner.nextLine();
        
        if (userType.equals("Doctor")) {
            Patient patient = findPatient(otherUser);
            if (patient == null) {
                System.out.println("Patient not found!");
                return;
            }
            otherUser = patient.getName();
        } else {
            Doctor doctor = findDoctor(otherUser);
            if (doctor == null) {
                System.out.println("Doctor not found!");
                return;
            }
            otherUser = doctor.getName();
        }

        ChatClient chatClient = chatClients.computeIfAbsent(
            userType.equals("Doctor") ? otherUser : otherUser,
            name -> new ChatClient(
                userType.equals("Doctor") ? findDoctor(userType) : findPatient(userType),
                chatServer
            )
        );

        while (true) {
            System.out.println("\n1. Send Message");
            System.out.println("2. View Chat History");
            System.out.println("0. Back");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            switch (choice) {
                case 1:
                    System.out.print("Enter message: ");
                    String message = scanner.nextLine();
                    chatClient.sendMessage(otherUser, message);
                    break;
                case 2:
                    chatClient.displayChat(otherUser);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    private static Patient findPatient(String name) {
        for (Patient patient : patients) {
            if (patient.getName().equalsIgnoreCase(name)) {
                return patient;
            }
        }
        return null;
    }

    private static Doctor findDoctor(String name) {
        for (Doctor doctor : doctors) {
            if (doctor.getName().equalsIgnoreCase(name)) {
                return doctor;
            }
        }
        return null;
    }

    private static void sendNotification() {
        System.out.println("\n===== Send Notification =====");
        System.out.print("Enter the patient's name: ");
        String patientName = scanner.nextLine();
        
        // Check if the patient exists
        Patient targetPatient = null;
        for (Patient patient : patients) {
            if (patient.getName().equalsIgnoreCase(patientName)) {
                targetPatient = patient;
                break;
            }
        }
        
        if (targetPatient == null) {
            System.out.println("Error: Patient with name '" + patientName + "' does not exist.");
            return; // Exit the method immediately to avoid waiting for further input
        }
        
        // Proceed only if the patient exists
        System.out.println("Choose notification type:");
        System.out.println("1. Email");
        System.out.print("Enter your choice: ");
        
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the leftover newline character
        
        System.out.print("Enter your custom message: ");
        String message = scanner.nextLine();
        
        switch (choice) {    
            case 1:
                emailNotification.sendNotification(targetPatient.getEmail(), "Custom Message", message);
                System.out.println("Email sent to " + targetPatient.getName());
                break;
            default:
                System.out.println("Invalid choice! Notification not sent.");
        }
    }

    private static void sendAppointmentReminder(Patient patient) {
        System.out.print("Enter appointment date (e.g., tomorrow 2:30 PM): ");
        String appointmentTime = scanner.nextLine();
        
        String subject = "Appointment Reminder";
        String message = String.format("Dear %s, you have an appointment scheduled for %s.", 
            patient.getName(), appointmentTime);
        
        smsNotification.sendNotification(patient.getPhone(), subject, message);
        reminderService.sendImmediateReminder(patient, subject, message);
    }

    private static void sendMedicationReminder(Patient patient) {
        System.out.print("Enter medication name: ");
        String medication = scanner.nextLine();
        System.out.print("Enter schedule (e.g., twice daily): ");
        String schedule = scanner.nextLine();
        
        reminderService.scheduleMedicationReminder(patient, medication, schedule);
        System.out.println("Medication reminder set successfully!");
    }

    private static void sendCustomMessage(Patient patient) {
        System.out.print("Enter message subject: ");
        String subject = scanner.nextLine();
        System.out.print("Enter message content: ");
        String message = scanner.nextLine();
        
        smsNotification.sendNotification(patient.getPhone(), subject, message);
        System.out.println("Custom message sent successfully!");
    }

    private static void showNotificationMenu() {
        while (true) {
            System.out.println("\n===== Notification Menu =====");
            System.out.println("1. Send Email");
            System.out.println("2. Send SMS");
            System.out.println("3. Send Both Email and SMS");
            System.out.println("0. Back");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (choice == 0) return;

            System.out.print("Enter patient name: ");
            String patientName = scanner.nextLine();
            Patient patient = findPatient(patientName);
            
            if (patient == null) {
                System.out.println("Patient not found!");
                continue;
            }

            System.out.print("Enter subject: ");
            String subject = scanner.nextLine();
            System.out.print("Enter message: ");
            String message = scanner.nextLine();

            switch (choice) {
                case 1:
                    emailNotification.sendNotification(patient.getEmail(), subject, message);
                    break;
                case 2:
                    smsNotification.sendNotification(patient.getPhone(), subject, message);
                    break;
                case 3:
                    emailNotification.sendNotification(patient.getEmail(), subject, message);
                    smsNotification.sendNotification(patient.getPhone(), subject, message);
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    private static void viewAllAppointments() {
        System.out.println("\n=== All Appointments ===");
        for (Appointment appointment : appointmentManager.getAppointments()) {
            System.out.println(appointment);
        }
    }
}

