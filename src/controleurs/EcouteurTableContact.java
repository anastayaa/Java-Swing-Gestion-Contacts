package controleurs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import medel.Contact;
import vue.Fenetre;

public class EcouteurTableContact implements ActionListener{
	
	Fenetre fenetre;
	
	public EcouteurTableContact(Fenetre fenetre) {
		this.fenetre=fenetre;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int rowIndex=fenetre.getContactTablePanel().getTable().getSelectedRow();
		if(rowIndex==-1) {
			// message d'erreur
		}
		else {
			Contact contact=fenetre.getControleurContact().getContacts().get(rowIndex);
			
			if(e.getSource().equals(fenetre.getContactTablePanel().getDeleteButton())) {
				int respone=JOptionPane.showConfirmDialog(fenetre, "Voulez-vous vraiment supprimé le contact en question",
						"Confirmer la modification", JOptionPane.OK_CANCEL_OPTION);
				if(respone==JOptionPane.OK_OPTION) {
					fenetre.getControleurContact().deleteContact(contact.getIdContact());
					fenetre.getContactTablePanel().setData(fenetre.getControleurContact().getContacts());
					fenetre.getContactTablePanel().refresh();
					JOptionPane.showMessageDialog(fenetre, "Le contact a été supprimé avec succes", "Succes", 
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
			else if(e.getSource().equals(fenetre.getContactTablePanel().getModifierButton())) {
				fenetre.getContactDialog().getNomTextField().setText(contact.getNom());
				fenetre.getContactDialog().getPrenomTextField().setText(contact.getPrenom());
				fenetre.getContactDialog().getOkButton().setText("Modifier");
				fenetre.getContactDialog().getOkButton().setActionCommand("Modification");
				fenetre.getContactDialog().setVisible(true);
			}
		}
	}
}
