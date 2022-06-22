package paketic;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class WindowNewSoftware  extends JFrame {

public WindowNewSoftware(){
		
		JDialog dijalogSoftware;  
		//DialogExample() {  
	        JFrame f= new JFrame();  
	        dijalogSoftware = new JDialog(f , "Software", true); 
	        dijalogSoftware.setSize(400,600);    
	        
	        JPanel panCenter=new JPanel();
			BoxLayout boxCenter=new BoxLayout(panCenter, BoxLayout.Y_AXIS);
			panCenter.setLayout(boxCenter);
			dijalogSoftware.add(panCenter,BorderLayout.CENTER);
			
			
			Dimension dim=new Dimension(150,20); //dim za labele i to
			
			//NAZIV dodati da mogu samo slova
			JPanel panPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
	        JLabel lblName=new JLabel("Software name:");
	        lblName.setPreferredSize(dim);

	        JTextField txtName=new JTextField();
	        txtName.setPreferredSize(dim);

	        panPanel.add(lblName);
	        panPanel.add(txtName);
	       			
	        //PREZIME dodati da mogu samo slova
	        //JPanel panLastName=new JPanel(new FlowLayout(FlowLayout.LEFT));
	        JLabel lblBrushes=new JLabel("Brushes:");
	        lblBrushes.setPreferredSize(dim);

	        //naziv
	        JLabel lblBrushesName=new JLabel("Name:");
	        lblBrushesName.setPreferredSize(dim);
	        
	        JTextField txtBrushesName=new JTextField();
	        txtBrushesName.setPreferredSize(dim);
	        //namena
	        JLabel lblBrushesUse=new JLabel("Use:");
	        lblBrushesUse.setPreferredSize(dim);
	        
	        JTextField txtBrushesUse=new JTextField();
	        txtBrushesUse.setPreferredSize(dim);
	        //boja
	        JLabel lblBrushesColor=new JLabel("Color:");
	        lblBrushesColor.setPreferredSize(dim);
	        
	        JColorChooser brushColorChooser = new JColorChooser();
	        
	        panPanel.add(lblBrushes);
	        panPanel.add(Box.createRigidArea(new Dimension(500,0)));
	        panPanel.add(Box.createRigidArea(new Dimension(10,0)));
	        panPanel.add(lblBrushesName);
	        panPanel.add(txtBrushesName);
	        panPanel.add(Box.createRigidArea(new Dimension(500,0)));
	        panPanel.add(Box.createRigidArea(new Dimension(10,0)));
	        panPanel.add(lblBrushesColor);
	        panPanel.add(brushColorChooser);
	        //
	        
	        panCenter.add(panPanel);
	        
	        //panCenter.add(Box.createVerticalStrut(25));  
	        
	        
	       // add(panCenter,);
	        
	        JPanel panBottom=new JPanel();
			BoxLayout box=new BoxLayout(panBottom, BoxLayout.X_AXIS); //sredi posle u 1 liniju sve
			panBottom.setLayout(box);
			dijalogSoftware.add(panBottom,BorderLayout.SOUTH);
			
			JButton btnOk=new JButton("Ok");
			btnOk.setPreferredSize(new Dimension(75,25));
			
			JButton btnCancel=new JButton("Cancel");
			btnCancel.setPreferredSize(new Dimension(75,25));
			panBottom.add(Box.createGlue());
			panBottom.add(btnOk);
			panBottom.add(Box.createHorizontalStrut(10));
			panBottom.add(btnCancel);
					
			panBottom.add(Box.createRigidArea(new Dimension(30,50))); //mozda jos cackati velicine
			
	        
			
			
			
			
	        //dijalogEmployee.setLayout( new FlowLayout() );  
//	        JButton b = new JButton ("OK"); 
//	        panCenter.add(b);
//	        b.addActionListener ( new ActionListener()  
//	        {  
//	            public void actionPerformed( ActionEvent e )  
//	            {  
//	                DialogExample.d.setVisible(false);  
//	            }  
//	        });  
//	        dijalogEmployee.add( new JLabel ("Click button to continue."));  
//	        dijalogEmployee.add(b);   
	         
	    //}  
//	    public static void main(String args[])  
//	    {  
//	        new DialogExample();  
//	    }  
		dijalogSoftware.setResizable(false);
		dijalogSoftware.setVisible(true); 
		pack();
		
	}
	
}
