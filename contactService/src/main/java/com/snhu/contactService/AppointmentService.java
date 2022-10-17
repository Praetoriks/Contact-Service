package main.java.com.snhu.contactService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class AppointmentService {
  final private List<Appointment> apptList = new ArrayList<>();

// Random unique ID assigned to the Application ID
  private String newUniqueId () {
    return UUID.randomUUID().toString().substring(
        0, Math.min(toString().length(), 10));
  }

// The appointment service shall be able to add appointments with a unique appointment ID.
  public void newAppt () {
    Appointment appt = new Appointment(newUniqueId());
    apptList.add(appt);
  }

// The appointment service shall be able to add appointments with a unique appointment ID.  
  public void newAppt (Date date) {
    Appointment appt = new Appointment(newUniqueId(), date);
    apptList.add(appt);
  }

// The appointment service shall be able to add appointments with a unique appointment ID.  
  public void newAppt (Date date, String description) {
    Appointment appt = new Appointment(newUniqueId(), date, description);
    apptList.add(appt);
  }


// The appointment service shall be able to delete appointments per appointment ID.  
  public void delAppt (String id) throws Exception {
    apptList.remove (searchForAppt(id));
  }

  public List<Appointment> getApptList() { return apptList; }

  private Appointment searchForAppt (String id) throws Exception {
    int index = 0;
    while (index < apptList.size()) {
      if (id.equals(apptList.get(index).getApptId())) {
        return apptList.get(index);
      }
      index++;
    }
    throw new Exception("The appointment is not registered and does not exist!");
  }
}