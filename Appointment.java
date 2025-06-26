/*
 **@Author Christian Clark
 **@Date 6-4-25
 **This class can hold an appointment with a unique ID, a Date, and a Description
 */

package appointments;

import java.util.Date;

public class Appointment {

    final String ID;
    Date date;
    String description;

    public Appointment(String ID, Date date, String description) {
        //ID cannot be null or greater than 10 chars
        if (ID == null || ID.length() >= 11) {
            throw new IllegalArgumentException("invalid ID");
        }
        //Date cannot be null or before the current time
        if (date == null || date.before(new Date())) {
            throw new IllegalArgumentException("invalid Date");
        }
        //Description cannot be null or more than 50 characters
        if (description == null || description.length() >= 51) {
            throw new IllegalArgumentException("invalid Description");
        }

        this.ID = ID;
        this.date = date;
        this.description = description;
    }

    //setters and getters
    public String GetID() {
        return ID;
    }

    public Date GetDate() {
        return date;
    }

    public String GetDescription() {
        return description;
    }

    public void SetDate(Date date) {
        if (date == null || date.before(new Date())) {
            throw new IllegalArgumentException("invalid date");
        }
        this.date = date;
    }

    public void SetDescription(String description) {
        if (description == null || description.length() >= 51) {
            throw new IllegalArgumentException("invalid description");
        }
        this.description = description;
    }
}
