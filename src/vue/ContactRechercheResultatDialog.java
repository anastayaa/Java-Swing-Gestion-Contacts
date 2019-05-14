package vue;

import java.awt.BorderLayout;
import java.awt.Color;
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
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;

public class ContactRechercheResultatDialog extends JDialog{
	
	private JLabel nomLabel, distanceLabel, homophonesTrouveesLabel, distancesTrouveesLabel;
	private JTextField nomTextField, distanceTextField;
	private JButton rechercherButton, quiterButton;
	private JList<String> homophonesList, distancesList;
	
	public ContactRechercheResultatDialog(JFrame parent) {
		super(parent, "Resultat", false);
		
		nomLabel=new JLabel("Nom Cherche");
		distanceLabel=new JLabel("Distance mini");
		homophonesTrouveesLabel=new JLabel("Homophones trouvees");
		distancesTrouveesLabel=new JLabel("Distance Min trouvees");
		
		nomTextField=new JTextField(15);
		distanceTextField=new JTextField(10);
		
		rechercherButton=new JButton("Rechercher");
		quiterButton=new JButton("Quiter");
		
		homophonesList=new JList<>();
		distancesList=new JList<>();
		
		homophonesList.setPreferredSize(new Dimension(150, 150));
		homophonesList.setBorder(new LineBorder(Color.BLACK));
		distancesList.setPreferredSize(new Dimension(150, 150));
		distancesList.setBorder(new LineBorder(Color.BLACK));
		
		layoutControls();
		
		setSize(600, 450);
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
		gc.insets=noPadding;
		controlsPannel.add(distanceTextField, gc);
		
		/**
		 * Next row
		 */
		gc.weightx=1;
		gc.weighty=1;
		
		gc.gridy++;
		gc.gridx=0;
		gc.anchor=GridBagConstraints.LAST_LINE_END;
		gc.insets=rightPadding;
		controlsPannel.add(rechercherButton, gc);
		
		/**
		 * Next row
		 */
		gc.weightx=1;
		gc.weighty=1;
		gc.gridy++;
		
		gc.gridx=0;
		gc.anchor=GridBagConstraints.LAST_LINE_END;
		gc.insets=rightPadding;
		controlsPannel.add(homophonesTrouveesLabel, gc);
		
		gc.gridx++;
		gc.anchor=GridBagConstraints.LAST_LINE_END;
		gc.insets=rightPadding;
		controlsPannel.add(distancesTrouveesLabel, gc);
		
		/**
		 * Next row
		 */
		gc.weightx=1;
		gc.weighty=1;
		gc.gridy++;
		
		gc.gridx=0;
		gc.anchor=GridBagConstraints.LAST_LINE_END;
		gc.insets=rightPadding;
		controlsPannel.add(homophonesList, gc);
		
		gc.gridx++;
		gc.anchor=GridBagConstraints.LAST_LINE_END;
		gc.insets=rightPadding;
		controlsPannel.add(distancesList, gc);
		
		/**
		 * Next row
		 */
		gc.weightx=1;
		gc.weighty=1;
		
		gc.gridy++;
		gc.gridx=0;
		gc.anchor=GridBagConstraints.LAST_LINE_END;
		gc.insets=rightPadding;
		controlsPannel.add(quiterButton, gc);
		
		setLayout(new BorderLayout());
		add(controlsPannel, BorderLayout.CENTER);
	}

	public JTextField getNomTextField() {
		return nomTextField;
	}

	public JTextField getDistanceTextField() {
		return distanceTextField;
	}

	public JButton getRechercherButton() {
		return rechercherButton;
	}

	public JButton getQuiterButton() {
		return quiterButton;
	}

	public JList<String> getHomophonesList() {
		return homophonesList;
	}

	public JList<String> getDistancesList() {
		return distancesList;
	}

}
