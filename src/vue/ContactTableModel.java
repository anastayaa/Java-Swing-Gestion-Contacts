package vue;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import medel.Contact;

public class ContactTableModel extends AbstractTableModel {
	
	/**
	 * Les colonnes a afficher
	 */
	String[] colonnes=new String[] {"idContact", "idTypesContact", "nom", "prenom", "soundexnom"};
	
	/**
	 * La liste des contacts
	 */
	List<Contact> contacts;
	
	@Override
	public String getColumnName(int index) {

		return colonnes[index];
	}
	
	@Override
	public int getColumnCount() {
		
		return colonnes.length;
	}

	@Override
	public int getRowCount() {
		
		return contacts.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		Contact contact=contacts.get(row);
		switch(col) {
			case 0: return contact.getIdContact();
			case 1: return contact.getIdTypeContact();
			case 2: return contact.getNom();
			case 3: return contact.getPrenom();
			case 4: return contact.getSoundexnom();
		}
		return null;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

}
