package paketic;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class AboutUsPage extends JFrame {
	
	public AboutUsPage() {
		
		JDialog dijalogAboutUs;
		JFrame d=new JFrame();
		dijalogAboutUs=new JDialog(d,"About us",true);
		dijalogAboutUs.setSize(800,850);
		
		JPanel panCenter=new JPanel();
		BoxLayout boxCenter=new BoxLayout(panCenter,BoxLayout.Y_AXIS);
		panCenter.setLayout(boxCenter);
		dijalogAboutUs.add(panCenter,BorderLayout.CENTER);
		
		Dimension dim=new Dimension(610,200);
		
		//Osoba 1
		//slika
		ImageIcon icon=new ImageIcon("image/Ani2.gif");
		JLabel lblPic1=new JLabel();
		//lblPic1.setBackground(Color.YELLOW);
		lblPic1.setIcon(icon);
		
		//lblPic1.setSize(new Dimension(128,128));
		
		//tekst
		JPanel panPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblText1=new JLabel("Ime Prezime AI 00/2019");
		lblText1.setPreferredSize(dim);
		
		panPanel.add(lblPic1);
		panPanel.add(lblText1);
		//panPanel.add(Box.createRigidArea(new Dimension(500,0)));
		
		//Osoba 2
		
		//slika
		
		ImageIcon icon2=new ImageIcon("image/Pic1.png");
		JLabel lblPic2=new JLabel();
		lblPic2.setIcon(icon2);
		//lblPic1.setSize(new Dimension(128,128));
		
		//tekst
		JLabel lblText2=new JLabel("Ime Prezime AI 00/2019",SwingConstants.RIGHT);
		lblText2.setPreferredSize(dim);
								
		panPanel.add(lblText2);
		panPanel.add(lblPic2);
				
		//Osoba 3
		
		//slika
		ImageIcon icon3=new ImageIcon("image/Pic1.png");
		JLabel lblPic3=new JLabel();
		lblPic3.setIcon(icon3);
		//lblPic1.setSize(new Dimension(128,128));
				
		//tekst
				
		JLabel lblText3=new JLabel("Ime Prezime AI 00/2019");
		lblText3.setPreferredSize(dim);
				
		panPanel.add(lblPic3);
		panPanel.add(lblText3);
		
		//Osoba 4
		
		//slika
		ImageIcon icon4=new ImageIcon("image/Pic1.png");
		JLabel lblPic4=new JLabel();
		lblPic4.setIcon(icon4);
		//lblPic1.setSize(new Dimension(128,128));
						
		//tekst
					
		JLabel lblText4=new JLabel("Ime Prezime AI 00/2019",SwingConstants.RIGHT);
		lblText4.setPreferredSize(dim);
		
		panPanel.add(lblText4);		
		panPanel.add(lblPic4);
		
		
		
		
		panCenter.add(panPanel);
		
		
		//Bottom ako bude trebalo?
		JPanel panBottom=new JPanel();
		BoxLayout box=new BoxLayout(panBottom, BoxLayout.X_AXIS);
		panBottom.setLayout(box);
		dijalogAboutUs.add(panBottom,BorderLayout.SOUTH);
		
		
		
		
		
		dijalogAboutUs.setResizable(false);
		dijalogAboutUs.setVisible(true); 
		pack();
		
	}

}
