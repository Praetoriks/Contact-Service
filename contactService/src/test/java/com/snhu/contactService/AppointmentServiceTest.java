package test.java.com.snhu.contactService;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;
import java.util.Date;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.com.snhu.contactService.AppointmentService;

class AppointmentServiceTest {
  private String id, description, tooLongDescription;
  private Date date, pastDate;

  @SuppressWarnings("deprecation")
  @BeforeEach
  void setUp() {
    id = "0987654321";
    description = "The object has a required description.";
    date = new Date(3021, Calendar.JANUARY, 1);
    tooLongDescription = "This description is purposely set to be too long in order to break the appointment requirements, therefore I will ramble.";
    pastDate = new Date(0);
  }

  @Test
  void testNewAppointment() {
    AppointmentService service = new AppointmentService();

    service.newAppt();
    assertNotNull(service.getApptList().get(0).getApptId());
    assertNotNull(service.getApptList().get(0).getApptDate());
    assertNotNull(service.getApptList().get(0).getDesc());

    service.newAppt(date);
    assertNotNull(service.getApptList().get(1).getApptId());
    assertEquals(date,
                 service.getApptList().get(1).getApptDate());
    assertNotNull(service.getApptList().get(1).getDesc());

    service.newAppt(date, description);
    assertNotNull(service.getApptList().get(2).getApptId());
    assertEquals(date, service.getApptList().get(2).getApptDate());
    assertEquals(description, service.getApptList().get(2).getDesc());

    assertNotEquals(service.getApptList().get(0).getApptId(), service.getApptList().get(1).getApptId());
    assertNotEquals(service.getApptList().get(0).getApptId(), service.getApptList().get(2).getApptId());
    assertNotEquals(service.getApptList().get(1).getApptId(), service.getApptList().get(2).getApptId());

    assertThrows(IllegalArgumentException.class, () -> service.newAppt(pastDate));
    assertThrows(IllegalArgumentException.class, () -> service.newAppt(date, tooLongDescription));
  }

  @Test
  void deleteAppointment() throws Exception {
    AppointmentService service = new AppointmentService();

    service.newAppt();
    service.newAppt();
    service.newAppt();

    String firstId = service.getApptList().get(0).getApptId();
    String secondId = service.getApptList().get(1).getApptId();
    String thirdId = service.getApptList().get(2).getApptId();

    assertNotEquals(firstId, secondId);
    assertNotEquals(firstId, thirdId);
    assertNotEquals(secondId, thirdId);
    assertNotEquals(id, firstId);
    assertNotEquals(id, secondId);
    assertNotEquals(id, thirdId);

    assertThrows(Exception.class, () -> service.delAppt(id));

    service.delAppt(firstId);
    assertThrows(Exception.class, () -> service.delAppt(firstId));
    assertNotEquals(firstId, service.getApptList().get(0).getApptId());
  }
}