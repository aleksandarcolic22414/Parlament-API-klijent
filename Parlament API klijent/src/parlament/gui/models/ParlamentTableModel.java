package parlament.gui.models;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import domain.Poslanik;
import parlament.Parlament;
import parlament.gui.KontrolerGUI;

@SuppressWarnings("serial")
public class ParlamentTableModel extends AbstractTableModel{

	private static final String[] kolone = new String[]{"ID", "Name", "Last name", "Birth date"};
	private List<Poslanik> listaPoslanika;
	
	public ParlamentTableModel() {
		listaPoslanika  = new LinkedList<>();
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
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		Poslanik p = listaPoslanika.get(rowIndex);
		switch(columnIndex){
		case 1: if(aValue instanceof String){
					if(aValue.equals("")){
						KontrolerGUI.obavesti();
						return;
					}
					
					else {
						p.setFirstName((String)aValue);
						break;
					}
				}else break;
			
		case 2:
			if(aValue instanceof String){
				if(aValue.equals("")){
					KontrolerGUI.obavesti();
					return;
				}
				else {
					p.setLastName((String)aValue);
					break;
				}
			} else break;
		case 3:
			if(aValue instanceof String){
				if(aValue.equals("")){
					KontrolerGUI.obavesti();
					return;
				}
				else {
					String s = ((String)aValue);
					String[] pom = s.trim().split("\\.");
					if(pom.length != 3 || pom[0].length() > 2 
							|| pom[1].length() > 2 
							|| pom[2].length() != 4){
						KontrolerGUI.obavesti();
						return;
					}
					else {
						try{
							int dan = Integer.parseInt(pom[0]);
							int mesec = Integer.parseInt(pom[1]);
							int godina = Integer.parseInt(pom[2]);
							
							if(dan < 1 || dan > 31 || mesec < 1 || mesec > 12 || godina < 1800
									|| godina > 2000){
								KontrolerGUI.obavesti();
								return;
							}
							
							p.setBirthDate(new GregorianCalendar(godina, mesec - 1, dan).getTime());
							break;
						} catch(NumberFormatException e){
							KontrolerGUI.obavesti();
						}
					}
					
				}
			}
		default: break;
		
		}
	}
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return columnIndex != 0;
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