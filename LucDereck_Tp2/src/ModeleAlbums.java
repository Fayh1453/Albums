import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class ModeleAlbums extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ArrayList<Albums> lesDonnees;

	private final String[] lesTitres = { "Numéro", "Titre", "Ann\u00E9e", "Genre" };

	public ModeleAlbums(ArrayList<Albums> lesDonnees) {
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
			return lesDonnees.get(rowIndex).getTitre();

		case 2:
			return lesDonnees.get(rowIndex).getAnnee();
		case 3:
			return lesDonnees.get(rowIndex).getGenre();
		default:
			return null;
		}
	}
	
	@Override
	public String getColumnName(int columnIndex) {
		return lesTitres[columnIndex];
	}
	
	public Albums getElement(int row) {
		return lesDonnees.get(row);
		
	}
	
}
