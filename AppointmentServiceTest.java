package tests;

import static org.junit.jupiter.api.Assertions.*;

import appointments.*;
import java.util.Date;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AppointmentServiceTest {

    AppointmentService service;
    Date currDate;

    @BeforeEach
    void SetUpEach() {
        service = new AppointmentService();
    }

    @Test
    void TestAddAppointment() {
    	currDate = new Date();
        Date newDate = new Date(currDate.getTime() + 1000);
        service.AddAppointment(
            newDate,
            "test desc"
        );

        assertTrue(service.At("0").GetID().equals("0"));
        assertTrue(service.At("0").GetDate() == newDate);
        assertTrue(service.At("0").GetDescription().equals("test desc"));
    }

    @Test
    void TestAddMultipleAppointments() {
    	currDate = new Date();
        Date date1 = new Date(currDate.getTime() + 1000);
        Date date2 = new Date(currDate.getTime() + 2000);
        Date date3 = new Date(currDate.getTime() + 3000);

        service.AddAppointment(date1, "first appointment");
        service.AddAppointment(date2, "second appointment");
        service.AddAppointment(date3, "third appointment");

        assertTrue(service.GetAppointmentCount() == 3);

        assertTrue(service.At("0").GetID().equals("0"));
        assertTrue(service.At("0").GetDate() == date1);
        assertTrue(service.At("0").GetDescription().equals("first appointment"));

        assertTrue(service.At("1").GetID().equals("1"));
        assertTrue(service.At("1").GetDate() == date2);
        assertTrue(service.At("1").GetDescription().equals("second appointment"));

        assertTrue(service.At("2").GetID().equals("2"));
        assertTrue(service.At("2").GetDate() == date3);
        assertTrue(service.At("2").GetDescription().equals("third appointment"));
    }

    @Test
    void TestDeleteAppointment(){
    	currDate = new Date();
        Date newDate = new Date(currDate.getTime() + 1000);

        service.AddAppointment(newDate, "app to be deleted");
        assertTrue(service.GetAppointmentCount() == 1);

        service.DeleteAppointment("0");

        assertThrows(IllegalArgumentException.class, () ->
            service.At("0").GetID()
        );
        assertTrue(service.GetAppointmentCount() == 0);
    }

    @Test
    void TestDeleteMultipleAppointments() {
    	currDate = new Date();
        Date date1 = new Date(currDate.getTime() + 1000);
        Date date2 = new Date(currDate.getTime() + 2000);
        Date date3 = new Date(currDate.getTime() + 3000);

        service.AddAppointment(date1, "first appointment");
        service.AddAppointment(date2, "second appointment");
        service.AddAppointment(date3, "third appointment");

        assertTrue(service.GetAppointmentCount() == 3);

        service.DeleteAppointment("0");
        service.DeleteAppointment("2");

        assertTrue(service.GetAppointmentCount() == 1);
        assertThrows(IllegalArgumentException.class,
            () -> service.At("0").GetID()
        );
        assertTrue(service.At("1").GetDate() == date2);
        assertThrows(IllegalArgumentException.class,
            () -> service.At("2").GetID()
        );
    }

    @Test
    void TestRemoveAppointmentFails(){
    	currDate = new Date();
        Date date1 = new Date(currDate.getTime() + 1000);
        Date date2 = new Date(currDate.getTime() + 2000);

        service.AddAppointment(date1, "first appointment");
        service.AddAppointment(date2, "second appointment");

        assertThrows(IllegalArgumentException.class,
            () -> service.DeleteAppointment("2")
        );
    }

    @Test
    void TestAtFails(){
    	currDate = new Date();
        Date newDate = new Date(currDate.getTime() + 1000);

        service.AddAppointment(newDate, "test desc");

        assertThrows(IllegalArgumentException.class, () -> service.At("4").GetID());
    }
}
