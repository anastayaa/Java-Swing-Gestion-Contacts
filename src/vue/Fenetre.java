package vue;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JSplitPane;

import controleurs.ControleurContact;
import controleurs.EcouteurDialog;
import controleurs.EcouteurDialogRecherche;
import controleurs.EcouteurEntete;
import controleurs.EcouteurTableContact;
import medel.TypeContact;

public class Fenetre extends JFrame{
	
	private EntetePanel entetePanel;
	private ContactTablePanel contactTablePanel;
	private ContactDialog contactDialog;
	private ContactRechercheDialog contactRechercheDialog;
	private ContactRechercheResultatDialog contactRechercheResultatDialog;
	
	private ControleurContact controleurContact;
	private EcouteurEntete ecouteurEntete;
	private EcouteurDialog ecouteurDialog;
	private EcouteurTableContact ecouteurTableContact;
	private EcouteurDialogRecherche ecouteurDialogRecherche;
	
	public Fenetre() {
		
		this.setTitle("Gestion des etudiants");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(700,400);
		/**
		 * Pour centrer la fenetre dans le screen
		 */
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
		
		/**
		 * L'instanciation des panels
		 */
		entetePanel=new EntetePanel();
		contactTablePanel=new ContactTablePanel();
		contactDialog=new ContactDialog(this);
		contactRechercheDialog=new ContactRechercheDialog(this);
		contactRechercheResultatDialog=new ContactRechercheResultatDialog(this);
		
		controleurContact=new ControleurContact();
		ecouteurEntete=new EcouteurEntete(this);
		ecouteurDialog=new EcouteurDialog(this);
		ecouteurTableContact=new EcouteurTableContact(this);
		ecouteurDialogRecherche=new EcouteurDialogRecherche(this);
		
		/**
		 * L'ajout de donnees dans la table
		 */
		contactTablePanel.setData(controleurContact.getContacts());
		
		contactTablePanel.refresh();
		
		/**
		 * L'ajout des libelles dans le combobox du dilog
		 */
		for (TypeContact typeContact : controleurContact.getContactTypes()) {
			contactDialog.getTypeContactComboBox().addItem(typeContact.getLibelle());
		}
		
		/**
		 * Les evenements
		 */
		entetePanel.getExitItem().addActionListener(ecouteurEntete);
		entetePanel.getAjouterContactItem().addActionListener(ecouteurEntete);
		entetePanel.getChercherContactItem().addActionListener(ecouteurEntete);
		
		contactDialog.getCancelButton().addActionListener(ecouteurDialog);
		contactDialog.getOkButton().addActionListener(ecouteurDialog);
		
		contactTablePanel.getModifierButton().addActionListener(ecouteurTableContact);
		contactTablePanel.getDeleteButton().addActionListener(ecouteurTableContact);
		
		contactRechercheDialog.getRechercherButton().addActionListener(ecouteurDialogRecherche);
		contactRechercheResultatDialog.getRechercherButton().addActionListener(ecouteurDialogRecherche);
		contactRechercheResultatDialog.getQuiterButton().addActionListener(ecouteurDialogRecherche);
		
		
		/**
		 * Le layout manager de la fenetre
		 */
		this.setLayout(new BorderLayout());
		
		/**
		 */
		/**
		 * L'ajout des panels dans le layout principale
		 */
		this.add(entetePanel, BorderLayout.NORTH);
		this.add(contactTablePanel, BorderLayout.CENTER);
		
		/**
		 * Rendre la fenetre visible
		 */
		this.setVisible(true);
	}

	public EntetePanel getEntetePanel() {
		return entetePanel;
	}

	public ContactTablePanel getContactTablePanel() {
		return contactTablePanel;
	}

	public ContactDialog getContactDialog() {
		return contactDialog;
	}

	public ContactRechercheDialog getContactRechercheDialog() {
		return contactRechercheDialog;
	}

	public ContactRechercheResultatDialog getContactRechercheResultatDialog() {
		return contactRechercheResultatDialog;
	}

	public ControleurContact getControleurContact() {
		return controleurContact;
	}

}
