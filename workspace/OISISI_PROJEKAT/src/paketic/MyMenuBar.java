package paketic;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import kontoleri.ControllerEmployee;
import kontoleri.ControllerSoftware;
public class MyMenuBar extends JMenuBar {

	//BOJE za GUI
			Color ColBraon=new Color(59,48,28);
			Color ColCrvena=new Color(207,68,39);
			Color ColKrem=new Color(235,226,195);
			Color ColBela=new Color(251,248,241);
			Color ColNaran=new Color(230,160,36);
			
			//
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MyMenuBar() {
		
		Icon icon = new ImageIcon(); 
		JMenu file=new JMenu("File");
				
		JMenu miNew= new JMenu("New");
		icon=new ImageIcon("image/new.png");
		miNew.setIcon(icon);
		JMenuItem miNewEmployee= new JMenuItem("Employee", new ImageIcon("image/emp.png"));
		JMenuItem miNewSoftware=new JMenuItem("Software", new ImageIcon("image/soft.png"));
		
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
		
		JMenu miOpen=new JMenu("Open");
		icon=new ImageIcon("image/open.png");
		miOpen.setIcon(icon);
		JMenuItem miEmployee= new JMenuItem("Employee", new ImageIcon("image/emp.png"));
		JMenuItem miSoftware=new JMenuItem("Software", new ImageIcon("image/soft.png"));
		
		
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
		icon=new ImageIcon("image/exit.png");
		miExit.setIcon(icon);
		
		file.setForeground(ColBraon);
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
				JMenuItem miEdit= new JMenuItem("Edit", new ImageIcon("image/edit.png"));
				JMenuItem miDelete=new JMenuItem("Delete", new ImageIcon("image/delete.png"));
				edit.setForeground(ColBraon);
				miDelete.setForeground(ColCrvena);
				ImageIcon icon1=new ImageIcon("image/warning.png");
				miEdit.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						int selectedTab = MyFrame.getInstance().getTab().getSelectedIndex();
						int input;
						
						if (selectedTab == 0) {
							if(MyFrame.getInstance().getTableEmployees().getSelectionModel().isSelectionEmpty()) {
								input = JOptionPane.showConfirmDialog(null,
									    "Nothing is selected", "CONFIRMATION", 
									    JOptionPane.PLAIN_MESSAGE, JOptionPane.INFORMATION_MESSAGE, icon1);
							}
							else ControllerEmployee.getInstance().editEmployee();
						} else if (selectedTab == 1) {
							if(MyFrame.getInstance().getTableSoftware().getSelectionModel().isSelectionEmpty()) {
							input = JOptionPane.showConfirmDialog(null,
								    "Nothing is selected", "CONFIRMATION", 
								    JOptionPane.PLAIN_MESSAGE, JOptionPane.INFORMATION_MESSAGE, icon1);
							}
							else ControllerSoftware.getInstance().editSoftware();
					    }
					
					}
				});
				
				miDelete.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						int selectedTab = MyFrame.getInstance().getTab().getSelectedIndex();
						int input;
						if (selectedTab == 0) {
							if(MyFrame.getInstance().getTableEmployees().getSelectionModel().isSelectionEmpty()) {
								input = JOptionPane.showConfirmDialog(null,
									    "Nothing is selected", "CONFIRMATION", 
									    JOptionPane.PLAIN_MESSAGE, JOptionPane.INFORMATION_MESSAGE, icon1);
							}
							else ControllerEmployee.getInstance().deleteEmployee(MyFrame.getTableEmployees().getSelectedRow());
						} else if (selectedTab == 1) {
							if(MyFrame.getInstance().getTableSoftware().getSelectionModel().isSelectionEmpty()) {
								input = JOptionPane.showConfirmDialog(null,
									    "Nothing is selected", "CONFIRMATION", 
									    JOptionPane.PLAIN_MESSAGE, JOptionPane.INFORMATION_MESSAGE, icon1);
							}
							else ControllerSoftware.getInstance().deleteSoftware(MyFrame.getTableSoftware().getSelectedRow());
							}
					}
				});
				
				edit.add(miEdit);
				edit.addSeparator();
				edit.add(miDelete);
				
				//Help
				
				JMenu help=new JMenu("Help");
				JMenuItem miAbout= new JMenuItem("About", new ImageIcon("image/about.png"));
				help.setForeground(ColBraon);
				
				help.add(miAbout);
				
				miAbout.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent arg0) {
		            	
		            	AboutUsPage windowSoftware= new AboutUsPage();
		            	
		                 }
		             });
			
				
				add(file);
				add(edit);
				add(help);			
				setBackground(ColBela);
				
				
				
	}
}
