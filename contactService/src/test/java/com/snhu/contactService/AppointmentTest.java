package test.java.com.snhu.contactService;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;
import java.util.Date;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.com.snhu.contactService.Appointment;

class AppointmentTest {

  private String id, description;
  private String tooLongId, tooLongDescription;
  private Date date, pastDate;

  @SuppressWarnings("deprecation")
  @BeforeEach
  void setUp() {
    id = "0987654321";
    description = "The object has a required description.";
    date = new Date(3021, Calendar.JANUARY, 1);
    tooLongId = "111122223333444455556666";
    tooLongDescription = "This description is purposely set to be too long in order to break the appointment requirements, therefore I will ramble.";
    pastDate = new Date(0);
  }

  @Test // Testing the update section of Appointment ID
  void testUpdateAppointmentId() {
    Appointment appt = new Appointment();
    assertThrows(IllegalArgumentException.class, () -> appt.updApptId(null));
    assertThrows(IllegalArgumentException.class, () -> appt.updApptId(tooLongId));
    appt.updApptId(id);
    assertEquals(id, appt.getApptId());
  }

  @Test // Testing the get section of Appointment ID
  void testGetAppointmentId() {
    Appointment appt = new Appointment(id);
    assertNotNull(appt.getApptId());
    assertEquals(appt.getApptId().length(), 10);
    assertEquals(id, appt.getApptId());
  }

  @Test // Testing the update section of Appointment Date
  void testUpdateDate() {
    Appointment appt = new Appointment();
    assertThrows(IllegalArgumentException.class, () -> appt.updDate(null));
    assertThrows(IllegalArgumentException.class, () -> appt.updDate(pastDate));
    appt.updDate(date);
    assertEquals(date, appt.getApptDate());
  }

  @Test // Testing the get section of Appointment Date
  void testGetAppointmentDate() {
    Appointment appt = new Appointment(id, date);
    assertNotNull(appt.getApptDate());
    assertEquals(date, appt.getApptDate());
  }

  @Test // Testing the update section of Appointment Description
  void testUpdateDescription() {
    Appointment appt = new Appointment();
    assertThrows(IllegalArgumentException.class, () -> appt.updDesc(null));
    assertThrows(IllegalArgumentException.class, () -> appt.updDesc(tooLongDescription));
    appt.updDesc(description);
    assertEquals(description, appt.getDesc());
  }

  @Test // Testing the get section of Appointment Description
  void testGetDescription() {
    Appointment appt = new Appointment(id, date, description);
    assertNotNull(appt.getDesc());
    assertTrue(appt.getDesc().length() <= 50);
    assertEquals(description, appt.getDesc());
  }
}