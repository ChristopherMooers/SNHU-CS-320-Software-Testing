import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Date;

public class AppointmentServiceTest {

    @Test
    void testAddAppointment() {
        AppointmentService service = new AppointmentService();
        Date futureDate = new Date(System.currentTimeMillis() + 86400000);
        Appointment appointment = new Appointment("A1", futureDate, "Meeting");

        service.addAppointment(appointment);
        assertNotNull(service.getAppointment("A1"));
    }

    @Test
    void testAddDuplicateAppointmentId() {
        AppointmentService service = new AppointmentService();
        Date futureDate = new Date(System.currentTimeMillis() + 86400000);
        Appointment appointment1 = new Appointment("A1", futureDate, "Meeting");
        Appointment appointment2 = new Appointment("A1", futureDate, "Duplicate");

        service.addAppointment(appointment1);
        assertThrows(IllegalArgumentException.class, () ->
            service.addAppointment(appointment2));
    }

    @Test
    void testDeleteAppointment() {
        AppointmentService service = new AppointmentService();
        Date futureDate = new Date(System.currentTimeMillis() + 86400000);
        Appointment appointment = new Appointment("A1", futureDate, "Meeting");

        service.addAppointment(appointment);
        service.deleteAppointment("A1");

        assertNull(service.getAppointment("A1"));
    }

    @Test
    void testDeleteNonexistentAppointment() {
        AppointmentService service = new AppointmentService();
        assertThrows(IllegalArgumentException.class, () ->
            service.deleteAppointment("Missing"));
    }
}

