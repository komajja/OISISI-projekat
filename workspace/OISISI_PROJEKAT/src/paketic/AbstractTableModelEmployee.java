package paketic;

import javax.swing.table.AbstractTableModel;
import baza.BazaEmployees;

public class AbstractTableModelEmployee extends AbstractTableModel {
 
	 @Override
		public int getRowCount() {
			if (BazaEmployees.getInstance().getEmployees() == null) {
				return 1;
			}
			return BazaEmployees.getInstance().getEmployees().size();
		}

	 @Override
		public int getColumnCount() {
			return 8;
		}
	 
	 @Override
	 public String getColumnName(int column) {
			return BazaEmployees.getInstance().getColumnName(column);
		}
	 
	 @Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			return BazaEmployees.getInstance().getValueAt(rowIndex, columnIndex);
		}
}
