package tests;

import static org.junit.jupiter.api.Assertions.*;

import appointments.Appointment;
import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class AppointmentTest {

    Date currDate;

    @Test
    void TestAppointment() {
    	currDate = new Date();
        Appointment app = new Appointment("0", currDate, "test Description");

        assertTrue(app.GetID() == "0");
        assertTrue(app.GetDate() == currDate);
        assertTrue(app.GetDescription() == "test Description");
    }

    @Test
    void TestAppointmentIDTooLong() {
    	currDate = new Date();
        assertThrows(IllegalArgumentException.class, () ->
            new Appointment("123456789012", currDate, "test Desc")
        );
    }

    void TestAppointmentIDNull() {
    	currDate = new Date();
        assertThrows(IllegalArgumentException.class, () ->
            new Appointment(null, currDate, "test Desc")
        );
    }

    void TestAppointmentDateBeforeCurrent() {
    	currDate = new Date();
        Date newDate = new Date(currDate.getTime() - 1000);
        assertThrows(IllegalArgumentException.class, () ->
            new Appointment("0", newDate, "test Desc")
        );
    }

    void TestAppointmentDateNull() {
    	currDate = new Date();
        assertThrows(IllegalArgumentException.class, () ->
            new Appointment("0", null, "test Desc")
        );
    }

    void TestAppointmentDescriptionTooLong() {
    	currDate = new Date();
        assertThrows(IllegalArgumentException.class, () ->
            new Appointment(
                "0",
                currDate,
                "This is a really long description and i need it to be longer than 50 chars"
            )
        );
    }

    void TestAppointmentDescriptionNull() {
    	currDate = new Date();
        assertThrows(IllegalArgumentException.class, () ->
            new Appointment("0", currDate, null)
        );
    }

    @Test
    void TestSetDate() {
    	currDate = new Date();
        Appointment app = new Appointment("0", currDate, "test Description");
        Date newDate = new Date(currDate.getTime() + 10000);
        app.SetDate(newDate);

        assertTrue(app.GetDate().getTime() == (currDate.getTime() + 10000));
    }

    @Test
    void TestSetDateBeforeCurrent() {
    	currDate = new Date();
        Appointment app = new Appointment("0", new Date(), "test Description");
        Date pastDate = new Date(currDate.getTime() - 1000);

        assertThrows(IllegalArgumentException.class, () -> app.SetDate(pastDate)
        );
    }

    @Test
    void TestSetDateNull() {
    	currDate = new Date();
        Appointment app = new Appointment("0", currDate, "test Description");

        assertThrows(IllegalArgumentException.class, () -> app.SetDate(null));
    }

    @Test
    void TestSetDescription() {
    	currDate = new Date();
        Appointment app = new Appointment("0", currDate, "test Description");
        app.SetDescription("new Description");

        assertEquals("new Description", app.GetDescription());
    }

    @Test
    void TestSetDescriptionTooLong() {
    	currDate = new Date();
        Appointment app = new Appointment("0", currDate, "test Description");
        

        assertThrows(IllegalArgumentException.class, () ->
        	app.SetDescription("This is a really long description and i need it to be longer than 50 chars")
        );
    }

    @Test
    void TestSetDescriptionNull() {
    	currDate = new Date();
        Appointment app = new Appointment("0", currDate, "test Description");

        assertThrows(IllegalArgumentException.class, () ->
            app.SetDescription(null)
        );
    }
}
