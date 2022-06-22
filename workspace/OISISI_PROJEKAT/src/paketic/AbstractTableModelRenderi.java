package paketic;

import javax.swing.table.AbstractTableModel;

import baza.BazaCetkica;
import baza.BazaRenderi;

public class AbstractTableModelRenderi extends AbstractTableModel{

	@Override
	public int getRowCount() {
		if (BazaRenderi.getInstance().getRenders() == null) {
			return 1;
		}
		return BazaRenderi.getInstance().getRenders().size();
	}

 @Override
	public int getColumnCount() {
		return 5;
	}
 
 @Override
 public String getColumnName(int column) {
		return BazaRenderi.getInstance().getColumnName(column);
	}
 
 @Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return BazaRenderi.getInstance().getValueAt(rowIndex, columnIndex);
	}
}
