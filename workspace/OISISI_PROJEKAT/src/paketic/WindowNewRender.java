package paketic;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.channels.SelectableChannel;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import baza.BazaCetkica;
import baza.BazaRenderi;
import baza.BazaSoftware;
import model.Brush;
import model.Render;
import model.Software;

public class WindowNewRender extends JFrame {
	
	//BOJE za GUI
	Color ColBraon=new Color(59,48,28);
	Color ColCrvena=new Color(207,68,39);
	Color ColKrem=new Color(235,226,195);
	Color ColBela=new Color(251,248,241);
	Color ColNaran=new Color(230,160,36);
	
	//
	
	private String trenutniNaziv;
	private char tip;

	JTextField txtRenderName;
	JList<String> listMaterijal;
	JList<String> listKamera;
	JList<String> listSvetlo;
	JList<String> listObj;
	
public WindowNewRender(char t){
	JDialog dijalogRender;  
	tip = t;
	trenutniNaziv = "";
	ImageIcon icon=new ImageIcon("image/warning.png");
    JFrame f= new JFrame();  
    dijalogRender = new JDialog(f , "Render", true); 
    dijalogRender.setSize(380,420);
    
    JPanel panCenter=new JPanel();
	BoxLayout boxCenter=new BoxLayout(panCenter, BoxLayout.Y_AXIS);
	panCenter.setLayout(boxCenter);
	dijalogRender.add(panCenter,BorderLayout.CENTER);
	
	Dimension dim=new Dimension(150,20); //dim za labele 
	
	JPanel panPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
	panPanel.setBackground(ColBela);
	
	JLabel lblRenderName=new JLabel("Name:");
    lblRenderName.setPreferredSize(dim);
    
    txtRenderName=new JTextField();
    txtRenderName.setPreferredSize(dim);
    
    //materijal
    JLabel lblRenderMaterial=new JLabel("Material:");
    lblRenderMaterial.setPreferredSize(dim);
    
    String[] materijal= {"Water","Wood","Stone","Fabric","Dirt", "Plastic", "Metal", "Sand"};
    listMaterijal = new JList<>(materijal);
    listMaterijal.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
    listMaterijal.setFixedCellHeight(15);
    listMaterijal.setFixedCellWidth(150);
    listMaterijal.setVisibleRowCount(4);
    JScrollPane listScrollM = new JScrollPane(listMaterijal);
    listMaterijal.setBackground(ColBela);
    
    //kamere
    JLabel lblRenderCamera=new JLabel("Camera:");
    lblRenderCamera.setPreferredSize(dim);
    
    String[] kamera= {"Perspective","Ortographic"};
    listKamera = new JList<>(kamera);
    listKamera.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
    listKamera.setFixedCellHeight(15);
    listKamera.setFixedCellWidth(150);
    listKamera.setVisibleRowCount(4);
    JScrollPane listScrollK = new JScrollPane(listKamera);
    listKamera.setBackground(ColBela);
    
    //svetlo
    JLabel lblRenderLight=new JLabel("Light:");
    lblRenderLight.setPreferredSize(dim);
    
    String[] svetlo= {"Dome","Sun","Plane","Sphere","HDRI"};
    listSvetlo = new JList<>(svetlo);
    listSvetlo.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
    listSvetlo.setFixedCellHeight(15);
    listSvetlo.setFixedCellWidth(150);
    listSvetlo.setVisibleRowCount(4);
    JScrollPane listScrollS = new JScrollPane(listSvetlo);
    listSvetlo.setBackground(ColBela);
    
    //objekti
    JLabel lblRenderObjects=new JLabel("Objects:");
    lblRenderObjects.setPreferredSize(dim);
    
    String[] objekti= {"Toy","Statue","House","Human", "Car"};
    listObj = new JList<>(objekti);
    listObj.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
    listObj.setFixedCellHeight(15);
    listObj.setFixedCellWidth(150);
    listObj.setVisibleRowCount(4);
    JScrollPane listScrollR = new JScrollPane(listObj);
    listObj.setBackground(ColBela);
	
    panPanel.add(lblRenderName);
    panPanel.add(txtRenderName);
    panPanel.add(Box.createRigidArea(new Dimension(700,0)));
    panPanel.add(Box.createRigidArea(new Dimension(10,0)));
    panPanel.add(lblRenderMaterial);
    panPanel.add(listScrollM);
    panPanel.add(Box.createRigidArea(new Dimension(700,0)));
    panPanel.add(Box.createRigidArea(new Dimension(10,0)));
    panPanel.add(lblRenderCamera);
    panPanel.add(listScrollK);
    panPanel.add(Box.createRigidArea(new Dimension(700,0)));
    panPanel.add(Box.createRigidArea(new Dimension(10,0)));
    panPanel.add(lblRenderLight);
    panPanel.add(listScrollS);
    panPanel.add(Box.createRigidArea(new Dimension(700,0)));
    panPanel.add(Box.createRigidArea(new Dimension(10,0)));
    panPanel.add(lblRenderObjects);
    panPanel.add(listScrollR);
    panCenter.add(panPanel);
    
    JPanel panBottom=new JPanel();
	BoxLayout box=new BoxLayout(panBottom, BoxLayout.X_AXIS);
	panBottom.setLayout(box);
	panBottom.setBackground(ColBela);
	dijalogRender.add(panBottom,BorderLayout.SOUTH);
	
	JButton btnOk=new JButton("Ok");
	btnOk.setPreferredSize(new Dimension(75,25));
	
	JButton btnCancel=new JButton("Cancel");
	btnCancel.setPreferredSize(new Dimension(75,25));
	
	panBottom.add(Box.createGlue());
	panBottom.add(btnOk);
	panBottom.add(Box.createHorizontalStrut(10));
	panBottom.add(btnCancel);
	panBottom.add(Box.createRigidArea(new Dimension(30,50)));
	
	int rowSelectedIndex = WindowNewSoftware.getTableRenders().getSelectedRow();
    if (tip == 'i' && rowSelectedIndex >= 0) {
    	int a = WindowNewSoftware.getTableRenders().convertRowIndexToModel(rowSelectedIndex);
		Render selectedRender = BazaRenderi.getInstance().getRow(a);
		
		txtRenderName.setText(selectedRender.getName());
		listMaterijal.setSelectedIndices(findIndicesInList(materijal, selectedRender.getMaterials()));
		listKamera.setSelectedIndices(findIndicesInList(kamera, selectedRender.getCameras()));
		listSvetlo.setSelectedIndices(findIndicesInList(svetlo, selectedRender.getLight()));
		listObj.setSelectedIndices(findIndicesInList(objekti, selectedRender.getObjects()));
		trenutniNaziv = selectedRender.getName();
    }
    
    btnOk.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			if (proveraNaziv(tip)) {
				String ime = txtRenderName.getText().trim();
				List<String> material = new ArrayList<String>();
				int[] indeksiM = listMaterijal.getSelectedIndices();
				for (int i = 0; i < indeksiM.length; i++) {
					material.add(materijal[i]);
		        }
				List<String> camera = new ArrayList<String>();
				int[] indeksiC = listKamera.getSelectedIndices();
				for (int i = 0; i < indeksiC.length; i++) {
					camera.add(kamera[i]);
		        }
				List<String> svetla = new ArrayList<String>();
				int[] indeksiS = listSvetlo.getSelectedIndices();
				for (int i = 0; i < indeksiS.length; i++) {
					svetla.add(svetlo[i]);
		        }
				List<String> obj = new ArrayList<String>();
				int[] indeksiO = listObj.getSelectedIndices();
				for (int i = 0; i < indeksiO.length; i++) {
					obj.add(objekti[i]);
		        }
				
				if (tip == 'u') {
					Render nov = new Render(ime, material, camera, svetla, obj);
					BazaRenderi.getInstance().addRender(nov);
				}
				
				if (tip == 'i') {
					
					BazaRenderi.getInstance().editRender(trenutniNaziv, ime, material, camera, svetla, obj);
				}
				
				WindowNewSoftware.getInstance().updateDisplay();
				dijalogRender.dispose();
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
				dijalogRender.dispose();
			}
		}
	});
	
	dijalogRender.setResizable(false);
	dijalogRender.setVisible(true); 
	pack();
}

private boolean proveraNaziv(char tipA) {
	if (tipA == 'u' && existsByNaziv(txtRenderName.getText())) {
		return false;
		}
	
	if (tipA == 'i' && !trenutniNaziv.equals(txtRenderName.getText())) 
		if (existsByNaziv(txtRenderName.getText())) {
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

private int[] findIndicesInList(String[] outer, List<String> inner){
	int[] indices = new int[inner.size()];
		for(int i = 0; i < outer.length; i++) {
			for (int j = 0; j < inner.size(); j++) {
				if (inner.get(j).equals(outer[i])) {
					indices[j]=i;
	    	}
		}
	}
	return indices;
}

}
