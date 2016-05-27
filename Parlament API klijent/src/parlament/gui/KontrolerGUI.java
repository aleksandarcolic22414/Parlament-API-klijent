package parlament.gui;

import java.awt.EventQueue;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;

import communication.ParlamentAPIKomunikacija;
import domain.Poslanik;
import parlament.Parlament;
import parlament.ParlamentInterfejs;
import parlament.gui.models.ParlamentTableModel;

public class KontrolerGUI {

	private static final String urlPoslanika = 
			"http://147.91.128.71:9090/parlament/api/members";
	private static String file = "data/serviceMembers.json";
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
		try {
			
			String rezultat = ParlamentAPIKomunikacija.sendGet(urlPoslanika);
			PrintWriter out = new PrintWriter(
					new FileWriter(file));
			
			out.println(rezultat);
			out.close();
			
			glavniProzor.getTxtStatus().setText("Poslanici su preuzeti sa servisa.");			
			
		} catch (IOException e) {
			glavniProzor.getTxtStatus().setText("" + "Greska prilikom ucitavanja poslanika sa servera.");
		}
		
	}

	public static void napuniTabeluPodacima() {
		try {
			LinkedList<Poslanik> ListaPoslanikaIzFajla = 
					(LinkedList<Poslanik>) ParlamentAPIKomunikacija.vratiPoslanikeIzFajla(file);
			ParlamentTableModel model = (ParlamentTableModel) glavniProzor.
					getTblParlamentTable().getModel();
			parlament.dodajSvePoslanike(ListaPoslanikaIzFajla);
			model.osveziTabelu(parlament.vratiSvePoslanike());
			glavniProzor.getTxtStatus().setText("Uspesno ucitani poslanici iz fajla");
			
		} catch (IOException e) {
			glavniProzor.getTxtStatus().setText("Greska prilikom ucitavanja poslanika iz fajla");
		}
	}
	
}
