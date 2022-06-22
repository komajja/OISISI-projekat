package paketic;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class AboutUsPage extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5686564232918136941L;
	//BOJE za GUI
	Color ColBraon=new Color(59,48,28);
	Color ColCrvena=new Color(207,68,39);
	Color ColKrem=new Color(235,226,195);
	Color ColBela=new Color(251,248,241);
	Color ColNaran=new Color(230,160,36);
	
	//
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
		ImageIcon icon=new ImageIcon("image/kokk.gif");
		JLabel lblPic1=new JLabel();
		lblPic1.setIcon(icon);
		
		//tekst
		JPanel panPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblText1=new JLabel("Daria Varga AI 23/2019");
		lblText1.setPreferredSize(dim);
		lblText1.setForeground(ColBraon);	
		panPanel.add(lblPic1);
		panPanel.add(lblText1);
		
		//Osoba 2
		
		//slika
		
		ImageIcon icon2=new ImageIcon("image/pip.gif");
		JLabel lblPic2=new JLabel();
		lblPic2.setIcon(icon2);
		
		//tekst
		JLabel lblText2=new JLabel("Kristina Rikic AI 33/2019",SwingConstants.RIGHT);
		lblText2.setPreferredSize(dim);
		lblText2.setForeground(ColBraon);				
		panPanel.add(lblText2);
		panPanel.add(lblPic2);
				
		//Osoba 3
		
		//slika
		ImageIcon icon3=new ImageIcon("image/pec.gif");
		JLabel lblPic3=new JLabel();
		lblPic3.setIcon(icon3);
				
		//tekst
				
		JLabel lblText3=new JLabel("Maja Kovac AI 38/2019");
		lblText3.setPreferredSize(dim);
		lblText3.setForeground(ColBraon);		
		panPanel.add(lblPic3);
		panPanel.add(lblText3);
		
		//Osoba 4
		
		//slika
		ImageIcon icon4=new ImageIcon("image/jezz.gif");
		JLabel lblPic4=new JLabel();
		lblPic4.setIcon(icon4);
				
		//tekst
					
		JLabel lblText4=new JLabel("Marija Tatar AI 47/2019",SwingConstants.RIGHT);
		lblText4.setPreferredSize(dim);
		lblText4.setForeground(ColBraon);	
		panPanel.add(lblText4);		
		panPanel.add(lblPic4);
		
		
		panCenter.add(panPanel);
		
		
//		//Bottom ako bude trebalo?
//		JPanel panBottom=new JPanel();
//		BoxLayout box=new BoxLayout(panBottom, BoxLayout.X_AXIS);
//		panBottom.setLayout(box);
//		dijalogAboutUs.add(panBottom,BorderLayout.SOUTH);
		
		
		dijalogAboutUs.setResizable(false);
		dijalogAboutUs.setVisible(true); 
		pack();
		
	}

}
