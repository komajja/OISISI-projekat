package paketic;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;


public class MyFrame extends JFrame{

	public MyFrame() {
	Toolkit kit = Toolkit.getDefaultToolkit();
	Dimension screenSize = kit.getScreenSize();
	int screenHeight = screenSize.height;
	int screenWidth = screenSize.width;
	setSize(screenWidth*3/4, screenHeight*3/4);
	setTitle("Animacija");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setLocationRelativeTo(null);
	
	MyMenuBar menu = new MyMenuBar();
	this.setJMenuBar(menu);
	
	setVisible(true);
	
	JPanel panel = new JPanel();
	panel.setBackground(new Color(59,48,27));
	panel.setLayout(new BorderLayout());
	this.add(panel, BorderLayout.CENTER);
	
	MyToolBar toolbar = new MyToolBar();
	panel.add(toolbar, BorderLayout.SOUTH);
	
	MyStatusBar statusbar = new MyStatusBar();
	statusbar.setPreferredSize(new Dimension(this.getWidth(), 20));
	this.add(statusbar, BorderLayout.SOUTH);
	statusbar.setLayout(new BoxLayout(statusbar,BoxLayout.LINE_AXIS));
	Date date = new Date();
	DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    String today = formatter.format(date);
	JLabel dateLabel = new JLabel(today);
	statusbar.add(Box.createHorizontalGlue());
	statusbar.add(dateLabel);
	statusbar.add(Box.createRigidArea(new Dimension(5,0)));
	
	JTabbedPane tabbedPane = new JTabbedPane();


/////////SADRZAJ TABELE ZAPOSLENI//////
	
	String[] columnNames= {"First Name", 
			"Last Name",
			"JMBG",
			"Date of birth",
			"Adress", "Email",
			"Position",
			"Software"
			};

	
	Object[][]data= {

			{"First Name", 
				"Last Name",
				"JMBG",
				"Date of birth",
				"Adress", "Email",
				"Position",
				"Software"
				//za selekciju imamo vec red da selektuje	 			
			},

			{"First Name", 
				"Last Name",
				"JMBG",
				"Date of birth",
				"Adress", "Email",
				"Position",
				"Software" 
				//za selekciju	imamo vec red da selektuje			
			},
			
			{"First Name", 
				"Last Name",
				"JMBG",
				"Date of birth",
				"Adress", "Email",
				"Position",
				"Software" 
				//za selekciju	imamo vec red da selektuje			
			}

}; //kraj Object[][]data	
	
	
	
/////////SADRZAJ TABELE SOFTVER//////
	
	String[] columnNames2= {"Name", 
			"Brush(use,color)", //ZA BOJU TREBA BAS BOJA A NE STRING, mozda preko labele IZGUGLATI
			"Modifier",
			"File format",
			"Animation tools", "Render(light, material, camera, object)"
			};

	
	Object[][]data2= {

			{"Name", 
				"Brush(use,color)",
				"Modifier",
				"File format",
				"Animation tools", "Render(light, material, camera, object)" 			
			},
			
			{"Name", 
				"Brush(use,color)",
				"Modifier",
				"File format",
				"Animation tools", "Render(light, material, camera, object)" 			
			},
			
			{"Name", 
				"Brush(use,color)",
				"Modifier",
				"File format",
				"Animation tools", "Render(light, material, camera, object)" 			
			}
		

}; //kraj Object[][]data2
	
		
	
	
///////TABELA ZAPOSLENI///////
	
	JTable TableEmployee=new JTable(data, columnNames) {
        
        public boolean isCellEditable(int row, int column) {     //ovo je da korisnik ne moze da se edituje cell            
                return false;               
        };
    };
		
	JScrollPane scrollPaneEmployee = new JScrollPane(TableEmployee);
	tabbedPane.addTab("Employees", scrollPaneEmployee);
	panel.add(tabbedPane, BorderLayout.CENTER);
	
	
/////////TABELA SOFTVER//////////
	
JTable TableSoftware=new JTable(data2, columnNames2) {
        
        public boolean isCellEditable(int row, int column) {     //ovo je da korisnik ne moze da se edituje cell            
                return false;               
        };
    };
		
	
	JScrollPane scrollPaneSoftware = new JScrollPane(TableSoftware);
	tabbedPane.addTab("Software", scrollPaneSoftware);

	
//	JPanel panel = new JPanel();
//	panel.setBackground(Color.BLUE);
//	this.add(panel);
	
	
	
	
	}

	
	
}