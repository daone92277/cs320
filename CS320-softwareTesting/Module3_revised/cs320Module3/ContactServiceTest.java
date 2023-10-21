package cs320Module3;

import static org.hamcrest.CoreMatchers.is;

import java.util.List;

import org.hamcrest.Matcher;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {

    private final ContactService contactService = new ContactService();

    @Test
    public void testAddContact() {
        // Create a new contact
        Contact contact = new Contact("1234567890", "John", "Doe", "123-456-7890", "123 Main Street");

        // Add the contact to the service
        contactService.addContact(contact);

        // Validate that the contact was added successfully
        assertThat(contactService.getContacts().size(), is(1));
        assertThat(contactService.getContacts().contains(contact), is(true));
    }

    private void assertThat(boolean contains, Matcher<Boolean> matcher) {
		// TODO Auto-generated method stub
		
	}

	private void assertThat(int size, Matcher<Integer> matcher) {
		// TODO Auto-generated method stub
		
	}

	@Test
    public void testUpdateContact() {
        // Create a new contact
        Contact contact = new Contact("1234567890", "John", "Doe", "123-456-7890", "123 Main Street");

        // Add the contact to the service
        contactService.addContact(contact);

        // Update the contact fields
        contact.setFirstName("Jane");
        contact.setLastName("Smith");
        contact.setPhone("456-789-0123");
        contact.setAddress("456 Elm Street");

        // Update the contact in the service
        contactService.updateContact(contact);

        // Validate that the contact was updated successfully
        assertThat(contactService.getContacts().size(), is(1));
        Contact updatedContact = contactService.getContact("1234567890");
        assertThat(updatedContact.getFirstName(), is("Jane"));
        assertThat(updatedContact.getLastName(), is("Smith"));
        assertThat(updatedContact.getPhone(), is("456-789-0123"));
        assertThat(updatedContact.getAddress(), is("456 Elm Street"));
    }

    private void assertThat(String firstName, Matcher<String> matcher) {
		// TODO Auto-generated method stub
		
	}

	@Test
    public void testDeleteContact() {
        // Create a new contact
        Contact contact = new Contact("1234567890", "John", "Doe", "123-456-7890", "123 Main Street");

        // Add the contact to the service
        contactService.addContact(contact);

        // Delete the contact from the service
        contactService.deleteContact("1234567890");

        // Validate that the contact was deleted successfully
        assertThat(contactService.getContacts().size(), is(0));
        assertThat(contactService.getContacts().contains(contact), is(false));
    }

    @Test
    public void testGetContact() {
        // Create a new contact
        Contact contact = new Contact("1234567890", "John", "Doe", "123-456-7890", "123 Main Street");

        // Add the contact to the service
        contactService.addContact(contact);

        // Get the contact from the service
        Contact retrievedContact = contactService.getContact("1234567890");

        // Validate that the retrieved contact is the same as the added contact
        assertThat(retrievedContact, is(contact));
    }

    private void assertThat(Contact retrievedContact, Matcher<Contact> matcher) {
		// TODO Auto-generated method stub
		
	}

	@Test
    public void testGetContacts() {
        // Create two new contacts
        Contact contact1 = new Contact("1234567890", "John", "Doe", "123-456-7890", "123 Main Street");
        Contact contact2 = new Contact("9876543210", "Jane", "Smith", "456-789-0123", "456 Elm Street");

        // Add the contacts to the service
        contactService.addContact(contact1);
        contactService.addContact(contact2);

        // Get the list of contacts from the service
        List<Contact> contacts = contactService.getContacts();

        // Validate that the list of contacts contains both of the added contacts
        assertThat(contacts.contains(contact1), is(true));
        assertThat(contacts.contains(contact2), is(true));
    }
}
