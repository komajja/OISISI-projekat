package kontoleri;

import java.time.LocalDate;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import baza.BazaEmployees;
import baza.BazaSoftware;
import model.Adress;
import model.Employee;
import model.Software;
import paketic.MyFrame;
import paketic.WindowNewSoftware;

public class ControllerSoftware {

private static ControllerSoftware instance = null;
	
	public static ControllerSoftware getInstance() {
		if (instance == null) {
			instance = new ControllerSoftware();
		}
		return instance;
	}
	
	private ControllerSoftware(){}
	
	public void addSoftware() {
		WindowNewSoftware windowsoftware = new WindowNewSoftware('u');
	}
	
	public void deleteSoftware (int rowSelectedIndex) {
		ImageIcon icon=new ImageIcon("image/warning.png");
		
		int input = JOptionPane.showConfirmDialog(null,
					    "Are you sure you want to proceed?", "CONFIRMATION", 
					    JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, icon);
		if (input == 0) {
			Software software = BazaSoftware.getInstance().getRow(rowSelectedIndex);
			BazaSoftware.getInstance().deleteSoftware(software.getId());
			MyFrame.getInstance().updateDisplay();
		}
	}
	
	public void editSoftware() {
		WindowNewSoftware windowsoftware = new WindowNewSoftware('i');
	}
}
