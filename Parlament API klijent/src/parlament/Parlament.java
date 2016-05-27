package parlament;

import java.util.LinkedList;

import domain.Poslanik;
import sistemskeOperacije.SODodajPoslanika;
import sistemskeOperacije.SODodajSvePoslanike;
import sistemskeOperacije.SOObrisiPoslanika;
import sistemskeOperacije.SOSacuvajUFajl;
import sistemskeOperacije.SOUcitajPoslanikeIzFajla;

public class Parlament implements ParlamentInterfejs{

	private LinkedList<Poslanik> listaPoslanika;
	
	
	public Parlament(){
		listaPoslanika = new LinkedList<>();
	}

	@Override
	public boolean dodajPoslanika(Poslanik p) {
		return SODodajPoslanika.izvrsi(listaPoslanika, p);
	}

	@Override
	public boolean obrisiPoslanika(Poslanik p) {
		return SOObrisiPoslanika.izvrsi(listaPoslanika, p);
	}

	@Override
	public LinkedList<Poslanik> vratiSvePoslanike() {
		return listaPoslanika;
	}

	@Override
	public void sacuvajPoslanikeUFajl(String putanja) {
		SOSacuvajUFajl.izvrsi(listaPoslanika, putanja);
	}

	@Override
	public void ucitajPoslanikeIzFajla(String putanja) {
		SOUcitajPoslanikeIzFajla.izvrsi(listaPoslanika, putanja);
	}

	@Override
	public void dodajSvePoslanike(LinkedList<Poslanik> novaListaPoslanika) {
		SODodajSvePoslanike.izvrsi(listaPoslanika, novaListaPoslanika);
	}
	
	
	
}
