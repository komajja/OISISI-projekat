package paketic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import kontoleri.ControllerEmployee;
import kontoleri.ControllerSoftware;
import paketic.MyFrame;
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
		
		miNewEmployee.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
					ControllerEmployee.getInstance().addEmployee();
			}
		});
		
		
		
		miNewSoftware.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
					ControllerSoftware.getInstance().addSoftware();
			}
		});
		
		miNew.add(miNewEmployee);
		miNew.addSeparator();
		miNew.add(miNewSoftware);
		
		//uvezanost new->softver i radnik 
		/*miNewEmployee.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	
            	WindowNewEmployee windowSoftware= new WindowNewEmployee();

            }
        });*/
		
		/*miNewSoftware.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	
            	WindowNewSoftware windowSoftware= new WindowNewSoftware();

            }
        });
		*/
		
		JMenu miOpen=new JMenu("Open");
		icon=new ImageIcon("image/temp.png");
		miOpen.setIcon(icon);
		JMenuItem miEmployee= new JMenuItem("Employee", new ImageIcon("image/temp.png"));
		JMenuItem miSoftware=new JMenuItem("Software", new ImageIcon("image/temp.png"));
		
		
		miOpen.add(miEmployee);
		miOpen.addSeparator();
		miOpen.add(miSoftware);
		
		
		
		miEmployee.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	
            	
            	int selectedTab = MyFrame.getInstance().getTab().getSelectedIndex();
            	if (selectedTab == 1) {
					// employee
            		
            		 MyFrame.getInstance().getTab().setSelectedIndex(0);
				}
            	


            }
        });
		
		miSoftware.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	
            	int selectedTab = MyFrame.getInstance().getTab().getSelectedIndex();
            	if (selectedTab == 0) {
					// employee
            		
            		 MyFrame.getInstance().getTab().setSelectedIndex(1);
				}


            }
        });
		
		JMenuItem miExit=new JMenuItem("Exit");
		icon=new ImageIcon("image/temp.png");
		miExit.setIcon(icon);
		
		file.add(miNew);
		file.addSeparator();
		file.add(miOpen);
		file.addSeparator();
		file.add(miExit);
		
		miExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	ImageIcon icon=new ImageIcon("image/warning.png");
				
        		int input = JOptionPane.showConfirmDialog(null,
        					    "Are you sure you want to proceed?", "CONFIRMATION", 
        					    JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, icon);
        		if (input==0)
            	System.exit(1);
            	
                 }
             });
		
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
				
				miAbout.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent arg0) {
		            	
		            	AboutUsPage windowSoftware= new AboutUsPage();
		            	
		                 }
		             });
			
				
				add(file);
				add(edit);
				add(help);			
		
	}
}
