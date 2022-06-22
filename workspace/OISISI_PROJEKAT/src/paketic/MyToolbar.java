package paketic;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

public class MyToolBar extends JToolBar {

	public MyToolBar() {
		
		//
		//
		//
		// FALE IKONICE
		//
		//
		//
		
		super(SwingConstants.HORIZONTAL);
		JButton btnNew = new JButton();
		btnNew.setToolTipText("New");
		//btnNew.setIcon(new ImageIcon(""));
		add(btnNew);
		
		addSeparator();
		
		JButton btnEdit = new JButton();
		btnEdit.setToolTipText("Edit");
		//btnEdit.setIcon(new ImageIcon(""));
		add(btnEdit);
		
		addSeparator();
		
		JButton btnDelete = new JButton();
		btnDelete.setToolTipText("Delete");
		//btnDelete.setIcon(new ImageIcon(""));
		add(btnDelete);
		
		setFloatable(true);
		setBackground(new Color(255, 255, 255));
	}
}