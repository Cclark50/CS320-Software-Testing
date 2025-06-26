package contacts;

/*
 * @Author Christian Clark
 * @Date 5/21/2025
 * 
 * This contact class holds the name, phone number, and address of any contact created.
 * the contact ID is unique and unchangeable. 
 */

public class Contact {

    private final String ID;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;

    public Contact(
        String ID,
        String firstName,
        String lastName,
        String phone,
        String address
    ) {
    	//The ID, firstname and lastname must be between 1-10 characters
        if (ID == null || ID.length() > 10) {
            throw new IllegalArgumentException("Invalid ID");
        }

        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("Invalid firstName");
        }

        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Invalid lastName");
        }

        //The phone number MUST be 10 characters
        if (phone == null || phone.length() != 10) {
            throw new IllegalArgumentException("Invalid phone");
        }

        //and the address mustb be between 1-30 characters
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Invalid address");
        }

        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
    }

    //getters
    public String GetID() {
        return ID;
    }

    public String GetFirstName() {
        return firstName;
    }

    public String GetLastName() {
        return lastName;
    }

    public String GetPhone() {
        return phone;
    }

    public String GetAddress() {
        return address;
    }

    //setters
    public void SetFirstName(String firstName) {
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("Invalid firstName");
        }

        this.firstName = firstName;
    }

    public void SetLastName(String lastName) {
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Invalid lastName");
        }

        this.lastName = lastName;
    }

    public void SetPhone(String phone) {
        if (phone == null || phone.length() != 10) {
            throw new IllegalArgumentException("Invalid phone");
        }

        this.phone = phone;
    }

    public void SetAddress(String address) {
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Invalid address");
        }

        this.address = address;
    }
}
