package paketic;

import javax.swing.table.AbstractTableModel;
import baza.BazaCetkica;

public class AbstractTableModelCetkice extends AbstractTableModel{

	@Override
	public int getRowCount() {
		if (BazaCetkica.getInstance().getBrushes() == null) {
			return 1;
		}
		return BazaCetkica.getInstance().getBrushes().size();
	}

 @Override
	public int getColumnCount() {
		return 3;
	}
 
 @Override
 public String getColumnName(int column) {
		return BazaCetkica.getInstance().getColumnName(column);
	}
 
 @Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return BazaCetkica.getInstance().getValueAt(rowIndex, columnIndex);
	}
	
}
