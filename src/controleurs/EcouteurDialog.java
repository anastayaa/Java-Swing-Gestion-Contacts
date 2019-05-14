package controleurs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import medel.Contact;
import medel.TypeContact;
import metier.Metier;
import vue.Fenetre;

public class EcouteurDialog implements ActionListener{

	Fenetre fenetre;
	
	public EcouteurDialog(Fenetre fenetre) {
		this.fenetre=fenetre;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource().equals(fenetre.getContactDialog().getCancelButton())) {
			fenetre.getContactDialog().setVisible(false);
		}
		else if(e.getSource().equals(fenetre.getContactDialog().getOkButton())) {
			String libelle=(String) fenetre.getContactDialog().getTypeContactComboBox().getSelectedItem();
			String nom=fenetre.getContactDialog().getNomTextField().getText();
			String prenom=fenetre.getContactDialog().getPrenomTextField().getText();
			String soundexnom=Metier.soundex(nom);
			TypeContact typeContact=fenetre.getControleurContact().getTypeContactByName(libelle);
			Contact contact=new Contact(typeContact.getIdTypesContact(), nom, prenom, soundexnom);
			
			if(fenetre.getContactDialog().getOkButton().getActionCommand().equals("Ajout")) {
				fenetre.getControleurContact().addContact(contact);
				fenetre.getContactTablePanel().setData(fenetre.getControleurContact().getContacts());
				fenetre.getContactTablePanel().refresh();
				JOptionPane.showMessageDialog(fenetre, "Le contact a été ajouté avec succes", "Succes", 
						JOptionPane.INFORMATION_MESSAGE);
			}
			else if(fenetre.getContactDialog().getOkButton().getActionCommand().equals("Modification")) {
				int rowIndex=fenetre.getContactTablePanel().getTable().getSelectedRow();
				contact=fenetre.getControleurContact().getContacts().get(rowIndex);
				contact.setNom(nom);
				contact.setPrenom(prenom);
				contact.setSoundexnom(soundexnom);
				contact.setIdTypeContact(typeContact.getIdTypesContact());
				int respone=JOptionPane.showConfirmDialog(fenetre, "Voulez-vous vraiment modifié le contact en question",
						"Confirmer la modification", JOptionPane.OK_CANCEL_OPTION);
				if(respone==JOptionPane.OK_OPTION) {
					fenetre.getControleurContact().updateContact(contact);
					fenetre.getContactTablePanel().setData(fenetre.getControleurContact().getContacts());
					fenetre.getContactTablePanel().refresh();
					JOptionPane.showMessageDialog(fenetre, "Le contact a été modifié avec succes", "Succes", 
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}
		
	}
	
}
