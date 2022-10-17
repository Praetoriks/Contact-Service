package test.java.com.snhu.contactService;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.com.snhu.contactService.ContactService;

public class ContactServiceTest {
  protected String contactId, firstNameTest, lastNameTest, phoneNumberTest,
      addressTest;
  protected String tooLongContactId, tooLongFirstName, tooLongLastName,
      tooLongPhoneNumber, tooShortPhoneNumber, tooLongAddress;

  @BeforeEach
  void setUp() {
	  contactId = "0987654321";
	  firstNameTest = "Josh";
	  lastNameTest = "Perez";
	  phoneNumberTest = "1112221234";
	  addressTest = "12 Peanut Road Emerson NJ 07325";
	  tooLongContactId = "111122223333444455";
	  tooLongFirstName = "Josh is mystified";
	  tooLongLastName = " By this java code test";
	  tooLongPhoneNumber = "9999999112233";
	  tooShortPhoneNumber = "12345";
	  tooLongAddress = "12 Peanut Road Drive, Emerson, NJ 07305";
  }

  @Test
  void newContactTest() {
    ContactService service = new ContactService();
    service.newContact();
    assertAll("service",
        () -> assertNotNull(service.getContactList().get(0).getContactId()),
        () -> assertEquals("init", service.getContactList().get(0).getFirstName()),
        () -> assertEquals("init", service.getContactList().get(0).getLastName()),
        () -> assertEquals("1112221234", service.getContactList().get(0).getPhoneNumber()),
        () -> assertEquals("init", service.getContactList().get(0).getAddress()));
    
    service.newContact(firstNameTest);
    assertAll("service",
        () -> assertNotNull(service.getContactList().get(1).getContactId()),
        () -> assertEquals(firstNameTest, service.getContactList().get(1).getFirstName()),
        () -> assertEquals("init", service.getContactList().get(1).getLastName()),
        () -> assertEquals("1112221234", service.getContactList().get(1).getPhoneNumber()),
        () -> assertEquals("init", service.getContactList().get(1).getAddress()));
    
    service.newContact(firstNameTest, lastNameTest);
    assertAll("service",
        () -> assertNotNull(service.getContactList().get(2).getContactId()),
        () -> assertEquals(firstNameTest, service.getContactList().get(2).getFirstName()),
        () -> assertEquals(lastNameTest, service.getContactList().get(2).getLastName()),
        () -> assertEquals("1112221234", service.getContactList().get(2).getPhoneNumber()),
        () -> assertEquals("init", service.getContactList().get(2).getAddress()));
    
    service.newContact(firstNameTest, lastNameTest, phoneNumberTest);
    assertAll("service",
        () -> assertNotNull(service.getContactList().get(3).getContactId()),
        () -> assertEquals(firstNameTest, service.getContactList().get(3).getFirstName()),
        () -> assertEquals(lastNameTest, service.getContactList().get(3).getLastName()),
        () -> assertEquals(phoneNumberTest, service.getContactList().get(3).getPhoneNumber()),
        () -> assertEquals("init", service.getContactList().get(3).getAddress()));
    
    service.newContact(firstNameTest, lastNameTest, phoneNumberTest, addressTest);
    assertAll("service",
        () -> assertNotNull(service.getContactList().get(4).getContactId()),
        () -> assertEquals(firstNameTest, service.getContactList().get(4).getFirstName()),
        () -> assertEquals(lastNameTest, service.getContactList().get(4).getLastName()),
        () -> assertEquals(phoneNumberTest, service.getContactList().get(4).getPhoneNumber()),
        () -> assertEquals(addressTest, service.getContactList().get(4).getAddress()));
  }

  @Test
  void delContactTest() {
    ContactService service = new ContactService();
    service.newContact();
    assertThrows(Exception.class, () -> service.delContact(contactId));
    assertAll(() -> service.delContact(service.getContactList().get(0).getContactId()));
  }

  @Test
  void updFNameTest() throws Exception {
    ContactService service = new ContactService();
    service.newContact();
    service.updFName(service.getContactList().get(0).getContactId(), firstNameTest);
    assertEquals(firstNameTest, service.getContactList().get(0).getFirstName());
    
    assertThrows(IllegalArgumentException.class,
                 () -> service.updFName( service.getContactList().get(0).getContactId(), tooLongFirstName));
    
    assertThrows(IllegalArgumentException.class,
                 () -> service.updFName( service.getContactList().get(0).getContactId(), null));
    
    assertThrows(Exception.class,
                 () -> service.updFName(contactId, firstNameTest));
  }

  @Test
  void updLNameTest() throws Exception {
    ContactService service = new ContactService();
    service.newContact();
    service.updLName(service.getContactList().get(0).getContactId(), lastNameTest);
    
    assertEquals(lastNameTest, service.getContactList().get(0).getLastName());
    
    assertThrows(IllegalArgumentException.class,
                 () -> service.updLName( service.getContactList().get(0).getContactId(),
                         tooLongLastName));
    
    assertThrows(IllegalArgumentException.class,
                 () -> service.updLName( service.getContactList().get(0).getContactId(), null));
    
    assertThrows(Exception.class,
                 () -> service.updLName(contactId, lastNameTest));
  }

  @Test
  void updPhoneNumTest() throws Exception {
    ContactService service = new ContactService();
    service.newContact();
    service.updPhoneNum(service.getContactList().get(0).getContactId(),
                              phoneNumberTest);
    assertEquals(phoneNumberTest, service.getContactList().get(0).getPhoneNumber());
    
    assertThrows(IllegalArgumentException.class,
                 () -> service.updPhoneNum( service.getContactList().get(0).getContactId(),
                         tooLongPhoneNumber));
    
    assertThrows(IllegalArgumentException.class,
                 () -> service.updPhoneNum( service.getContactList().get(0).getContactId(),
                         tooShortPhoneNumber));
    assertThrows(
        IllegalArgumentException.class,
        () -> service.updPhoneNum( service.getContactList().get(0).getContactId(), contactId));
    
    assertThrows(IllegalArgumentException.class,
                 () -> service.updPhoneNum( service.getContactList().get(0).getContactId(), null));
    
    assertThrows(Exception.class,
                 () -> service.updPhoneNum(contactId, lastNameTest));
  }

  @Test
  void updAddressTest() throws Exception {
    ContactService service = new ContactService();
    service.newContact();
    service.updAddress(service.getContactList().get(0).getContactId(),
                          addressTest);
    
    assertEquals(addressTest, service.getContactList().get(0).getAddress());
    
    assertThrows(IllegalArgumentException.class,
                 () -> service.updAddress( service.getContactList().get(0).getContactId(),
                         tooLongAddress));
    
    assertThrows(IllegalArgumentException.class,
                 () -> service.updAddress( service.getContactList().get(0).getContactId(), null));
    
    assertThrows(Exception.class,
                 () -> service.updAddress(contactId, addressTest));
  }
}