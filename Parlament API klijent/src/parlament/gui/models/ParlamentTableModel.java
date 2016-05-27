package parlament.gui.models;

import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import domain.Poslanik;

@SuppressWarnings("serial")
public class ParlamentTableModel extends AbstractTableModel{

	private static final String[] kolone = new String[]{"ID", "Name", "Last name", "Birth date"};
	private List<Poslanik> listaPoslanika = new LinkedList<>();
	
	public ParlamentTableModel() {
	}
	
	@Override
	public int getRowCount() {
		return listaPoslanika.size();
	}

	@Override
	public int getColumnCount() {
		return kolone.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Poslanik p = listaPoslanika.get(rowIndex);
		switch(columnIndex){
		case 0:
			return p.getId();
		case 1:
			return p.getFirstName();
		case 2:
			return p.getLastName();
		case 3:
			if(p.getBirthDate() != null)
				return new SimpleDateFormat("dd.MM.yyyy").format(p.getBirthDate());
			else return "NN";
		default: return "NN";
		}
	}
	
	@Override
	public String getColumnName(int column) {
		return kolone[column];
	}
	
	public void osveziTabelu(LinkedList<Poslanik> listaPoslanika){
		this.listaPoslanika = listaPoslanika;
		fireTableDataChanged();
	}
	
	public Poslanik vratiPoslanika(int index){
		return listaPoslanika.get(index);
	}
	
}