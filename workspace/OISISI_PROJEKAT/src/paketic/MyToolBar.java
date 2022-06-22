package paketic;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

import baza.BazaEmployees;
import kontoleri.ControllerEmployee;
import kontoleri.ControllerSoftware;

public class MyToolBar extends JToolBar {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2526322830292088026L;
			//BOJE za GUI
			Color ColBraon=new Color(59,48,28);
			Color ColCrvena=new Color(207,68,39);
			Color ColKrem=new Color(235,226,195);
			Color ColBela=new Color(251,248,241);
			Color ColNaran=new Color(230,160,36);
			
			//
	public MyToolBar() {
		
		super(SwingConstants.HORIZONTAL);
		JButton btnNew = new JButton();
		btnNew.setToolTipText("New");
		btnNew.setIcon(new ImageIcon("image/new.png"));
		btnNew.setBackground(ColKrem);		
		btnNew.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedTab = MyFrame.getInstance().getTab().getSelectedIndex();
				if (selectedTab == 0) {
					// Zaposleni
					ControllerEmployee.getInstance().addEmployee();
				} else if (selectedTab == 1) {
					// Softver
					ControllerSoftware.getInstance().addSoftware();
			    }
			}
		});
		
		add(btnNew);
		
		addSeparator();
		
		JButton btnEdit = new JButton();
		btnEdit.setToolTipText("Edit");
		btnEdit.setIcon(new ImageIcon("image/edit.png"));
		btnEdit.setBackground(ColKrem);	
		ImageIcon icon=new ImageIcon("image/warning.png");
		
		
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedTab = MyFrame.getInstance().getTab().getSelectedIndex();
				int input;
				
				if (selectedTab == 0) {
					if(MyFrame.getInstance().getTableEmployees().getSelectionModel().isSelectionEmpty()) {
						input = JOptionPane.showConfirmDialog(null,
							    "Nothing is selected", "CONFIRMATION", 
							    JOptionPane.PLAIN_MESSAGE, JOptionPane.INFORMATION_MESSAGE, icon);
					}
					else ControllerEmployee.getInstance().editEmployee();
				} else if (selectedTab == 1) {
					if(MyFrame.getInstance().getTableSoftware().getSelectionModel().isSelectionEmpty()) {
					input = JOptionPane.showConfirmDialog(null,
						    "Nothing is selected", "CONFIRMATION", 
						    JOptionPane.PLAIN_MESSAGE, JOptionPane.INFORMATION_MESSAGE, icon);
					}
					else ControllerSoftware.getInstance().editSoftware();
			    }
			}
		});
		
		add(btnEdit);
		
		addSeparator();
		
		JButton btnDelete = new JButton();
		btnDelete.setToolTipText("Delete");
		btnDelete.setIcon(new ImageIcon("image/delete.png"));
		btnDelete.setBackground(ColKrem);	

		
		
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedTab = MyFrame.getInstance().getTab().getSelectedIndex();
				int input;
				if (selectedTab == 0) {
					if(MyFrame.getInstance().getTableEmployees().getSelectionModel().isSelectionEmpty()) {
						input = JOptionPane.showConfirmDialog(null,
							    "Nothing is selected", "CONFIRMATION", 
							    JOptionPane.PLAIN_MESSAGE, JOptionPane.INFORMATION_MESSAGE, icon);
					}
					else ControllerEmployee.getInstance().deleteEmployee(MyFrame.getTableEmployees().getSelectedRow());
				} else if (selectedTab == 1) {
					if(MyFrame.getInstance().getTableSoftware().getSelectionModel().isSelectionEmpty()) {
						input = JOptionPane.showConfirmDialog(null,
							    "Nothing is selected", "CONFIRMATION", 
							    JOptionPane.PLAIN_MESSAGE, JOptionPane.INFORMATION_MESSAGE, icon);
					}
					else ControllerSoftware.getInstance().deleteSoftware(MyFrame.getTableSoftware().getSelectedRow());
					}

			}
		});
		add(btnDelete);
		
		setFloatable(true);
		setBackground(ColKrem);
		

	}
	
	

}