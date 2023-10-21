package com.snhu.davidgreene.module3;

import java.util.HashMap;
import java.util.Map;

public class ContactService {
    private Map<String, Contact> contacts;

    public ContactService() {
        this.contacts = new HashMap<>();
    }

    public void addContact(Contact contact) {
        contacts.put(contact.getContactId(), contact);
    }

    public void deleteContact(String contactId) {
        contacts.remove(contactId);
    }

    public void updateContact(String contactId, String field, String value) {
        Contact contact = contacts.get(contactId);
        if (contact != null) {
            switch (field) {
                case "firstName":
                    contact.setFirstName(value);
                    break;
                case "lastName":
                    contact.setLastName(value);
                    break;
                case "phone":
                    contact.setPhone(value);
                    break;
                case "address":
                    contact.setAddress(value);
                    break;
                default:
                    System.out.println("Invalid field");
            }
        } else {
            System.out.println("Contact not found");
        }
    }

    public Contact getContact(String contactId) {
        return contacts.get(contactId);
    }

    // Additional methods and business logic can be added here
}
