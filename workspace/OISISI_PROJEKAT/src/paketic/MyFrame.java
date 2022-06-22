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
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;


public class MyFrame extends JFrame{

	public MyFrame() {
	Toolkit kit = Toolkit.getDefaultToolkit();
	Dimension screenSize = kit.getScreenSize();
	int screenHeight = screenSize.height;
	int screenWidth = screenSize.width;
	setSize(screenWidth / 2, screenHeight / 2);
	setTitle("Animacija");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setLocationRelativeTo(null);
	
	MyMenuBar menu = new MyMenuBar();
	this.setJMenuBar(menu);
	
	JPanel panel = new JPanel();
	panel.setBackground(Color.BLUE);
	panel.setLayout(new BorderLayout());
	this.add(panel, BorderLayout.CENTER);
	
	MyToolbar toolbar = new MyToolbar();
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

	//MyTable TableEmployee=new MyTable();
	
	JScrollPane scrollPaneEmployee = new JScrollPane(/*DODATI TABELLY*/);
	tabbedPane.addTab("Employees", scrollPaneEmployee);
	panel.add(tabbedPane, BorderLayout.CENTER);
	
	JScrollPane scrollPaneSoftware = new JScrollPane(/*DODATI TABELLY*/);
	tabbedPane.addTab("Software", scrollPaneSoftware);
	setVisible(true);
	
	}
	
}