package controleurs;

import java.util.LinkedList;

import medel.Contact;
import medel.TypeContact;
import persistance.RequetesContact;

public class ControleurContact {
	
	RequetesContact requetesContact;
	
	public ControleurContact() {
		requetesContact=new RequetesContact();
	}
	
	public LinkedList<Contact> getContacts(){
		return requetesContact.getContacts();
	}
	
	public LinkedList<Contact> getContactsBySoundex(String soundexNom){
		return requetesContact.getContactsBySoundex(soundexNom);
	}
	
	public LinkedList<TypeContact> getContactTypes(){
		return requetesContact.getContactTypes();
	}

	public TypeContact getTypeContactByName(String libelle) {
		return requetesContact.getTypeContactByName(libelle);
	}
	
	public int addContact(Contact contact) {
		return requetesContact.addContact(contact);
	}
	
	public int deleteContact(int idContact) {
		return requetesContact.deleteContact(idContact);
	}
	
	public int updateContact(Contact contact) {
		return requetesContact.updateContact(contact);
	}
}
