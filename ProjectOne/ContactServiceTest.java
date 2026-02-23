package contact;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for the ContactService class.
 * Verifies add, delete, and update operations.
 */
public class ContactServiceTest {

    // Test adding a contact successfully
    @Test
    void testAddContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "125 Main Street");

        service.addContact(contact);
        assertDoesNotThrow(() -> service.deleteContact("123"));
    }

    // Test adding duplicate contact ID
    @Test
    void testAddDuplicateContact() {
        ContactService service = new ContactService();
        Contact contact1 = new Contact("123", "John", "Doe", "1234567890", "125 Main Street");
        Contact contact2 = new Contact("123", "Jane", "Doe", "0987654321", "456 Elm Street");

        service.addContact(contact1);
        assertThrows(IllegalArgumentException.class, () -> service.addContact(contact2));
    }

    // Test deleting non-existent contact
    @Test
    void testDeleteNonExistentContact() {
        ContactService service = new ContactService();
        assertThrows(IllegalArgumentException.class, () -> service.deleteContact("999"));
    }

    // Test updating contact fields
    @Test
    void testUpdateContactFields() {
        ContactService service = new ContactService();
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "125 Main Street");

        service.addContact(contact);
        service.updateFirstName("123", "Jane");
        service.updateLastName("123", "Smith");
        service.updatePhone("123", "0987654321");
        service.updateAddress("123", "456 Elm Street");

        assertEquals("Jane", contact.getFirstName());
        assertEquals("Smith", contact.getLastName());
        assertEquals("0987654321", contact.getPhone());
        assertEquals("456 Elm Street", contact.getAddress());
    }
}

