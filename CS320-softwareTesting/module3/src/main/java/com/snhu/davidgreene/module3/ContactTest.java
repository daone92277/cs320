package com.snhu.davidgreene.module3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactTest {
    private Contact contact;

    @BeforeEach
    public void setUp() {
        contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
    }

    @Test
    public void testContactId() {
        Assertions.assertEquals("1234567890", contact.getContactId());
    }

    @Test
    public void testFirstName() {
        Assertions.assertEquals("John", contact.getFirstName());
    }

    @Test
    public void testLastName() {
        Assertions.assertEquals("Doe", contact.getLastName());
    }

    @Test
    public void testPhone() {
        Assertions.assertEquals("1234567890", contact.getPhone());
    }

    @Test
    public void testAddress() {
        Assertions.assertEquals("123 Main St", contact.getAddress());
    }

    // Additional test cases can be added here
}
