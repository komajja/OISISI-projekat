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
		btnNew.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedTab = MyFrame.getInstance().getTab().getSelectedIndex();
				if (selectedTab == 0) {
					// Student
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
		//btnEdit.setIcon(new ImageIcon(""));
		ImageIcon icon=new ImageIcon("image/warning.png");
		
		
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedTab = MyFrame.getInstance().getTab().getSelectedIndex();
								
					int input = JOptionPane.showConfirmDialog(null,
						    "Nothing is selected", "CONFIRMATION", 
						    JOptionPane.PLAIN_MESSAGE, JOptionPane.INFORMATION_MESSAGE, icon);
				
			
				
				/*if (selectedTab == 0) {
					// Employee
					ControllerEmployee.getInstance().editEmployee();
				/*} else if (selectedTab == 1) {
					int input = JOptionPane.showConfirmDialog(null,
						    "Are you sure you want to proceed?", "CONFIRMATION", 
						    JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE, icon);*/
			    //}
			}
		});
		
		add(btnEdit);
		
		addSeparator();
		
		JButton btnDelete = new JButton();
		btnDelete.setToolTipText("Delete");
		//btnDelete.setIcon(new ImageIcon(""));
		

		
		
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedTab = MyFrame.getInstance().getTab().getSelectedIndex();
								
					int input = JOptionPane.showConfirmDialog(null,
						    "Nothing is selected", "CONFIRMATION", 
						    JOptionPane.PLAIN_MESSAGE, JOptionPane.INFORMATION_MESSAGE, icon);
				
			
				
				/*if (selectedTab == 0) {
					// Employee
					ControllerEmployee.getInstance().editEmployee();
				/*} else if (selectedTab == 1) {
					int input = JOptionPane.showConfirmDialog(null,
						    "Are you sure you want to proceed?", "CONFIRMATION", 
						    JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE, icon);*/
			    //}
			}
		});
		add(btnDelete);
		
		setFloatable(true);
		setBackground(new Color(255, 255, 255));
		

	}
	
	

}