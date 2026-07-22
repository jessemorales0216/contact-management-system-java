import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactServiceTest {

    @Test
    public void testAddContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact("C001", "Jesse", "Morales", "1234567890", "123 Main St");
        service.addContact(contact);
        assertNotNull(service.getContact("C001"));
    }

    @Test
    public void testRemoveContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact("C001", "Jesse", "Morales", "1234567890", "123 Main St");
        service.addContact(contact);
        service.removeContact("C001");
        assertNull(service.getContact("C001"));
    }

    @Test
    public void testUpdateContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact("C001", "Jesse", "Morales", "1234567890", "123 Main St");
        service.addContact(contact);
        service.updateContact("C001", "Jesse", "M", "0987654321", "456 Elm St");
        assertEquals("Jesse", contact.getFirstName());
        assertEquals("0987654321", contact.getPhone());
    }

    @Test
    public void testAddDuplicateContact() {
        ContactService service = new ContactService();
        Contact contact1 = new Contact("C001", "Jesse", "Morales", "1234567890", "123 Main St");
        Contact contact2 = new Contact("C001", "Jane", "Doe", "0987654321", "456 Elm St");
        service.addContact(contact1);
        assertThrows(IllegalArgumentException.class, () -> service.addContact(contact2));
    }

    @Test
    public void testRemoveNonExistingContact() {
        ContactService service = new ContactService();

        assertThrows(IllegalArgumentException.class, () -> {
        service.removeContact("NonExistingId");
    });
}
}
