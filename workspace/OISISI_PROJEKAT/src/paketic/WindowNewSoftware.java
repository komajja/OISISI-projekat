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
import javax.swing.JComboBox;
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
	        dijalogSoftware.setSize(637,760);    
	        
	        JPanel panCenter=new JPanel();
			BoxLayout boxCenter=new BoxLayout(panCenter, BoxLayout.Y_AXIS);
			panCenter.setLayout(boxCenter);
			dijalogSoftware.add(panCenter,BorderLayout.CENTER);
			
			
			Dimension dim=new Dimension(150,20); //dim za labele i to
			
			//NAZIV dodati da mogu samo slova I JEDINSTVENOST!!! 	
			JPanel panPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
	        JLabel lblName=new JLabel("Software name:");
	        lblName.setPreferredSize(dim);

	        JTextField txtName=new JTextField();
	        txtName.setPreferredSize(dim);
	       	
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
	        
	        String[] namena= {"NAMENA 1","NAMENA 2","NAMENA 3","NAMENA 4",};
	        JComboBox<String> cbNamena=new JComboBox<String>(namena);
	        cbNamena.setVisible(true);
	        	        
	        //boja
	        JLabel lblBrushesColor=new JLabel("Color:");
	        lblBrushesColor.setPreferredSize(dim);
	        
	        JColorChooser brushColorChooser = new JColorChooser();
	        
	        //RENDER
	        
	        JLabel lblRender=new JLabel("Render:");
	        lblBrushesUse.setPreferredSize(dim);
	        
	        //naziv
	        JLabel lblRenderName=new JLabel("Name:");
	        lblRenderName.setPreferredSize(dim);
	        
	        JTextField txtRenderName=new JTextField();
	        txtRenderName.setPreferredSize(dim);
	        
	        //materijal
	        JLabel lblRenderMaterial=new JLabel("Material:");
	        lblRenderMaterial.setPreferredSize(dim);
	        
	        String[] materijal= {"MATERIJAL 1","MATERIJAL 2","MATERIJAL 3","MATERIJAL 4"};
	        JComboBox<String> cbMaterijal = new JComboBox<String>(materijal);

	        cbMaterijal.setVisible(true);
	        
	        //kamere
	        JLabel lblRenderCamera=new JLabel("Camera:");
	        lblRenderCamera.setPreferredSize(dim);
	        
	        String[] kamera= {"Perspective","Orto"};
	        JComboBox<String> cbKamera = new JComboBox<String>(kamera);

	        cbKamera.setVisible(true);
	        
	        //svetlo
	        JLabel lblRenderLight=new JLabel("Light:");
	        lblRenderLight.setPreferredSize(dim);
	        
	        String[] svetlo= {"SVETLO 1","SVETLO 2","SVETLO 3","SVETLO 4"};
	        JComboBox<String> cbSvetlo = new JComboBox<String>(svetlo);

	        cbSvetlo.setVisible(true);
	        
	        //objekti
	        JLabel lblRenderObjects=new JLabel("Objects:");
	        lblRenderObjects.setPreferredSize(dim);
	        
	        String[] render= {"RENDER 1","RENDER 2","RENDER 3","RENDER 4"};
	        JComboBox<String> cbRender = new JComboBox<String>(render);

	        cbRender.setVisible(true);
	        
	        //dodavanje labela u panel
	        
	        panPanel.add(lblName);
	        panPanel.add(txtName);
	        panPanel.add(Box.createRigidArea(new Dimension(700,0)));
	        panPanel.add(lblBrushes);
	        panPanel.add(Box.createRigidArea(new Dimension(700,0)));
	        panPanel.add(Box.createRigidArea(new Dimension(10,0)));
	        panPanel.add(lblBrushesName);
	        panPanel.add(txtBrushesName);
	        panPanel.add(Box.createRigidArea(new Dimension(700,0)));
	        panPanel.add(Box.createRigidArea(new Dimension(10,0)));
	        panPanel.add(lblBrushesUse);
	        panPanel.add(cbNamena);
	        panPanel.add(Box.createRigidArea(new Dimension(700,0)));
	        panPanel.add(Box.createRigidArea(new Dimension(10,0)));
	        panPanel.add(lblBrushesColor);
	        panPanel.add(brushColorChooser);
	        panPanel.add(Box.createRigidArea(new Dimension(700,0)));
	        panPanel.add(lblRender);
	        panPanel.add(Box.createRigidArea(new Dimension(700,0)));
	        panPanel.add(Box.createRigidArea(new Dimension(10,0)));
	        panPanel.add(lblRenderName);
	        panPanel.add(txtRenderName);
	        panPanel.add(Box.createRigidArea(new Dimension(700,0)));
	        panPanel.add(Box.createRigidArea(new Dimension(10,0)));
	        panPanel.add(lblRenderMaterial);
	        panPanel.add(cbMaterijal);
	        panPanel.add(Box.createRigidArea(new Dimension(700,0)));
	        panPanel.add(Box.createRigidArea(new Dimension(10,0)));
	        panPanel.add(lblRenderCamera);
	        panPanel.add(cbKamera);
	        panPanel.add(Box.createRigidArea(new Dimension(700,0)));
	        panPanel.add(Box.createRigidArea(new Dimension(10,0)));
	        panPanel.add(lblRenderLight);
	        panPanel.add(cbSvetlo);
	        panPanel.add(Box.createRigidArea(new Dimension(700,0)));
	        panPanel.add(Box.createRigidArea(new Dimension(10,0)));
	        panPanel.add(lblRenderObjects);
	        panPanel.add(cbRender);
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
