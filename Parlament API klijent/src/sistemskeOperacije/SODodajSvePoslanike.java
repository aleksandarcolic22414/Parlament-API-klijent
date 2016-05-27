package sistemskeOperacije;

import java.util.LinkedList;

import domain.Poslanik;

public class SODodajSvePoslanike {

	public static void izvrsi(LinkedList<Poslanik> staraLista, LinkedList<Poslanik> novaLista){
		staraLista.clear();
		staraLista.addAll(novaLista);
	}
	
}
