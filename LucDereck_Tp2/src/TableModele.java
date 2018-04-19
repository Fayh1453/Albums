import javax.swing.table.AbstractTableModel;

public class TableModele extends AbstractTableModel {

	  public Object getValueAt(int row, int column) {
		    return "" + (row * column);
		  }

		  public int getColumnCount() {
		    return 4;
		  }

		  public int getRowCount() {
		    return 5;
		  }
}

