package main.java.com.snhu.contactService;

public class Contact {

	// Must be unique, no longer than 10 digits, not null, not update-able
	private static final byte contactIdLen = 10;
	
    // No longer than 10 characters, not null.
    private static final byte firstNameLen = 10;
    private static final byte lastNameLen = 10;
    
    // Must be exactly 10 digits, not null.
	private static final int phoneNumLen = 10;
    
    // No longer than 30 characters, not null.
	private static final byte addressLen = 30;
    
    // Initialize by giving basic values
	private static final String init = "Begin";
	private static final String initNum = "5555555510";

	private String contactId;
	private String firstName;
	private String lastName;
	private String phoneNum;
	private String address;
    
    
    
    public Contact() {
    	
    	// Assign initial values
    	this.contactId = init;
        this.firstName = init;
        this.lastName = init;
        this.phoneNum = initNum;
        this.address = init;
    }
    
    public Contact(String contactId) {
    	
    	// updates contact Id to match
    	updContactId (contactId);

        this.firstName = init;
        this.lastName = init;
        this.phoneNum = initNum;
        this.address = init;
    }
    
    public Contact(String contactId, String firstName) {
        updContactId (contactId);
        updFName (firstName);
        
        this.lastName = init;
        this.phoneNum = initNum;
        this.address = init;
      }

      public Contact(String contactId, String firstName, String lastName) {
        updContactId(contactId);
        updFName(firstName);
        updLName(lastName);
        this.phoneNum = initNum;
        this.address = init;
      }

      public Contact(String contactId, String firstName, String lastName,
              String phoneNumber) {
        updContactId(contactId);
        updFName(firstName);
        updLName(lastName);
        updPhoneNum(phoneNumber);
        this.address = init;
      }

      public Contact(String contactId, String firstName, String lastName,
              String phoneNumber, String address) {
        updContactId(contactId);
        updFName(firstName);
        updLName(lastName);
        updPhoneNum(phoneNumber);
        updAddress(address);
      }

      public final String getContactId() {return contactId;}

      public final String getFirstName() {return firstName;}

      public final String getLastName() {return lastName;}

      public final String getPhoneNumber() {return phoneNum;}

      public final String getAddress() {return address;}

      
      public void updFName(String firstName) {
        if (firstName == null) {
          throw new IllegalArgumentException("First name cannot be empty");
        } else if (firstName.length() > firstNameLen) {
          throw new IllegalArgumentException("First name cannot be longer than " +
        		  				firstNameLen + " characters");
        } else {
          this.firstName = firstName;
        }
      }

      public void updLName(String lastName) {
        if (lastName == null) {
          throw new IllegalArgumentException("Last name cannot be empty");
        } else if (lastName.length() > lastNameLen) {
          throw new IllegalArgumentException("Last name cannot be longer than " +
        		  				lastNameLen + " characters");
        } else {
          this.lastName = lastName;
        }
      }

      public void updPhoneNum(String phoneNumber) {
        String regex = "[0-9]+";
        if (phoneNumber == null) {
          throw new IllegalArgumentException("Phone number cannot be empty.");
        } else if (phoneNumber.length() != phoneNumLen) {
          throw new IllegalArgumentException("Phone number length invalid. Ensure it is " +
            		  phoneNumLen + " digits.");
        } else if (!phoneNumber.matches(regex)) {
          throw new IllegalArgumentException(
              "Phone number cannot have anything but numbers");
        } else {
          this.phoneNum = phoneNumber;
        }
      }

      public void updAddress(String address) {
        if (address == null) {
          throw new IllegalArgumentException("Address cannot be empty");
        } else if (address.length() > addressLen) {
          throw new IllegalArgumentException("Address cannot be longer than " +
        		  		addressLen + " characters");
        } else {
          this.address = address;
        }
      }

      public void updContactId(String contactId) {
        if (contactId == null) {
          throw new IllegalArgumentException("Contact ID cannot be empty");
        } else if (contactId.length() > contactIdLen) {
          throw new IllegalArgumentException("Contact ID cannot be longer than " +
        		  					contactIdLen + " characters");
        } else {
          this.contactId = contactId;
        }
      }
    }