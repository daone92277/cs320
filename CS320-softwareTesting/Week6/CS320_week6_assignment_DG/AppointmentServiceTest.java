package cs320_module5;

import static org.junit.Assert.assertEquals;
import java.util.Date;
import org.junit.jupiter.api.BeforeEach;
import org.junit.Test;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

public class AppointmentServiceTest {

    // The AppointmentService object to be tested
    private AppointmentService service;

    // Set up the AppointmentService object before each test
    @BeforeEach
    public void setUp() {
        service = new AppointmentService();
    }

    // Test that appointments can be added and deleted successfully
    @Test
    public void testAddAndDeleteAppointment() {
        // Create an appointment
        Appointment appointment = new Appointment("1234567890", new Date(), "Test appointment");

        // Add the appointment to the service
        service.addAppointment(appointment);

        // Check that the appointment was added successfully
        assertEquals(1, service.getAppointments().size());

        // Delete the appointment from the service
        service.deleteAppointment("1234567890");

        // Check that the appointment was deleted successfully
        assertEquals(0, service.getAppointments().size());
    }

    // Test that multiple appointments can be added and deleted successfully
    @Test
    public void testAddAndDeleteMultipleAppointments() {
        // Create multiple appointments
        Appointment appointment1 = new Appointment("1234567890", new Date(), "Test appointment 1");
        Appointment appointment2 = new Appointment("9876543210", new Date(), "Test appointment 2");

        // Add the appointments to the service
        service.addAppointment(appointment1);
        service.addAppointment(appointment2);

        // Check that the appointments were added successfully
        assertEquals(2, service.getAppointments().size());

        // Delete the appointments from the service
        service.deleteAppointment("1234567890");
        service.deleteAppointment("9876543210");

        // Check that the appointments were deleted successfully
        assertEquals(0, service.getAppointments().size());
    }

    // Test that appointments can be returned by their ID
    @Test
    public void testGetAppointmentById() {
        // Create an appointment
        Appointment appointment = new Appointment("1234567890", new Date(), "Test appointment");

        // Add the appointment to the service
        service.addAppointment(appointment);

        // Get the appointment by its ID
        Appointment appointmentById = service.getAppointmentById("1234567890");

        // Check that the appointment returned is the same as the appointment added
        assertEquals(appointment, appointmentById);
    }

    // Test that appointments can be returned by their date
    @Test
    public void testGetAppointmentsByDate() {
        // Create two appointments with the same date
        Date date = new Date();
        Appointment appointment1 = new Appointment("1234567890", date, "Test appointment 1");
        Appointment appointment2 = new Appointment("9876543210", date, "Test appointment 2");

        // Add the appointments to the service
        service.addAppointment(appointment1);
        service.addAppointment(appointment2);

        // Get the appointments by their date
        List<Appointment> appointmentsByDate = service.getAppointmentsByDate(date);

        // Check that the appointments returned are the same as the appointments added
        assertEquals(2, appointmentsByDate.size());
        assertTrue(appointmentsByDate.contains(appointment1));
        assertTrue(appointmentsByDate.contains(appointment2));
    }
}
