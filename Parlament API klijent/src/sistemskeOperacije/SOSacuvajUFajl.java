package sistemskeOperacije;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.LinkedList;

import domain.Poslanik;

public class SOSacuvajUFajl {

	public static void izvrsi(LinkedList<Poslanik> listaPoslanika, String putanja){
		try {
			ObjectOutputStream out = new ObjectOutputStream(
					new BufferedOutputStream(
							new FileOutputStream(putanja)));
			
			out.writeObject(listaPoslanika);
			out.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
