package medel;

public class Contact {

	int idContact;
	int idTypeContact;
	String nom;
	String prenom;
	String soundexnom;
	
	public Contact() {
	}
	
	public Contact(int idTypeContact, String nom, String prenom, String soundexnom) {
		super();
		this.idTypeContact = idTypeContact;
		this.nom = nom;
		this.prenom = prenom;
		this.soundexnom = soundexnom;
	}

	public Contact(int idContact, int idTypeContact, String nom, String prenom, String soundexnom) {
		super();
		this.idContact = idContact;
		this.idTypeContact = idTypeContact;
		this.nom = nom;
		this.prenom = prenom;
		this.soundexnom = soundexnom;
	}

	public int getIdContact() {
		return idContact;
	}
	public void setIdContact(int idContact) {
		this.idContact = idContact;
	}
	public int getIdTypeContact() {
		return idTypeContact;
	}
	public void setIdTypeContact(int idTypeContact) {
		this.idTypeContact = idTypeContact;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getSoundexnom() {
		return soundexnom;
	}
	public void setSoundexnom(String soundexnom) {
		this.soundexnom = soundexnom;
	}

}
