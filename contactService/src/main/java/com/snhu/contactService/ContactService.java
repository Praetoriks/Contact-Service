package main.java.com.snhu.contactService;

import java.util.ArrayList;
import java.util.UUID;
import java.util.List;



public class ContactService {

	private String uniqueId;
	private List<Contact> contactList = new ArrayList<>();
	
	{
		uniqueId = UUID.randomUUID().toString().substring(0, Math.min(toString().length(), 10));
	}
	
	public void newContact () {
		Contact contact = new Contact (newUniqueId());
		contactList.add(contact);
	}

	public void newContact (String firstname) {
		Contact contact = new Contact(newUniqueId(), firstname);
		contactList.add(contact);
	}

	public void newContact (String firstname, String lastname) {
		Contact contact = new Contact(newUniqueId(), firstname, lastname);
		contactList.add(contact);
	}

	public void newContact (String firstname, String lastname, String phonenumber) {
		Contact contact = new Contact(newUniqueId(), firstname, lastname, phonenumber);
		contactList.add(contact);
	}

	public void newContact (String firstname, String lastname, String phonenumber, String address) {
		Contact contact = new Contact(newUniqueId(), firstname, lastname, phonenumber, address);
		contactList.add(contact);
	}

	public void delContact (String id) throws Exception {
		contactList.remove(searchForContact(id));
	}

	public void updFName (String id, String firstName) throws Exception {
		searchForContact(id).updFName(firstName);
	}

	public void updLName (String id, String lastName) throws Exception {
		searchForContact(id).updLName(lastName);
	}

	public void updPhoneNum (String id, String phoneNumber) throws Exception {
		searchForContact(id).updPhoneNum(phoneNumber);
	}

	public void updAddress (String id, String address) throws Exception {
		searchForContact(id).updAddress(address);
	}

	public List<Contact> getContactList() { return contactList; }

	private String newUniqueId() {
		return uniqueId = UUID.randomUUID().toString().substring(
		               0, Math.min(toString().length(), 10));
	}

	private Contact searchForContact(String id) throws Exception {
		int index = 0;
		    while (index < contactList.size()) {
		      if (id.equals(contactList.get(index).getContactId())) {
		        return contactList.get(index);
		      }
		      index++;
		    }
		    throw new Exception("The Task does not exist!");
	}
}