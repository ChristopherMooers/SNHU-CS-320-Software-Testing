import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Date;

public class AppointmentTest {

    @Test
    void testValidAppointmentCreation() {
        Date futureDate = new Date(System.currentTimeMillis() + 86400000);
        Appointment appointment = new Appointment("12345", futureDate, "Doctor visit");

        assertEquals("12345", appointment.getAppointmentId());
        assertEquals(futureDate, appointment.getAppointmentDate());
        assertEquals("Doctor visit", appointment.getDescription());
    }

    @Test
    void testInvalidAppointmentId() {
        Date futureDate = new Date(System.currentTimeMillis() + 86400000);
        assertThrows(IllegalArgumentException.class, () ->
            new Appointment(null, futureDate, "Test"));
    }

    @Test
    void testPastAppointmentDate() {
        Date pastDate = new Date(System.currentTimeMillis() - 86400000);
        assertThrows(IllegalArgumentException.class, () ->
            new Appointment("123", pastDate, "Test"));
    }

    @Test
    void testInvalidDescription() {
        Date futureDate = new Date(System.currentTimeMillis() + 86400000);
        String longDescription = "This description is way too long and exceeds fifty characters total";
        assertThrows(IllegalArgumentException.class, () ->
            new Appointment("123", futureDate, longDescription));
    }
}
