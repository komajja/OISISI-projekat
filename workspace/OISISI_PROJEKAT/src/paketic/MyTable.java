package paketic;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;

public class MyTable extends JTable {

	public MyTable(AbstractTableModel model) {
		this.setRowSelectionAllowed(true);
		//iskljucili smo selekciju kolona
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(model);
	}

	public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
		Component c = super.prepareRenderer(renderer, row, column);
		if (isRowSelected(row)) {
			c.setBackground(Color.LIGHT_GRAY);
		} else {
			c.setBackground(Color.WHITE);
		}
		return c;
	}

}
