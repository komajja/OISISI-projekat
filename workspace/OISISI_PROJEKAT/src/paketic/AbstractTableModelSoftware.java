package paketic;

import javax.swing.table.AbstractTableModel;

import baza.BazaSoftware;

public class AbstractTableModelSoftware extends AbstractTableModel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1101690912459067379L;

	@Override
	public int getRowCount() {
		if (BazaSoftware.getInstance().getSoftware() == null) {
			return 1;
		}
		return BazaSoftware.getInstance().getSoftware().size();
	}

 @Override
	public int getColumnCount() {
		return 6;
	}
 
 @Override
 public String getColumnName(int column) {
		return BazaSoftware.getInstance().getColumnName(column);
	}
 
 @Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return BazaSoftware.getInstance().getValueAt(rowIndex, columnIndex);
	}

}
