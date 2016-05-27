package sistemskeOperacije;

import java.util.LinkedList;

import domain.Poslanik;

public class SOObrisiPoslanika {

	public static boolean izvrsi(LinkedList<Poslanik> listaPoslanika, Poslanik p){
		if(listaPoslanika.contains(p)){
			listaPoslanika.remove(p);
			return true;
		}
		else return false;
	}
	
}
