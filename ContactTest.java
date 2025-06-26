package test;

import static org.junit.jupiter.api.Assertions.*;

import contacts.Contact;
import org.junit.jupiter.api.Test;

class ContactTest {

    @Test
    void TestContact() {
        Contact contact = new Contact(
            "1",
            "Christian",
            "Clark",
            "1234567890",
            "4321"
        );
        assertTrue(contact.GetID() == "1");
        assertTrue(contact.GetFirstName() == "Christian");
        assertTrue(contact.GetLastName() == "Clark");
        assertTrue(contact.GetPhone() == "1234567890");
        assertTrue(contact.GetAddress() == "4321");
    }

    @Test
    void TestContactIDTooLong() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact(
                "123456789012",
                "Christian",
                "Clark",
                "1234567890",
                "4321"
            )
        );
    }

    @Test
    void TestContactIDNull() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact(
            		null, 
            		"Christian", 
            		"Clark", 
            		"1234567890", 
            		"4321"
            		)
        );
    }

    @Test
    void TestContactFirstNameTooLong() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact(
            		"1", 
            		"123456789012", 
            		"Clark", 
            		"1234567890", 
            		"4321"
            		)
        );
    }

    @Test
    void TestContactFirstNameNull() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact(
            		"1", 
            		null, 
            		"Clark", 
            		"1234567890", 
            		"4321"
            		)
        );
    }

    @Test
    void TestContactLastNameTooLong() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact(
            		"1", 
            		"Christian", 
            		"123456789012", 
            		"1234567890", 
            		"4321"
            		)
        );
    }

    @Test
    void TestContactLastNameNull() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact(
            		"1", 
            		"Christian", 
            		null, 
            		"1234567890", 
            		"4321"
            		)
        );
    }

    @Test
    void TestContactPhoneTooLong() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact(
            		"1", 
            		"Christian", 
            		"Clark", 
            		"123456789012", 
            		"4321"
            		)
        );
    }

    @Test
    void TestContactPhoneTooShort() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact(
            		"1", 
            		"Christian", 
            		"Clark", 
            		"123", 
            		"4321"
            		)
        );
    }

    @Test
    void TestContactPhoneNull() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact(
            		"1", 
            		"Christian", 
            		"Clark", 
            		null, 
            		"4321"
            		)
        );
    }

    @Test
    void TestContactAddressTooLong() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact(
                "1",
                "Christian",
                "Clark",
                "1234567890",
                "1234567890123456789012345678901234"
            )
        );
    }

    @Test
    void TestContactAddressNull() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact(
            		"1", 
            		"Christian", 
            		"Clark", 
            		"1234567890", 
            		null
            		)
        );
    }

    @Test
    void TestContactFirstNameSetTooLong() {
        Contact contact = new Contact(
            "1",
            "Christian",
            "Clark",
            "1234567890",
            "4321"
        );
        assertThrows(IllegalArgumentException.class, () ->
            contact.SetFirstName("ThisIsWayTooLong")
        );
    }

    @Test
    void TestContactLastNamsSetTooLong() {
        Contact contact = new Contact(
            "1",
            "Christian",
            "Clark",
            "1234567890",
            "4321"
        );
        assertThrows(IllegalArgumentException.class, () ->
            contact.SetLastName("ThisIsWayTooLong")
        );
    }

    @Test
    void TestContactPhoneSetTooLong() {
        Contact contact = new Contact(
            "1",
            "Christian",
            "Clark",
            "1234567890",
            "4321"
        );
        assertThrows(IllegalArgumentException.class, () ->
            contact.SetPhone("ThisIsWayTooLong")
        );
    }

    @Test
    void TestContactPhoneSetTooShort() {
        Contact contact = new Contact(
            "1",
            "Christian",
            "Clark",
            "1234567890",
            "4321"
        );
        assertThrows(IllegalArgumentException.class, () ->
            contact.SetPhone("123")
        );
    }

    @Test
    void TestContactAddressSetTooLong() {
        Contact contact = new Contact(
            "1",
            "Christian",
            "Clark",
            "1234567890",
            "4321"
        );
        assertThrows(IllegalArgumentException.class, () ->
            contact.SetAddress(
                "TThisIsWayTooLongThisIsWayTooLonghisIsWayTooLong"
            )
        );
    }

    @Test
    void TestContactFirstNameSetNull() {
        Contact contact = new Contact(
            "1",
            "Christian",
            "Clark",
            "1234567890",
            "4321"
        );
        assertThrows(IllegalArgumentException.class, () ->
            contact.SetFirstName(null)
        );
    }

    @Test
    void TestContactLastNamsSetNull() {
        Contact contact = new Contact(
            "1",
            "Christian",
            "Clark",
            "1234567890",
            "4321"
        );
        assertThrows(IllegalArgumentException.class, () ->
            contact.SetLastName(null)
        );
    }

    @Test
    void TestContactPhoneSetNull() {
        Contact contact = new Contact(
            "1",
            "Christian",
            "Clark",
            "1234567890",
            "4321"
        );
        assertThrows(IllegalArgumentException.class, () ->
            contact.SetPhone(null)
        );
    }

    @Test
    void TestContactAddressSetNull() {
        Contact contact = new Contact(
            "1",
            "Christian",
            "Clark",
            "1234567890",
            "4321"
        );
        assertThrows(IllegalArgumentException.class, () ->
            contact.SetAddress(null)
        );
    }
}
