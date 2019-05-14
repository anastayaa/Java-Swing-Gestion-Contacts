package vue;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class ContactRechercheDialog extends JDialog{
	
	private JLabel nomLabel, distanceLabel, nbHomophonesLabel, nbDistanceLabel;
	private JTextField nomTextField, distanceTextField, nbHomophonesTextField, nbDistanceTextField;
	private JButton rechercherButton;
	
	public ContactRechercheDialog(JFrame parent) {
		super(parent, "Recherche", false);
		
		nomLabel=new JLabel("Nom Cherche");
		distanceLabel=new JLabel("Distance mini");
		nbHomophonesLabel=new JLabel("Nb Homophones");
		nbDistanceLabel=new JLabel("Nb Distance Mini");
		
		nomTextField=new JTextField(15);
		distanceTextField=new JTextField(10);
		nbHomophonesTextField=new JTextField(15);
		nbDistanceTextField=new JTextField(10);
		
		rechercherButton=new JButton("Chercher");
		
		setLayout(new GridBagLayout());
		
		layoutControls();
		
		setSize(700, 200);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
	}

	private void layoutControls() {
		JPanel controlsPannel=new JPanel();
		int space=15;
		Border titleBorder=BorderFactory.createTitledBorder("Rechercher");
		Border spaceBorder=BorderFactory.createEmptyBorder(space, space, space, space);
		
		/**
		 * Controls layout
		 */
		controlsPannel.setLayout(new GridBagLayout());
		controlsPannel.setBorder(BorderFactory.createCompoundBorder(spaceBorder, titleBorder));
		
		GridBagConstraints gc=new GridBagConstraints();
		Insets rightPadding=new Insets(0, 0, 0, 5);
		Insets noPadding=new Insets(0, 0, 0, 0);
		
		gc.fill=GridBagConstraints.NONE;
		/**
		 * First row
		 */
		gc.weightx=1;
		gc.weighty=1;
		
		gc.gridy=0;
		
		gc.gridx=0;
		gc.anchor=GridBagConstraints.EAST;
		gc.insets=rightPadding;
		controlsPannel.add(nomLabel, gc);
		
		gc.gridx++;
		gc.anchor=GridBagConstraints.WEST;
		gc.insets=rightPadding;
		controlsPannel.add(nomTextField, gc);
		
		gc.gridx++;
		gc.anchor=GridBagConstraints.WEST;
		gc.insets=rightPadding;
		controlsPannel.add(distanceLabel, gc);
		
		gc.gridx++;
		gc.anchor=GridBagConstraints.WEST;
		gc.insets=rightPadding;
		controlsPannel.add(distanceTextField, gc);
		
		gc.gridx++;
		gc.anchor=GridBagConstraints.WEST;
		gc.insets=noPadding;
		controlsPannel.add(rechercherButton, gc);
		
		/**
		 * Next row
		 */
		gc.weightx=1;
		gc.weighty=1;
		
		gc.gridy++;
		gc.gridx=0;
		gc.anchor=GridBagConstraints.EAST;
		gc.insets=rightPadding;
		controlsPannel.add(nbHomophonesLabel, gc);
		
		gc.gridx++;
		gc.anchor=GridBagConstraints.WEST;
		gc.insets=rightPadding;
		controlsPannel.add(nbHomophonesTextField, gc);
		
		gc.gridx++;
		gc.anchor=GridBagConstraints.WEST;
		gc.insets=rightPadding;
		controlsPannel.add(nbDistanceLabel, gc);
		
		gc.gridx++;
		gc.anchor=GridBagConstraints.WEST;
		gc.insets=noPadding;
		controlsPannel.add(nbDistanceTextField, gc);
		
		setLayout(new BorderLayout());
		add(controlsPannel, BorderLayout.CENTER);
	}

	public JTextField getNomTextField() {
		return nomTextField;
	}

	public JTextField getDistanceTextField() {
		return distanceTextField;
	}

	public JTextField getNbHomophonesTextField() {
		return nbHomophonesTextField;
	}

	public JTextField getNbDistanceTextField() {
		return nbDistanceTextField;
	}

	public JButton getRechercherButton() {
		return rechercherButton;
	}
	
}
