import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class ModeleArtistes extends AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ArrayList<Artistes> lesDonnees;

	private final String[] lesTitres = { "Numéro", "Nom", "Membre"};

	public ModeleArtistes(ArrayList<Artistes> lesDonnees) {
		this.lesDonnees = lesDonnees;
	}

	@Override
	public int getColumnCount() {
		return lesTitres.length;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return lesDonnees.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {

		case 0:
			return lesDonnees.get(rowIndex).getNumero();

		case 1:
			return lesDonnees.get(rowIndex).getNom();

		case 2:
			return lesDonnees.get(rowIndex).getMembre();

		default:
			return null;
		}
	}
	
	@Override
	public String getColumnName(int columnIndex) {
		return lesTitres[columnIndex];
	}
	
	public Artistes getElement(int row) {
		return lesDonnees.get(row);
		
	}
	
}