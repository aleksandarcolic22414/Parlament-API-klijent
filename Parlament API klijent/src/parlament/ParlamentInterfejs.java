package parlament;

import java.util.LinkedList;

import domain.Poslanik;

public interface ParlamentInterfejs {

	public boolean dodajPoslanika(Poslanik p);
	public boolean obrisiPoslanika(Poslanik p);
	public LinkedList<Poslanik> vratiSvePoslanike();
	public void sacuvajPoslanikeUFajl(String file);
	public void ucitajPoslanikeIzFajla(String file);
	public void dodajSvePoslanike(LinkedList<Poslanik> listaPoslanika);
}
