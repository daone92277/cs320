package cs320_module5;

import java.util.Date;

// Appointment.java
public class Appointment {

    // The ID of the appointment.
    private final String appointmentId;

    // The date of the appointment.
    private Date appointmentDate;

    // A description of the appointment.
    private String description;

    // Constructor for the Appointment class.
    // Throws an IllegalArgumentException if the appointment ID, date, or description is invalid.
    public Appointment(String appointmentId, Date appointmentDate, String description) {
        if (appointmentId == null || appointmentId.length() > 10) {
            throw new IllegalArgumentException("Invalid appointment ID");
        }
        if (appointmentDate == null || appointmentDate.before(new Date())) {
            throw new IllegalArgumentException("Invalid appointment date");
        }
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Invalid description");
        }
        this.appointmentId = appointmentId;
        this.appointmentDate = appointmentDate;
        this.description = description;
    }

    // Getters for the appointment ID, date, and description.
    public String getAppointmentId() {
        return appointmentId;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public String getDescription() {
        return description;
    }
}
