/*
 **@Author Christian Clark
 **@Date 6-4-25
 **This is a service class for holding a list of appointments
 **It can add and remove appointments based on their unique ID
 */

package appointments;

import appointments.Appointment;
import java.applet.Applet;
import java.util.ArrayList;
import java.util.Date;

public class AppointmentService {

    private ArrayList<Appointment> apps;
    //current ID variable to keep track of the ID we want to use next
    private int currID = 0;

    public AppointmentService() {
        apps = new ArrayList<Appointment>();
    }

    //Gets the current ID and also incriments it
    private int GetNextID() {
        return currID++;
    }

    //gets the size of the list of appointments
    public int GetAppointmentCount() {
        return apps.size();
    }

    //gets the index of an appointment based on its ID
    private int IndexOf(String ID) {
        int index = -1;
        for (Appointment app : apps) {
            index++;
            if (app.GetID().equals(ID)) {
                return index;
            }
        }
        return -1;
    }

    //gets the appointment with the given ID
    public Appointment At(String ID) {
        int index = IndexOf(ID);
        if (index == -1) {
            throw new IllegalArgumentException("Appointment not found");
        }

        return apps.get(index);
    }

    //adds an appointment with a date and description
    public void AddAppointment(Date date, String description) {
        Appointment app = new Appointment(
            String.valueOf(GetNextID()),
            date,
            description
        );
        apps.add(app);
    }

    //deletes and appointment with a given ID
    public void DeleteAppointment(String ID) {
        int index = IndexOf(ID);
        if (index == -1) {
            throw new IllegalArgumentException("Appointment not found");
        }

        apps.remove(index);
    }
}
