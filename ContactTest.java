import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {

    @Test
    public void testValidContact() {
        Contact contact = new Contact("C001", "Jesse", "Morales", "1234567890", "123 Main St");
        assertNotNull(contact);
        assertEquals("C001", contact.getContactId());
        assertEquals("Jesse", contact.getFirstName());
        assertEquals("Morales", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("123 Main St", contact.getAddress());
    }

    @Test
    public void testInvalidContactId() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345678901", "Jesse", "Morales", "1234567890", "123 Main St");
        });
    }

    @Test
    public void testInvalidFirstName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("C002", "JesseLongFirstName", "Morales", "1234567890", "123 Main St");
        });
    }

    @Test
    public void testInvalidLastName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("C003", "Jesse", "MoralesLongLastName", "1234567890", "123 Main St");
        });
    }

    @Test
    public void testInvalidPhone() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("C004", "Jesse", "Morales", "12345", "123 Main St");
        });
    }

    @Test
    public void testInvalidAddress() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("C005", "Jesse", "Morales", "1234567890", "123 Main Street, City, Country, Zip Code");
        });
    }

    @Test
    public void testSetters() {
        Contact contact = new Contact("C006", "Jesse", "Morales", "1234567890", "123 Main St");
        contact.setFirstName("Jane");
        contact.setLastName("Smith");
        contact.setPhone("0987654321");
        contact.setAddress("456 Elm St");

        assertEquals("Jane", contact.getFirstName());
        assertEquals("Smith", contact.getLastName());
        assertEquals("0987654321", contact.getPhone());
        assertEquals("456 Elm St", contact.getAddress());
    }
}
