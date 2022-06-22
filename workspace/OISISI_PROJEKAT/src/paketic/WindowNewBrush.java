package paketic;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

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

import baza.BazaCetkica;
import baza.BazaEmployees;
import baza.BazaSoftware;
import model.Adress;
import model.Brush;
import model.Employee;
import model.Software;

public class WindowNewBrush  extends JFrame {
	
			//BOJE za GUI
			Color ColBraon=new Color(59,48,28);
			Color ColCrvena=new Color(207,68,39);
			Color ColKrem=new Color(235,226,195);
			Color ColBela=new Color(251,248,241);
			Color ColNaran=new Color(230,160,36);
			
			//
			
			private String trenutniNaziv;
			private char tip;
	
			JTextField txtBrushesName;
			JComboBox<String> cbNamena;
			JColorChooser brushColorChooser;
			
public WindowNewBrush(char t){
		
			JDialog dijalogBrush;  
			tip = t;
			trenutniNaziv = "";
			ImageIcon icon=new ImageIcon("image/warning.png");
	        JFrame f= new JFrame();  
	        dijalogBrush = new JDialog(f , "Brush", true); 
	        dijalogBrush.setSize(637,500);
	        
	        JPanel panCenter=new JPanel();
			BoxLayout boxCenter=new BoxLayout(panCenter, BoxLayout.Y_AXIS);
			panCenter.setLayout(boxCenter);
			dijalogBrush.add(panCenter,BorderLayout.CENTER);
			
			Dimension dim=new Dimension(150,20); //dim za labele 
			
			JPanel panPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
			panPanel.setBackground(ColBela);
			
			JLabel lblBrushesName=new JLabel("Name:");
	        lblBrushesName.setPreferredSize(dim);
	        
	        txtBrushesName=new JTextField();
	        txtBrushesName.setPreferredSize(dim);
	        
	        //namena
	        JLabel lblBrushesUse=new JLabel("Use:");
	        lblBrushesUse.setPreferredSize(dim);
	        
	        String[] namena= {"Moves Geometry","Polishes Surface","Adds Geometry","Paints",};
	        cbNamena=new JComboBox<String>(namena);
	        cbNamena.setVisible(true);
	        cbNamena.setBackground(ColBela);
	        
	        //boja
	        JLabel lblBrushesColor=new JLabel("Color:");
	        lblBrushesColor.setPreferredSize(dim);
	        
	        brushColorChooser = new JColorChooser();
	        brushColorChooser.setBackground(ColBela);
			
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
			panCenter.add(panPanel);
			
			JPanel panBottom=new JPanel();
			BoxLayout box=new BoxLayout(panBottom, BoxLayout.X_AXIS);
			panBottom.setLayout(box);
			panBottom.setBackground(ColBela);
			dijalogBrush.add(panBottom,BorderLayout.SOUTH);
			
			JButton btnOk=new JButton("Ok");
			btnOk.setPreferredSize(new Dimension(75,25));
			
			JButton btnCancel=new JButton("Cancel");
			btnCancel.setPreferredSize(new Dimension(75,25));
			
			panBottom.add(Box.createGlue());
			panBottom.add(btnOk);
			panBottom.add(Box.createHorizontalStrut(10));
			panBottom.add(btnCancel);
			panBottom.add(Box.createRigidArea(new Dimension(30,50)));
			
	        int rowSelectedIndex = WindowNewSoftware.getTableBrushes().getSelectedRow();
	        if (tip == 'i' && rowSelectedIndex >= 0) {
	        	int a = WindowNewSoftware.getTableBrushes().convertRowIndexToModel(rowSelectedIndex);
				Brush selectedBrush = BazaCetkica.getInstance().getRow(a);
				
				txtBrushesName.setText(selectedBrush.getName());
				brushColorChooser.setColor(selectedBrush.getColor());
				cbNamena.setSelectedItem(selectedBrush.getUse());
				trenutniNaziv = selectedBrush.getName();
	        }
	        
	        btnOk.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (proveraNaziv(tip)) {
						String ime = txtBrushesName.getText().trim();
						String namena =(String) cbNamena.getSelectedItem();
						Color color = brushColorChooser.getColor();
						
						if (tip == 'u') {
							Brush nov = new Brush(ime, namena, color);
							BazaCetkica.getInstance().addBrush(nov);
						}
						
						if (tip == 'i') {
							
							BazaCetkica.getInstance().editBrush(trenutniNaziv, ime, namena, color);
						}
						
						WindowNewSoftware.getInstance().updateDisplay();
						dijalogBrush.dispose();
						}
					else {
						int input = JOptionPane.showConfirmDialog(null,
							    "Name must be unique!", "CONFIRMATION", 
							    JOptionPane.PLAIN_MESSAGE, JOptionPane.INFORMATION_MESSAGE, icon);
						}
				}
			});
	        
			btnCancel.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					ImageIcon icon=new ImageIcon("image/warning.png");
					
					int input = JOptionPane.showConfirmDialog(null,
								    "Are you sure you want to proceed?", "CONFIRMATION", 
								    JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, icon);
					if (input == 0) {
						dijalogBrush.dispose();
					}
				}
			});
			
			dijalogBrush.setResizable(false);
			dijalogBrush.setVisible(true); 
			pack();
}

private boolean proveraNaziv(char tipA) {
	if (tipA == 'u' && existsByNaziv(txtBrushesName.getText())) {
		return false;
		}
	
	if (tipA == 'i' && !trenutniNaziv.equals(txtBrushesName.getText())) 
		if (existsByNaziv(txtBrushesName.getText())) {
			return false;
			}
	return true;
}

private boolean existsByNaziv(String naziv) {
	for (Brush brush : BazaCetkica.getInstance().getBrushes()) {
		if (brush.getName().equals(naziv))
			return true;
	}
	return false;
}

}
