package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

import contacts.ContactService;
import org.junit.jupiter.api.Test;

import contacts.*;

public class ContactServiceTest {

    ContactService service;

    @BeforeEach
    public void setUpAll() {
        service = new ContactService();
    }

    @Test
    public void TestAddContact() {
    	
        service.AddContact("Christian", "Clark", "1234567890", "4321");
        
        assertTrue(service.GetContactCount() == 1);
        
        assertTrue(service.At("0").GetFirstName().equals("Christian"));
        assertTrue(service.At("0").GetLastName().equals("Clark"));
        assertTrue(service.At("0").GetPhone().equals("1234567890"));
        assertTrue(service.At("0").GetAddress().equals("4321"));
    }

    @Test
    public void TestAddMultipleContacts() {
        service.AddContact("Christian", "Clark", "1234567890", "4321");
        service.AddContact("John", "Doe", "0987654321", "1234");
        assertTrue(service.GetContactCount() == 2);
        assertTrue(service.At("1").GetFirstName().equals("John"));
        assertTrue(service.At("1").GetLastName().equals("Doe"));
        assertTrue(service.At("1").GetPhone().equals("0987654321"));
        assertTrue(service.At("1").GetAddress().equals("1234"));
    }

    @Test
    public void TestRemoveContact() {
        
        service.AddContact("Christian", "Clark", "1234567890", "4321");
        service.AddContact("John", "Doe", "0987654321", "1234");
        service.DeleteContact("0");
        assertTrue(service.GetContactCount() == 1);
        assertThrows(IllegalArgumentException.class, () ->
            service.At("0").GetFirstName().equals("Christian")
        );
        assertThrows(IllegalArgumentException.class, () ->
            service.At("0").GetLastName().equals("Clark")
        );
        assertThrows(IllegalArgumentException.class, () ->
            service.At("0").GetPhone().equals("1234567890")
        );
        assertThrows(IllegalArgumentException.class, () ->
            service.At("0").GetAddress().equals("4321")
        );
        
    }
    
    @Test
    public void TestRemoveMultipleContacts() {
    	service.AddContact("Christian", "Clark", "1234567890", "4321");
        service.AddContact("John", "Doe", "0987654321", "1234");
        service.DeleteContact("0");
        service.DeleteContact("1");
        
        assertTrue(service.GetContactCount() == 0);
        assertThrows(IllegalArgumentException.class, () ->
        service.At("1").GetFirstName().equals("John")
    );
    assertThrows(IllegalArgumentException.class, () ->
        service.At("1").GetLastName().equals("Doe")
    );
    assertThrows(IllegalArgumentException.class, () ->
        service.At("1").GetPhone().equals("0987654321")
    );
    assertThrows(IllegalArgumentException.class, () ->
        service.At("1").GetAddress().equals("1234")
    );
    }

    @Test
    public void TestRemoveContactFails() {
        service.AddContact("Christian", "Clark", "1234567890", "4321");
        service.AddContact("John", "Doe", "0987654321", "1234");
        assertThrows(IllegalArgumentException.class, () ->
            service.DeleteContact("2")
        );
    }

    @Test
    public void TestUpdateContact() {
        service.AddContact("Christian", "Clark", "1234567890", "4321");
        service.UpdateContact("0", "John", "Doe", "0987654321", "1234");
        assertTrue(service.At("0").GetFirstName().equals("John"));
        assertTrue(service.At("0").GetLastName().equals("Doe"));
        assertTrue(service.At("0").GetPhone().equals("0987654321"));
        assertTrue(service.At("0").GetAddress().equals("1234"));
    }

    @Test
    public void TestUpdateContactFails() {
        service.AddContact("Christian", "Clark", "1234567890", "4321");
        service.AddContact("John", "Doe", "0987654321", "1234");
        assertThrows(IllegalArgumentException.class, () ->
            service.UpdateContact("2", "Jane", "Smith", "1111111111", "5678")
        );
    }

    @Test
    public void TestAtFails() {
        service.AddContact("John", "Doe", "0987654321", "1234");
        assertThrows(IllegalArgumentException.class, () ->
            service.At("1").GetFirstName().equals("John")
        );
    }
}
