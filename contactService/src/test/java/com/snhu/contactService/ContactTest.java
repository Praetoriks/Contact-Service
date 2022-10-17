package test.java.com.snhu.contactService;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.com.snhu.contactService.Contact;

public class ContactTest {
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
  void contactTest() {
    Contact contact = new Contact();
    assertAll("constructor",
              () -> assertNotNull(contact.getContactId()),
              () -> assertNotNull(contact.getFirstName()),
              () -> assertNotNull(contact.getLastName()),
              () -> assertNotNull(contact.getPhoneNumber()),
              () -> assertNotNull(contact.getAddress()));
  }

  @Test // Constructor for ID
  void IdConstructorTest() {
    Contact contact = new Contact(contactId);
    assertAll("Constructor for ID",
              () -> assertEquals(contactId, contact.getContactId()),
              () -> assertNotNull(contact.getFirstName()),
              () -> assertNotNull(contact.getLastName()),
              () -> assertNotNull(contact.getPhoneNumber()),
              () -> assertNotNull(contact.getAddress()));
  }

  @Test // Constructor for ID, First name
  void IdFNameConstructorTest() {
    Contact contact = new Contact(contactId, firstNameTest);
    assertAll("Constructor for ID, First name",
              () -> assertEquals(contactId, contact.getContactId()),
              () -> assertEquals(firstNameTest, contact.getFirstName()),
              () -> assertNotNull(contact.getLastName()),
              () -> assertNotNull(contact.getPhoneNumber()),
              () -> assertNotNull(contact.getAddress()));
  }

  @Test // Constructor for ID, Full name
  void IdNameConstructorTest() {
    Contact contact = new Contact(contactId, firstNameTest, lastNameTest);
    assertAll("Constructor for ID, Full name",
              () -> assertEquals(contactId, contact.getContactId()),
              () -> assertEquals(firstNameTest, contact.getFirstName()),
              () -> assertEquals(lastNameTest, contact.getLastName()),
              () -> assertNotNull(contact.getPhoneNumber()),
              () -> assertNotNull(contact.getAddress()));
  }

  @Test // Constructor for ID, Full name, and phone number
  void IdNameNumberConstructorTest() {
    Contact contact =
        new Contact(contactId, firstNameTest, lastNameTest, phoneNumberTest);
    assertAll("Constructor for ID, Full name, and phone number",
              () -> assertEquals(contactId, contact.getContactId()),
              () -> assertEquals(firstNameTest, contact.getFirstName()),
              () -> assertEquals(lastNameTest, contact.getLastName()),
              () -> assertEquals(phoneNumberTest, contact.getPhoneNumber()),
              () -> assertNotNull(contact.getAddress()));
  }

  @Test // Constructor for all components
  void ThisShouldWorkContactConstructor() {
    Contact contact = new Contact(contactId, firstNameTest, lastNameTest,
                                  phoneNumberTest, addressTest);
    assertAll("Constructor for all components",
              () -> assertEquals(contactId, contact.getContactId()),
              () -> assertEquals(firstNameTest, contact.getFirstName()),
              () -> assertEquals(lastNameTest, contact.getLastName()),
              () -> assertEquals(phoneNumberTest, contact.getPhoneNumber()),
              () -> assertEquals(addressTest, contact.getAddress()));
  }

  @Test // update first name test
  void updFNameTest() {
    Contact contact = new Contact();
    contact.updFName(firstNameTest);
    assertAll ( "first name",
        () -> assertEquals(firstNameTest, contact.getFirstName()),
        () -> assertThrows(IllegalArgumentException.class, () -> contact.updFName(null)),
        () -> assertThrows(IllegalArgumentException.class, () -> contact.updFName(tooLongFirstName)));
  }

  @Test // update last name test
  void updLNameTest() {
    Contact contact = new Contact();
    contact.updLName(lastNameTest);
    assertAll ( "last name",
        () -> assertEquals(lastNameTest, contact.getLastName()),
        () -> assertThrows(IllegalArgumentException.class, () -> contact.updLName(null)),
        () -> assertThrows(IllegalArgumentException.class, () -> contact.updLName(tooLongFirstName)));
  }

  @Test // update phone number test
  void updPhoneNumTest() {
    Contact contact = new Contact();
    contact.updPhoneNum(phoneNumberTest);
    assertAll("phone number",
              () -> assertEquals(phoneNumberTest, contact.getPhoneNumber()),
              () -> assertThrows(IllegalArgumentException.class, () -> contact.updPhoneNum(null)),
              () -> assertThrows(IllegalArgumentException.class, () -> contact.updPhoneNum(tooLongPhoneNumber)),
              () -> assertThrows(IllegalArgumentException.class, () -> contact.updPhoneNum(tooShortPhoneNumber)),
              () -> assertThrows(IllegalArgumentException.class, () -> contact.updPhoneNum(contactId)));
  }

  @Test // update address test
  void updAddressTest() {
    Contact contact = new Contact();
    contact.updAddress(addressTest);
    assertAll("phone number",
              () -> assertEquals(addressTest, contact.getAddress()),
              () -> assertThrows(IllegalArgumentException.class, () -> contact.updAddress(null)),
              () -> assertThrows(IllegalArgumentException.class, () -> contact.updAddress(tooLongAddress)));
  }

  @Test // update contact ID test
  void updContactIdTest() {
    Contact contact = new Contact();
    contact.updContactId(contactId);
    assertAll(
        "contact ID",
        () -> assertEquals(contactId, contact.getContactId()),
        () -> assertThrows(IllegalArgumentException.class, () -> contact.updContactId(null)),
        () -> assertThrows(IllegalArgumentException.class, () -> contact.updContactId(tooLongContactId)));
  }
  
}