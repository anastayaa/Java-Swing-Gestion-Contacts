package vue;

import javax.swing.SwingUtilities;

import metier.Metier;



public class App {
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Fenetre layout=new Fenetre();
			}
		});
	}

}