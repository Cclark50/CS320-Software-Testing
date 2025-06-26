package contacts;

import java.util.ArrayList;

/*
 * @Author Christian Clark
 * @Date 5/21/25
 * 
 * The driver for the contact class. Allows for creation of a list of contacts.
 * All IDs are unique and sequential
 * 
 * 
 */

public class ContactService {

    private ArrayList<Contact> contacts;
    private int currID = 0;

    public ContactService() {
        contacts = new ArrayList<Contact>();
    }

    //Gets the current ID that is unique and also updates it
    private int GetNextID() {
        return currID++;
    }

    public void AddContact(
        String firstName,
        String lastName,
        String phone,
        String address
    ) {
    	String newID = String.valueOf(GetNextID());
        Contact contact = new Contact(
            newID,
            firstName,
            lastName,
            phone,
            address
        );
        contacts.add(contact);
    }

    public void DeleteContact(String ID) {
    	int index = IndexOf(ID);
        if (index == -1) {
            throw new IllegalArgumentException("Contact not found");
        }

        contacts.remove(index);
    }

    //updates a contact given the ID and all fields to be updated
    public void UpdateContact(
        String ID,
        String firstName,
        String lastName,
        String phone,
        String address
    ) {
        if (IndexOf(ID) == -1) {
            throw new IllegalArgumentException("Contact not found");
        }

        int index = IndexOf(ID);
        Contact contact = contacts.get(index);
        contact.SetFirstName(firstName);
        contact.SetLastName(lastName);
        contact.SetPhone(phone);
        contact.SetAddress(address);
    }

    //gets the size of the contact list
    public int GetContactCount() {
        return contacts.size();
    }

    //returns the contact at a certain ID
    public Contact At(String ID) {
    	
    	int index = IndexOf(ID);
        if (index == -1) {
            throw new IllegalArgumentException("Contact not found");
        }

        return contacts.get(index);
    }
    
    //returns the index of a contact with a certain ID
    private int IndexOf(String ID) {
    	int index = -1;
    	
    	for(Contact ctx : contacts) {
    		index++;
    		if(ctx.GetID().equals(ID)) {
    			return index;
    		}
    	}
    	
    	return -1;
    }
}
