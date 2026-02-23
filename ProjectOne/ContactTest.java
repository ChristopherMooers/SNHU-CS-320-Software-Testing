package contact;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for the Contact class.
 * These tests verify all validation rules required by the specification.
 */
public class ContactTest {

    // Test successful creation of a valid contact
    @Test
    void testValidContactCreation() {
        Contact contact = new Contact(
                "12345",
                "John",
                "Doe",
                "1234567890",
                "125 Main Street"
        );

        assertEquals("12345", contact.getContactId());
        assertEquals("John", contact.getFirstName());
        assertEquals("Doe", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("125 Main Street", contact.getAddress());
    }

    // Contact ID too long
    @Test
    void testContactIdTooLong() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact("12345678901", "John", "Doe", "1234567890", "125 Main Street")
        );
    }

    // First name too long
    @Test
    void testFirstNameTooLong() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact("12345", "JohnathanXYZ", "Doe", "1234567890", "125 Main Street")
        );
    }

    // Last name too long
    @Test
    void testLastNameTooLong() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact("12345", "John", "DoeDoeDoeDoe", "1234567890", "125 Main Street")
        );
    }

    // Invalid phone number length
    @Test
    void testInvalidPhoneLength() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact("12345", "John", "Doe", "12345", "125 Main Street")
        );
    }

    // Address too long
    @Test
    void testAddressTooLong() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact("12345", "John", "Doe", "1234567890",
                        "This address is definitely more than thirty characters long")
        );
    }
}
