package cs320_module5;

// AppointmentService.java
import java.util.*;

public class AppointmentService {

    // A map of appointment IDs to appointments.
    private Map<String, Appointment> appointments = new HashMap<>();

    // Adds an appointment to the service.
    // Throws an IllegalArgumentException if the appointment ID already exists.
    public void addAppointment(Appointment appointment) {
        if (getAppointments().containsKey(appointment.getAppointmentId())) {
            throw new IllegalArgumentException("Appointment ID already exists");
        }

        // Make a copy of the appointment before adding it to the map.
        // This prevents other developers from modifying the original appointment.
        appointments.put(appointment.getAppointmentId(), new Appointment(appointment.getAppointmentId(), appointment.getAppointmentDate(), appointment.getDescription()));
    }

    // Deletes an appointment from the service.
    public void deleteAppointment(String appointmentId) {
        getAppointments().remove(appointmentId);
    }

    // Gets a map of all appointments in the service.
    // Returns a copy of the map to prevent other developers from modifying the original map.
    public Map<String, Appointment> getAppointments() {
        return new HashMap<>(appointments);
    }

    // Sets the map of appointments in the service.
    public void setAppointments(Map<String, Appointment> appointments) {
        this.appointments = appointments;
    }
}
