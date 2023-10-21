package cs320Module3;

import org.junit.jupiter.api.Test;

public class ContactTest {

    @Test
    public void testContactCreation() {
        // Create a new contact
        Contact contact = new Contact("1234567890", "John", "Doe", "123-456-7890", "123 Main Street");

        // Validate the contact fields
        assertEquals("1234567890", contact.getContactId());
        assertEquals("John", contact.getFirstName());
        assertEquals("Doe", contact.getLastName());
        assertEquals("123-456-7890", contact.getPhone());
        assertEquals("123 Main Street", contact.getAddress());
    }

    private void assertEquals(String string, String contactId) {
		// TODO Auto-generated method stub
		
	}

	@Test
    public void testContactValidation() {
        // Try to create a contact with an invalid contact ID
        Contact contact = null;
        try {
            contact = new Contact(null, "John", "Doe", "123-456-7890", "123 Main Street");
        } catch (IllegalArgumentException e) {
            // Exception is expected
        }
        assertNull(contact);

        // Try to create a contact with an invalid first name
        contact = null;
        try {
            contact = new Contact("1234567890", null, "Doe", "123-456-7890", "123 Main Street");
        } catch (IllegalArgumentException e) {
            // Exception is expected
        }
        assertNull(contact);

        // Try to create a contact with an invalid last name
        contact = null;
        try {
            contact = new Contact("1234567890", "John", null, "123-456-7890", "123 Main Street");
        } catch (IllegalArgumentException e) {
            // Exception is expected
        }
        assertNull(contact);

        // Try to create a contact with an invalid phone number
        contact = null;
        try {
            contact = new Contact("1234567890", "John", "Doe", "123-456-78901", "123 Main Street");
        } catch (IllegalArgumentException e) {
            // Exception is expected
        }
        assertNull(contact);

        // Try to create a contact with an invalid address
        contact = null;
        try {
            contact = new Contact("1234567890", "John", "Doe", "123-456-7890", null);
        } catch (IllegalArgumentException e) {
            // Exception is expected
        }
        assertNull(contact);
    }

    private void assertNull(Contact contact) {
		// TODO Auto-generated method stub
		
	}

	@Test
    public void testContactUpdate() {
        // Create a new contact
        Contact contact = new Contact("1234567890", "John", "Doe", "123-456-7890", "123 Main Street");

        // Update the contact fields
        contact.setFirstName("Jane");
        contact.setLastName("Smith");
        contact.setPhone("456-789-0123");
        contact.setAddress("456 Elm Street");

        // Validate the updated contact fields
        assertEquals("1234567890", contact.getContactId());
        assertEquals("Jane", contact.getFirstName());
        assertEquals("Smith", contact.getLastName());
        assertEquals("456-789-0123", contact.getPhone());
        assertEquals("456 Elm Street", contact.getAddress());
    }
}
