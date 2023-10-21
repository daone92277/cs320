package cs320_module5;

import static org.junit.Assert.assertEquals;
import java.util.Date;
import org.junit.Test;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AppointmentTest {

    // Test that an appointment is created with a valid ID
    @Test
    public void testAppointmentId() {
        Appointment appointment = new Appointment("1234567890", new Date(), "Test appointment");
        assertEquals("1234567890", appointment.getAppointmentId());
    }

    // Test that the appointment ID is not greater than 10 characters
    @Test
    public void testAppointmentIdLength() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("12345678901", new Date(), "Test appointment");
        });
    }

    // Test that a date cannot be null
    @Test
    public void testAppointmentDateNotNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("1234567890", null, "Test appointment");
        });
    }

    // Test that a date cannot be in the past
    @Test
    public void testAppointmentDateNotInPast() {
        Date pastDate = new Date(System.currentTimeMillis() - 86400000); // 24 hours ago
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("1234567890", pastDate, "Test appointment");
        });
    }

    // Test that the description cannot be null
    @Test
    public void testDescriptionNotNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("1234567890", new Date(), null);
        });
    }

    // Test that the description cannot be greater than 50 characters
    @Test
    public void testDescriptionLength() {
        String longDescription = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed euismod.";
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("1234567890", new Date(), longDescription);
        });
    }

    // Test that appointments can be created correctly
    @Test
    public void testAppointmentCreation() {
        Appointment appointment = new Appointment("1234567890", new Date(), "Test appointment");
        assertEquals("1234567890", appointment.getAppointmentId());
        assertEquals(new Date(), appointment.getAppointmentDate());
        assertEquals("Test appointment", appointment.getDescription());
    }
}
