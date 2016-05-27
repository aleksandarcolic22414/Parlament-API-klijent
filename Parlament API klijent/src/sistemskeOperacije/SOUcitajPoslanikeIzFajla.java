package sistemskeOperacije;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.LinkedList;

import domain.Poslanik;

public class SOUcitajPoslanikeIzFajla {

	public static void izvrsi(LinkedList<Poslanik> listaPoslanika, String putanja){
		try {
			ObjectInputStream in = new ObjectInputStream(
					new BufferedInputStream(
							new FileInputStream(putanja)));
			
			LinkedList<Poslanik> novaListaPoslanika = (LinkedList<Poslanik>) in.readObject();
			listaPoslanika.clear();
			listaPoslanika.addAll(novaListaPoslanika);
			
			in.close();
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
}
