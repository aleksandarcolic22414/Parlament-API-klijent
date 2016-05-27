package sistemskeOperacije;

import java.util.LinkedList;

import domain.Poslanik;

public class SODodajPoslanika {

	public static boolean izvrsi(LinkedList<Poslanik> listaPoslanika, Poslanik poslanik){
		if(!listaPoslanika.contains(poslanik)){
			listaPoslanika.add(poslanik);
			return true;
		}
		else return false;
	}
	
}
