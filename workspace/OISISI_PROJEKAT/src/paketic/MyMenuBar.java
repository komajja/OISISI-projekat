package paketic;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MyMenuBar extends JMenuBar {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MyMenuBar() {
		JMenu file=new JMenu("File");
		JMenuItem miNew= new JMenuItem("New");
		
		JMenu miOpen=new JMenu("Open");
		JMenuItem miEmployee= new JMenuItem("Employee");
		JMenuItem miSoftware=new JMenuItem("Software");
		
		miOpen.add(miEmployee);
		miOpen.addSeparator();
		miOpen.add(miSoftware);
		
		JMenuItem miExit=new JMenuItem("Exit");
		
		file.add(miNew);
		file.addSeparator();
		file.add(miOpen);
		file.addSeparator();
		file.add(miExit);
	
		add(file);
		
	}
}
