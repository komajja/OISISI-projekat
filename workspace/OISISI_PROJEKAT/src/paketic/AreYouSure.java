package paketic;

import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class AreYouSure extends JFrame{ //da li treba JFrame ili MyFrame (ovde ima dupliranje)

	public AreYouSure() {
		
	ImageIcon icon=new ImageIcon("image/slikica.jpg");
	
	JDialog dialogAreYouSure;
	JFrame a=new JFrame();
	dialogAreYouSure=new JDialog(a,"Confirmation",true);
		
	
	int input= JOptionPane.showConfirmDialog(new AreYouSure(),
	    "Are you sure you want to proceed?", "CONFIRMATION", 
		    JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, icon);
		System.out.println(input);
	
	JPanel panCenter=new JPanel(new FlowLayout(FlowLayout.LEFT));
	JLabel labela=new JLabel();
	//labela.add(input);
	panCenter.add(labela);
		
			
//		ImageIcon icon=new ImageIcon("image/slikica.jpg");
//	int input=JOptionPane.showConfirmDialog(new AreYouSure(),
//	    "Are you sure you want to proceed?", "CONFIRMATION", 
//	    JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, icon);
//	System.out.println(input);
	
	dialogAreYouSure.setResizable(false);
	dialogAreYouSure.setVisible(true); 
	pack();
	}
}
