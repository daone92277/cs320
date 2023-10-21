package com.snhu.davidgreene.module3;

public class Contact {
    private final String contactId;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;

    public Contact(String contactId, String firstName, String lastName, String phone, String address) {
        // Validate the input parameters
        if (contactId == null || contactId.isEmpty() || contactId.length() > 10) {
            throw new IllegalArgumentException("Contact ID cannot be null, empty, or longer than 10 characters");
        }
        if (firstName == null || firstName.isEmpty() || firstName.length() > 10) {
            throw new IllegalArgumentException("First name cannot be null, empty, or longer than 10 characters");
        }
        if (lastName == null || lastName.isEmpty() || lastName.length() > 10) {
            throw new IllegalArgumentException("Last name cannot be null, empty, or longer than 10 characters");
        }
        if (phone == null || phone.isEmpty() || phone.length() != 10) {
            throw new IllegalArgumentException("Phone number cannot be null, empty, or not equal to 10 digits");
        }
        if (address == null || address.isEmpty() || address.length() > 30) {
            throw new IllegalArgumentException("Address cannot be null, empty, or longer than 30 characters");
        }

        // Set the contact fields
        this.contactId = contactId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
    }

    // Getters and setters for the contact fields
    public String getContactId() {
        return contactId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName == null || firstName.isEmpty() || firstName.length() > 10) {
            throw new IllegalArgumentException("First name cannot be null, empty, or longer than 10 characters");
        }

        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName == null || lastName.isEmpty() || lastName.length() > 10) {
            throw new IllegalArgumentException("Last name cannot be null, empty, or longer than 10 characters");
        }

        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        if (phone == null || phone.isEmpty() || phone.length() != 10) {
            throw new IllegalArgumentException("Phone number cannot be null, empty, or not equal to 10 digits");
        }

        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        if (address == null || address.isEmpty() || address.length() > 30) {
            throw new IllegalArgumentException("Address cannot be null, empty, or longer than 30 characters");
        }

        this.address = address;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "contactId='" + contactId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
