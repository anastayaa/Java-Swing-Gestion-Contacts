package persistance;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import medel.Contact;
import medel.TypeContact;

public class RequetesContact {
	
	private Statement stm;
	private PreparedStatement pstm;
	private ResultSet rst;
	
	
	public RequetesContact() {
		try {
			stm=DB.getConection().createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * La liste des contacts
	 * @return
	 */
	public LinkedList<Contact> getContacts(){
		
		LinkedList<Contact> contacts=new LinkedList<>();
		try{
			String query="SELECT * FROM contact";
			rst=stm.executeQuery(query);
			while(rst.next()) {
				Contact contact=new Contact();
				contact.setIdContact(rst.getInt("idcontact"));
				contact.setIdTypeContact(rst.getInt("idtypescontact"));
				contact.setNom(rst.getString("nom"));
				contact.setPrenom(rst.getString("prenom"));
				contact.setSoundexnom(rst.getString("soundexnom"));
				contacts.add(contact);
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
		return contacts;
	}
	
	public LinkedList<Contact> getContactsBySoundex(String soundexNom){
		LinkedList<Contact> contacts=new LinkedList<>();
		try{
			String query="SELECT * FROM contact WHERE soundexnom=?";
			pstm=DB.getConection().prepareStatement(query);
			pstm.setString(1, soundexNom);
			rst=pstm.executeQuery();
			while(rst.next()) {
				Contact contact=new Contact();
				contact.setIdContact(rst.getInt("idcontact"));
				contact.setIdTypeContact(rst.getInt("idtypescontact"));
				contact.setNom(rst.getString("nom"));
				contact.setPrenom(rst.getString("prenom"));
				contact.setSoundexnom(rst.getString("soundexnom"));
				contacts.add(contact);
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return contacts;
	}
	
	/**
	 * La liste des types de contacts
	 * @return
	 */
	public LinkedList<TypeContact> getContactTypes(){
		
		LinkedList<TypeContact> typeContacts=new LinkedList<>();
		try{
			String query="SELECT * FROM typescontact";
			rst=stm.executeQuery(query);
			while(rst.next()) {
				TypeContact typeContact=new TypeContact();
				typeContact.setIdTypesContact(rst.getInt("idtypescontact"));
				typeContact.setLibelle(rst.getString("libelle"));
				typeContacts.add(typeContact);
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
		return typeContacts;
	}
	
	/**
	 * Type contact par nom
	 */
	public TypeContact getTypeContactByName(String libelle) {
		TypeContact typeContact=new TypeContact();
		try {
			String query="SELECT * FROM typescontact where libelle=?";
			pstm=DB.getConection().prepareStatement(query);
			pstm.setString(1, libelle);
			rst=pstm.executeQuery();
			if(rst.next()) {
				typeContact.setIdTypesContact(rst.getInt("idtypescontact"));
				typeContact.setLibelle(rst.getString("libelle"));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return typeContact;
	}
	
	/**
	 * L'ajout d'un nouveau contact
	 */
	public int addContact(Contact contact) {	
		try {
			String query="INSERT INTO contact(idtypescontact, nom, prenom, soundexnom)"
					+ " VALUES(?, ?, ?, ?)";
			pstm=DB.getConection().prepareStatement(query);
			pstm.setInt(1, contact.getIdTypeContact());
			pstm.setString(2, contact.getNom());
			pstm.setString(3, contact.getPrenom());
			pstm.setString(4, contact.getSoundexnom());
			return pstm.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return 0;
		}
	}
	
	/**
	 * La supression d'un contact
	 */
	public int deleteContact(int idContact) {
		try{
			String query="DELETE FROM contact WHERE idcontact=?";
			pstm=DB.getConection().prepareStatement(query);
			pstm.setInt(1, idContact);
			return pstm.executeUpdate();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return 0;
	}
	
	public int updateContact(Contact contact) {
		try {
			String query="UPDATE contact SET idtypescontact=?, nom=?, prenom=?, soundexnom=?"
					+ " WHERE idContact=?";
			pstm=DB.getConection().prepareStatement(query);
			pstm.setInt(1, contact.getIdTypeContact());
			pstm.setString(2, contact.getNom());
			pstm.setString(3, contact.getPrenom());
			pstm.setString(4, contact.getSoundexnom());
			pstm.setInt(5, contact.getIdContact());
			return pstm.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return 0;
		}
	}

}
