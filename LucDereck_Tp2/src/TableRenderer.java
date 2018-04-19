import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class TableRenderer  extends DefaultTableCellRenderer{

	  JLabel lbl = new JLabel();

	  ImageIcon icon = new ImageIcon("C:\\Users\\Luc\\Tp2\\LucDereck_Tp2\\bin\\member.png");

	  public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
	      boolean hasFocus, int row, int column) {
	    lbl.setText((String) value);
	    lbl.setIcon(icon);
	    return lbl;
	  }
}
