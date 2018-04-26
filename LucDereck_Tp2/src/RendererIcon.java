import java.awt.Component;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class RendererIcon extends DefaultTableCellRenderer {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3844040627931276107L;

	
	@Override
	public Component getTableCellRendererComponent(
			JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
		super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		
		String membre = value.toString();
		
		
		if (membre=="true") {
			
			setIcon(new ImageIcon(RendererIcon.class.getResource("/Images/member.gif")));
			this.setText("");
			setHorizontalAlignment(CENTER);
			
			
		}else {
			
			setIcon(new ImageIcon(RendererIcon.class.getResource("/Images/notMember.gif")));
			this.setText("");
			setHorizontalAlignment(CENTER);
		}
		
		
		 
		
		return this;
		
		
	}

}
