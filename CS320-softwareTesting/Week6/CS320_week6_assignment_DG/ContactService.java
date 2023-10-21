package cs320Module3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContactService {
    private final Map<String, Contact> contacts = new HashMap<>();

    public Contact addContact(Contact contact) {
        // Validate the input contact
        if (contact == null || contact.getContactId() == null || contact.getContactId().isEmpty() || contact.getContactId().length() > 10) {
            throw new IllegalArgumentException("Contact cannot be null and must have a valid contact ID");
        }

        // Add the contact to the map
        contacts.put(contact.getContactId(), contact);

        // Return the added contact
        return contact;
    }

    public void deleteContact(String contactId) {
        // Validate the input contact ID
        if (contactId == null || contactId.isEmpty()) {
            throw new IllegalArgumentException("Contact ID cannot be null or empty");
        }

        // Remove the contact from the map
        contacts.remove(contactId);
    }

    public Contact updateContact(Contact contact) {
        // Validate the input contact
        if (contact == null || contact.getContactId() == null || contact.getContactId().isEmpty() || contact.getContactId().length() > 10) {
            throw new IllegalArgumentException("Contact cannot be null and must have a valid contact ID");
        }

        // Update the contact in the map
        contacts.put(contact.getContactId(), contact);

        // Return the updated contact
        return contact;
    }

    public Contact getContact(String contactId) {
        // Validate the input contact ID
        if (contactId == null || contactId.isEmpty()) {
            throw new IllegalArgumentException("Contact ID cannot be null or empty");
        }

        // Get the contact from the map
        Contact contact = contacts.get(contactId);

        if (contact == null) {
            throw new IllegalArgumentException("Contact with the given ID does not exist");
        }

        // Return the contact
        return contact;
    }

    public List<Contact> getContacts() {
        return new ArrayList<>(contacts.values());
    }
}
