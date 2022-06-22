package paketic;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MyMenuBar extends JMenuBar {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MyMenuBar() {
		//
		//za ikonice dodato samo privremeno, IZMENI
		//
		Icon icon = new ImageIcon(); //za JMenu ikonice
		//file
		JMenu file=new JMenu("File");
				
		JMenu miNew= new JMenu("New");
		icon=new ImageIcon("image/temp.png");
		miNew.setIcon(icon);
		JMenuItem miNewEmployee= new JMenuItem("Employee", new ImageIcon("image/temp.png"));
		JMenuItem miNewSoftware=new JMenuItem("Software", new ImageIcon("image/temp.png"));
		
		miNew.add(miNewEmployee);
		miNew.addSeparator();
		miNew.add(miNewSoftware);
		
		JMenu miOpen=new JMenu("Open");
		icon=new ImageIcon("image/temp.png");
		miOpen.setIcon(icon);
		JMenuItem miEmployee= new JMenuItem("Employee", new ImageIcon("image/temp.png"));
		JMenuItem miSoftware=new JMenuItem("Software", new ImageIcon("image/temp.png"));
		
		miOpen.add(miEmployee);
		miOpen.addSeparator();
		miOpen.add(miSoftware);
		
		JMenuItem miExit=new JMenuItem("Exit");
		icon=new ImageIcon("image/temp.png");
		miExit.setIcon(icon);
		
		file.add(miNew);
		file.addSeparator();
		file.add(miOpen);
		file.addSeparator();
		file.add(miExit);
		
		//Edit
		JMenu edit=new JMenu("Edit");
		JMenuItem miEdit= new JMenuItem("Edit", new ImageIcon("image/temp.png"));
		JMenuItem miDelete=new JMenuItem("Delete", new ImageIcon("image/temp.png"));
		
		edit.add(miEdit);
		edit.addSeparator();
		edit.add(miDelete);
		
		//Help
		
		JMenu help=new JMenu("Help");
		JMenuItem miAbout= new JMenuItem("About", new ImageIcon("image/temp.png"));
		
		help.add(miAbout);
		
		add(file);
		add(edit);
		add(help);		
		
	}
}
