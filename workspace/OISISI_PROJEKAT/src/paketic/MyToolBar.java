package paketic;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

import kontoleri.ControllerEmployee;

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
					// Profesor
					//ProfesorController.getInstance().dodajProfesora();
			    }
			}
		});
		
		add(btnNew);
		
		addSeparator();
		
		JButton btnEdit = new JButton();
		btnEdit.setToolTipText("Edit");
		//btnEdit.setIcon(new ImageIcon(""));
		btnEdit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedTab = MyFrame.getInstance().getTab().getSelectedIndex();
				if (selectedTab == 0) {
					// Employee
					ControllerEmployee.getInstance().editEmployee();
				} else if (selectedTab == 1) {
					// Profesor
					//ProfesorController.getInstance().dodajProfesora();
			    }
			}
		});
		
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