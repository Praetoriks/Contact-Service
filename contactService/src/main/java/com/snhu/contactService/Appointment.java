package main.java.com.snhu.contactService;

/*
 * Use java.util.Date for the appointmentDate field and use before(new Date()) to 
 * check if the date is in the past.
 */
import java.util.Date;

public class Appointment {

  // Application ID Length
  final private byte apptIdLen;
  // Application Description Length
  final private byte apptDescLen;
  final private String init;
  
  private String apptId;
  private Date apptDate;
  private String desc;

  {
// unique Application ID less than 10 char. Shall not be null, or update-able.
    apptIdLen = 10;
    
// Description field less than 50 char. Shall not be null.
    apptDescLen = 50;
    init = "Begin";
  }

  public Appointment() {
    Date today = new Date();
    apptId = init;
    apptDate = today;
    desc = init;
  }

  public Appointment (String id) {
    Date today = new Date();
    updApptId (id);
    apptDate = today;
    desc = init;
  }

  public Appointment (String id, Date date) {
    updApptId (id);
    updDate (date);
    desc = init;
  }

  public Appointment (String id, Date date, String description) {
    updApptId (id);
    updDate (date);
    updDesc (description);
  }

  public void updApptId (String id) {
// Make sure the appointment ID is not null.
    if (id == null) {
      throw new IllegalArgumentException (
    		    "The Appointment ID must not be null.");
      
// Check against length of appointment ID string.
    } else if (id.length() > apptIdLen) {
    	
    	throw new IllegalArgumentException (
    			"The Appointment ID must be shorter than " + apptIdLen + " characters.");
    } else {
      this.apptId = id;
    }
  }
  
// Appointment ID is not update-able
  public String getApptId () { return apptId; }


  public void updDate (Date date) {
// Make sure the date is not null.
    if (date == null) {
      throw new IllegalArgumentException (
    		    "The Appointment date must not be null.");
      
// Make sure that the date chosen is not from a past day.      
    } else if (date.before(new Date())) {
      throw new IllegalArgumentException (
    		    "The appointment must be scheduled for a future date");
    } else {
      this.apptDate = date;
    }
  }
  
  public Date getApptDate() { return apptDate; }

  public void updDesc(String description) {
    if (description == null) {
      throw new IllegalArgumentException(
                "Appointment description cannot be null.");
    } else if (description.length() > apptDescLen) {
      throw new IllegalArgumentException(
                "Appointment description cannot exceed " + apptDescLen + " characters.");
    } else {
      this.desc = description;
    }
  }

  public String getDesc() { return desc; }
}