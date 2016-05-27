package parlament.gui;

import java.awt.EventQueue;

import parlament.Parlament;
import parlament.ParlamentInterfejs;

public class KontrolerGUI {

	private static ParlamentGUI glavniProzor;
	private static ParlamentInterfejs parlament;
	
	/**
	 * Pokretanje aplikacije
	 * @param args
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					parlament = new Parlament();
					glavniProzor = new ParlamentGUI();
					glavniProzor.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static void ucitajPoslanikeSaSajta() {
		
		
	}
	
}
