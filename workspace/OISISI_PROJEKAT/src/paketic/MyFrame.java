package paketic;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;


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
	setVisible(true);
	
//	JPanel panel = new JPanel();
//	panel.setBackground(Color.BLUE);
//	this.add(panel);
	
	MyMenuBar menu = new MyMenuBar();
	this.setJMenuBar(menu);
	
	
	}
	
}