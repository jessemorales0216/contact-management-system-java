import java.util.ArrayList;

public class ContactService {
    // An ArrayList to store contacts
    private ArrayList<Contact> contactList = new ArrayList<>();

    // Method to add a new contact
    public void addContact(Contact contact) {
        for (Contact c : contactList) {
            if (c.getContactId().equals(contact.getContactId())) {
                throw new IllegalArgumentException("Contact ID already exists.");
            }
        }
        contactList.add(contact);
    }

    // Method to remove a contact by contactId
    public void removeContact(String contactId) {
        Contact contactToRemove = null;
        for (Contact c : contactList) {
            if (c.getContactId().equals(contactId)) {
                contactToRemove = c;
                break;
            }
        }
        if (contactToRemove != null) {
            contactList.remove(contactToRemove);
        } else {
            throw new IllegalArgumentException("Contact ID does not exist.");
        }
    }

    // Method to update contact details
    public void updateContact(String contactId, String firstName, String lastName, String phone, String address) {
        for (Contact contact : contactList) {
            if (contact.getContactId().equals(contactId)) {
                if (firstName != null) contact.setFirstName(firstName);
                if (lastName != null) contact.setLastName(lastName);
                if (phone != null) contact.setPhone(phone);
                if (address != null) contact.setAddress(address);
                return;
            }
        }
        throw new IllegalArgumentException("Contact ID does not exist.");
    }

    // Method to retrieve a contact by contactId
    public Contact getContact(String contactId) {
        for (Contact contact : contactList) {
            if (contact.getContactId().equals(contactId)) {
                return contact;
            }
        }
        return null;  // If contact is not found
    }
}
