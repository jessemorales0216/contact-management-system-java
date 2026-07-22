public class Contact {
    private final String contactId;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;

    // Constructor with validation
    public Contact(String contactId, String firstName, String lastName, String phone, String address) {
        if (contactId == null || contactId.length() > 10) {
            throw new IllegalArgumentException("Contact ID must be at most 10 characters.");
        }
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("First Name must be at most 10 characters.");
        }
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Last Name must be at most 10 characters.");
        }
        if (phone == null || phone.length() != 10) {
            throw new IllegalArgumentException("Phone must be exactly 10 digits.");
        }
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Address must be at most 30 characters.");
        }

        this.contactId = contactId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
    }

    // Getters for all fields
    public String getContactId() { return contactId; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getPhone() { return phone; }
    public String getAddress() { return address; }

    // Setters for updatable fields
    public void setFirstName(String firstName) {
        if (firstName.length() <= 10) this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        if (lastName.length() <= 10) this.lastName = lastName;
    }
    public void setPhone(String phone) {
        if (phone.length() == 10) this.phone = phone;
    }
    public void setAddress(String address) {
        if (address.length() <= 30) this.address = address;
    }
}
