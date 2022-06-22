package kontoleri;

import java.time.LocalDate;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import baza.BazaEmployees;
import baza.BazaSoftware;
import model.Adress;
import model.Employee;
import paketic.MyFrame;
import paketic.WindowNewEmployee;

public class ControllerEmployee {

private static ControllerEmployee instance = null;
	
	public static ControllerEmployee getInstance() {
		if (instance == null) {
			instance = new ControllerEmployee();
		}
		return instance;
	}
	
	private ControllerEmployee(){}
	
	public void addEmployee() {
		WindowNewEmployee windowemployee = new WindowNewEmployee('u');
	}
	
	public void deleteEmployee (int rowSelectedIndex) {
		ImageIcon icon=new ImageIcon("image/warning.png");
		
		int input = JOptionPane.showConfirmDialog(null,
					    "Are you sure you want to proceed?", "CONFIRMATION", 
					    JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, icon);
		if (input == 0) {
			Employee employee = BazaEmployees.getInstance().getRow(rowSelectedIndex);
			BazaEmployees.getInstance().deleteEmployee(employee.getId());
			MyFrame.getInstance().updateDisplay();
		}
	}
	
	public void editEmployee() {
		WindowNewEmployee windowemployee = new WindowNewEmployee('i');
	}
}
