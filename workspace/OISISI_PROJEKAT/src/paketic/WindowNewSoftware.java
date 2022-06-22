package paketic;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class WindowNewSoftware  extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1940714128261676067L;
	
			//BOJE za GUI
			Color ColBraon=new Color(59,48,28);
			Color ColCrvena=new Color(207,68,39);
			Color ColKrem=new Color(235,226,195);
			Color ColBela=new Color(251,248,241);
			Color ColNaran=new Color(230,160,36);
			
			//
public WindowNewSoftware(){
		
		JDialog dijalogSoftware;  
	        JFrame f= new JFrame();  
	        dijalogSoftware = new JDialog(f , "Software", true); 
	        dijalogSoftware.setSize(637,760);    
	        
	        JPanel panCenter=new JPanel();
			BoxLayout boxCenter=new BoxLayout(panCenter, BoxLayout.Y_AXIS);
			panCenter.setLayout(boxCenter);
			dijalogSoftware.add(panCenter,BorderLayout.CENTER);
			
			
			Dimension dim=new Dimension(150,20); //dim za labele 
			
			//NAZIV dodati da mogu samo slova I JEDINSTVENOST!!! 	
			JPanel panPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
	        JLabel lblName=new JLabel("Software name:");
	        lblName.setPreferredSize(dim);
	        
	        panPanel.setBackground(ColBela);

	        JTextField txtName=new JTextField();
	        txtName.setPreferredSize(dim);
	       	
	        
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
	        
	        String[] namena= {"Move","Curve","Polish","Paint",};
	        JComboBox<String> cbNamena=new JComboBox<String>(namena);
	        cbNamena.setVisible(true);
	        cbNamena.setBackground(ColBela);
	        
	        //boja
	        JLabel lblBrushesColor=new JLabel("Color:");
	        lblBrushesColor.setPreferredSize(dim);
	        
	        JColorChooser brushColorChooser = new JColorChooser();
	        brushColorChooser.setBackground(ColBela);
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
	        
	        String[] materijal= {"Water","Wood","Stone","Fabric"};
	        JComboBox<String> cbMaterijal = new JComboBox<String>(materijal);

	        cbMaterijal.setVisible(true);
	        cbMaterijal.setBackground(ColBela);
	        
	        //kamere
	        JLabel lblRenderCamera=new JLabel("Camera:");
	        lblRenderCamera.setPreferredSize(dim);
	        
	        String[] kamera= {"Perspective","Orto"};
	        JComboBox<String> cbKamera = new JComboBox<String>(kamera);

	        cbKamera.setVisible(true);
	        cbKamera.setBackground(ColBela);
	        
	        //svetlo
	        JLabel lblRenderLight=new JLabel("Light:");
	        lblRenderLight.setPreferredSize(dim);
	        
	        String[] svetlo= {"SVETLO 1","SVETLO 2","SVETLO 3","SVETLO 4"};
	        JComboBox<String> cbSvetlo = new JComboBox<String>(svetlo);

	        cbSvetlo.setVisible(true);
	        cbSvetlo.setBackground(ColBela);
	        
	        //objekti
	        JLabel lblRenderObjects=new JLabel("Objects:");
	        lblRenderObjects.setPreferredSize(dim);
	        
	        String[] render= {"RENDER 1","RENDER 2","RENDER 3","RENDER 4"};
	        JComboBox<String> cbRender = new JComboBox<String>(render);

	        cbRender.setVisible(true);
	        cbRender.setBackground(ColBela);
	        
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
	        
	        
	        panCenter.add(panPanel);
	     
	        
	        JPanel panBottom=new JPanel();
			BoxLayout box=new BoxLayout(panBottom, BoxLayout.X_AXIS); //sredi posle u 1 liniju sve
			panBottom.setLayout(box);
			panBottom.setBackground(ColBela);
			dijalogSoftware.add(panBottom,BorderLayout.SOUTH);
			
			JButton btnOk=new JButton("Ok");
			btnOk.setPreferredSize(new Dimension(75,25));
			
			JButton btnCancel=new JButton("Cancel");
			btnCancel.setPreferredSize(new Dimension(75,25));
			panBottom.add(Box.createGlue());
			panBottom.add(btnOk);
			panBottom.add(Box.createHorizontalStrut(10));
			
			panBottom.add(btnCancel);
			btnCancel.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent arg0) {
	            	
	            	ImageIcon icon=new ImageIcon("image/warning.png");
					
	        		int input = JOptionPane.showConfirmDialog(null,
	        					    "Are you sure you want to proceed?", "CONFIRMATION", 
	        					    JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, icon);
	        		// 0=yes, 1=no
	        		System.out.println(input);
	        		if (input==0)
	            	dijalogSoftware.dispatchEvent(new WindowEvent(f, WindowEvent.WINDOW_CLOSING));
	                 }
	             });
			
			btnOk.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent arg0) {
	            	
	            	ImageIcon icon=new ImageIcon("image/warning.png");
					
	        		int input = JOptionPane.showConfirmDialog(null,
	        					    "Are you sure you want to proceed?", "CONFIRMATION", 
	        					    JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, icon);
	        		// 0=yes, 1=no
	        		System.out.println(input);
	        		if (input==0)
	                	
	            	dijalogSoftware.dispatchEvent(new WindowEvent(f, WindowEvent.WINDOW_CLOSING));
	                 }
	             });
			
			panBottom.add(Box.createRigidArea(new Dimension(30,50))); //mozda jos cackati velicine
			
	        
		dijalogSoftware.setResizable(false);
		dijalogSoftware.setVisible(true); 
		pack();
		
	}
	
}
