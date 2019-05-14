package controleurs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.DefaultListModel;

import medel.Contact;
import metier.Metier;
import vue.Fenetre;

public class EcouteurDialogRecherche implements ActionListener{

	Fenetre fenetre;
	
	public EcouteurDialogRecherche(Fenetre fenetre) {
		this.fenetre=fenetre;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		/**
		 * Si on veut chercher(La fenetre principale)
		 */
		if(e.getSource().equals(fenetre.getContactRechercheDialog().getRechercherButton())) {
			String nomCherche=fenetre.getContactRechercheDialog().getNomTextField().getText();
			String distance=fenetre.getContactRechercheDialog().getDistanceTextField().getText();
			fenetre.getContactRechercheResultatDialog().getNomTextField().setText(nomCherche);
			fenetre.getContactRechercheResultatDialog().getDistanceTextField().setText(distance);
			fenetre.getContactRechercheResultatDialog().setVisible(true);
		}	
		/**
		 * Si on veut Rechercher(Le dialog de recherche)
		 */
		else if(e.getSource().equals(fenetre.getContactRechercheResultatDialog().getRechercherButton())) {
			/**
			 * On recupere les donnees depuis le dialog
			 */
			String nomCherche=fenetre.getContactRechercheResultatDialog().getNomTextField().getText();
			String diatance=fenetre.getContactRechercheResultatDialog().getDistanceTextField().getText();
			
			/**
			 * On applique l'algorithme de soundex sur le nom
			 */
			String soundexNom=Metier.soundex(nomCherche);
			
			/**
			 * On recupere la liste des contacts depuis la base de donnees
			 */
			LinkedList<Contact> contacts=fenetre.getControleurContact().getContactsBySoundex(soundexNom);
			
			DefaultListModel<String> modelHomophones = new DefaultListModel<>();
			DefaultListModel<String> modelDistances = new DefaultListModel<>();
			
			for(Contact contact: contacts) {
				modelHomophones.addElement(contact.getNom());
				
				/**
				 * On applique l'algorithme de livenshtein
				 */
				int livenshteinDistance=Metier.livenshtein(nomCherche, contact.getNom());
				/**
				 * Si la disatance est inferieure a la distance entree par l'utilisateur
				 */
				if(livenshteinDistance<=Integer.parseInt(diatance)) {
					modelDistances.addElement(livenshteinDistance+"");
				}
			}
			
			/**
			 * Remplissage des listes
			 */
			fenetre.getContactRechercheResultatDialog().getHomophonesList().setModel(modelHomophones);
			fenetre.getContactRechercheResultatDialog().getDistancesList().setModel(modelDistances);
			
			/**
			 * Modification de la fenetre principale
			 */
			fenetre.getContactRechercheDialog().getNbHomophonesTextField().setText(modelHomophones.size()+"");
			fenetre.getContactRechercheDialog().getNbDistanceTextField().setText(modelDistances.size()+"");
		}
		/**
		 * Si on veut quitter le dialog de recherche
		 */
		else if(e.getSource().equals(fenetre.getContactRechercheResultatDialog().getQuiterButton())) {
			fenetre.getContactRechercheResultatDialog().setVisible(false);
		}
	}
	
	

}
