package paketic;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;

import baza.BazaCetkica;
import baza.BazaEmployees;
import baza.BazaRenderi;
import baza.BazaSoftware;
import model.Adress;
import model.Brush;
import model.Employee;
import model.Render;
import model.Software;

public class WindowNewSoftware  extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1940714128261676067L;
	
	private static WindowNewSoftware instance = null;

	public static WindowNewSoftware getInstance() {
		if (instance == null) {
			instance = new WindowNewSoftware();
		}
		return instance;
	}
	
			//BOJE za GUI
			Color ColBraon=new Color(59,48,28);
			Color ColCrvena=new Color(207,68,39);
			Color ColKrem=new Color(235,226,195);
			Color ColBela=new Color(251,248,241);
			Color ColNaran=new Color(230,160,36);
			
			//
			
			private String trenutniNaziv;
			private char tip;
	
			JTextField txtName;
			private static JTable TableBrushes;
			private static JTable TableRenders;
			JList<String> listModif;
			JComboBox<String> cbFF;
			JList<String> listAT;
			
			
public WindowNewSoftware() {};

public WindowNewSoftware(char t){
		
			JDialog dijalogSoftware;  
			tip = t;
			trenutniNaziv = "";
	        JFrame f= new JFrame();  
	        ImageIcon icon=new ImageIcon("image/warning.png");
	        dijalogSoftware = new JDialog(f , "Software", true); 
	        dijalogSoftware.setSize(637,650);    
	        
	        JPanel panCenter=new JPanel();
			BoxLayout boxCenter=new BoxLayout(panCenter, BoxLayout.Y_AXIS);
			panCenter.setLayout(boxCenter);
			dijalogSoftware.add(panCenter,BorderLayout.CENTER);
			
			Dimension dim=new Dimension(150,20); //dim za labele 
			
			//NAZIV dodati da mogu samo slova I JEDINSTVENOST!!! 	
	        JLabel lblName=new JLabel("Software name:");
	        lblName.setPreferredSize(dim);
	        

	        txtName=new JTextField();
	        txtName.setPreferredSize(dim);
	       	
	        
	        JLabel lblBrushes=new JLabel("Brushes:");
	        lblBrushes.setPreferredSize(dim);

	        TableBrushes = new JTable(new AbstractTableModelCetkice()) {
	    		@Override
	            public Component prepareRenderer(TableCellRenderer renderer,
	                    int row, int col) {

	                Component c = super.prepareRenderer(renderer, row, col);
	                if (c instanceof JComponent) {
	                    JComponent jc = (JComponent)c;
	                    Color color = BazaCetkica.getInstance().getBrushes().get(row).getColor();
	                    String html = getHtml(color);
	                    jc.setToolTipText(html);
	                }   
	                return c;
	            }
	    	};
	    	
	    	TableBrushes.setBackground(ColBela);
	    	TableBrushes.setSelectionBackground(ColNaran);
	    	TableBrushes.setPreferredScrollableViewportSize(new Dimension (450, 100));
	    	TableBrushes.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
	    	
	    	JButton btnAddB=new JButton("Add");
			btnAddB.setPreferredSize(new Dimension(75,25));
			btnAddB.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					WindowNewBrush windowbrush = new WindowNewBrush('u');
				}
			});
			
			JButton btnEditB=new JButton("Edit");
			btnEditB.setPreferredSize(new Dimension(75,25));
			btnEditB.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if(WindowNewSoftware.getInstance().getTableBrushes().getSelectedRows().length == 0) {
						int input = JOptionPane.showConfirmDialog(null,
							    "Nothing is selected", "CONFIRMATION", 
							    JOptionPane.PLAIN_MESSAGE, JOptionPane.INFORMATION_MESSAGE, icon);
					}
					else if (WindowNewSoftware.getInstance().getTableBrushes().getSelectedRows().length > 1){
						int input = JOptionPane.showConfirmDialog(null,
							    "Select only one", "CONFIRMATION", 
							    JOptionPane.PLAIN_MESSAGE, JOptionPane.INFORMATION_MESSAGE, icon);
					}
					else{
						WindowNewBrush windowbrush = new WindowNewBrush('i');
					}
				}
			});
			
			//MODIFIKATORI
			
			JLabel lblModifikatori=new JLabel("Modifikatori:");
		    lblModifikatori.setPreferredSize(dim);
		    
		    String[] modifikatori= {"Extrude","Bevel","Cloth","Noise","Edit Poly"};
		    listModif = new JList<>(modifikatori);
		    listModif.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		    listModif.setFixedCellHeight(15);
		    listModif.setFixedCellWidth(150);
		    listModif.setVisibleRowCount(4);
		    JScrollPane listScrollM = new JScrollPane(listModif);
		    listModif.setBackground(ColBela);
	        
		    //FF
		    
		    JLabel lblFF=new JLabel("File Format:");
		    lblFF.setPreferredSize(dim);
	        
	        String[] ff= {".max",".ps",".obj",".fbx",};
	        cbFF=new JComboBox<String>(ff);
	        cbFF.setVisible(true);
	        cbFF.setBackground(ColBela);
		    
	        //ANIM TOOLS
	        
	        JLabel lblAnimT=new JLabel("Animation Tools:");
	        lblAnimT.setPreferredSize(dim);
		    
		    String[] animtools= {"Bone tool","Curve graph","Constraints","Timeline","MassFX"};
		    listAT = new JList<>(animtools);
		    listAT.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		    listAT.setFixedCellHeight(15);
		    listAT.setFixedCellWidth(150);
		    listAT.setVisibleRowCount(4);
		    JScrollPane listScrollAT = new JScrollPane(listAT);
		    listAT.setBackground(ColBela);
	        
	        //RENDER
	        
	        JLabel lblRender=new JLabel("Render:");
	        lblRender.setPreferredSize(dim);
	        
	        TableRenders = new JTable(new AbstractTableModelRenderi());
	    	
	    	TableRenders.setBackground(ColBela);
	    	TableRenders.setSelectionBackground(ColNaran);
	    	TableRenders.setPreferredScrollableViewportSize(new Dimension (450, 100));
	    	TableRenders.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
	    	
	    	JButton btnAddR=new JButton("Add");
			btnAddR.setPreferredSize(new Dimension(75,25));
			btnAddR.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					WindowNewRender windowbrush = new WindowNewRender('u');
				}
			});
			
			JButton btnEditR=new JButton("Edit");
			btnEditR.setPreferredSize(new Dimension(75,25));
			btnEditR.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if(WindowNewSoftware.getInstance().getTableRenders().getSelectedRows().length == 0) {
						int input = JOptionPane.showConfirmDialog(null,
							    "Nothing is selected", "CONFIRMATION", 
							    JOptionPane.PLAIN_MESSAGE, JOptionPane.INFORMATION_MESSAGE, icon);
					}
					else if (WindowNewSoftware.getInstance().getTableRenders().getSelectedRows().length > 1){
						int input = JOptionPane.showConfirmDialog(null,
							    "Select only one", "CONFIRMATION", 
							    JOptionPane.PLAIN_MESSAGE, JOptionPane.INFORMATION_MESSAGE, icon);
					}
					else{
						WindowNewRender windowrender = new WindowNewRender('i');
					}
				}
			});
	        
	        //dodavanje labela u panel
	        
			JPanel panPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
	        panPanel.setBackground(ColBela);
			panPanel.add(lblName);
			panPanel.add(txtName);
			panPanel.add(Box.createRigidArea(new Dimension(700,0)));
			panPanel.add(lblBrushes);
			panPanel.add(new JScrollPane(TableBrushes));
			panPanel.add(Box.createRigidArea(new Dimension(422,0)));
			panPanel.add(btnAddB);
			panPanel.add(Box.createHorizontalStrut(2));
			panPanel.add(btnEditB);
			panPanel.add(Box.createRigidArea(new Dimension(700,0)));
			panPanel.add(lblModifikatori);
			panPanel.add(listScrollM);
			panPanel.add(Box.createRigidArea(new Dimension(700,0)));
	        panPanel.add(lblFF);
	        panPanel.add(cbFF);
	        panPanel.add(Box.createRigidArea(new Dimension(700,0)));
	        panPanel.add(lblAnimT);
			panPanel.add(listScrollAT);
			panPanel.add(Box.createRigidArea(new Dimension(700,0)));
			panPanel.add(lblRender);
			panPanel.add(new JScrollPane(TableRenders));
			panPanel.add(Box.createRigidArea(new Dimension(422,0)));
			panPanel.add(btnAddR);
			panPanel.add(Box.createHorizontalStrut(2));
			panPanel.add(btnEditR);
	        
	        
	        panCenter.add(panPanel);
	        
	        
	        int rowSelectedIndex = MyFrame.getTableSoftware().getSelectedRow();
	        if (tip == 'i' && rowSelectedIndex >= 0) {
	        	int a = MyFrame.getTableSoftware().convertRowIndexToModel(rowSelectedIndex);
				Software selectedSoftware = BazaSoftware.getInstance().getRow(a);
				
				txtName.setText(selectedSoftware.getName());
				for(int i = 0; i < selectedSoftware.getCetkice().size(); i++) {
					TableBrushes.addRowSelectionInterval(BazaCetkica.getInstance().getBrushes().indexOf(selectedSoftware.getCetkice().get(i)),BazaCetkica.getInstance().getBrushes().indexOf(selectedSoftware.getCetkice().get(i)));
				}
				for(int i = 0; i < selectedSoftware.getRenders().size(); i++) {
					TableRenders.addRowSelectionInterval(BazaRenderi.getInstance().getRenders().indexOf(selectedSoftware.getRenders().get(i)),BazaRenderi.getInstance().getRenders().indexOf(selectedSoftware.getRenders().get(i)));
				}
				listModif.setSelectedIndices(findIndicesInList(modifikatori, selectedSoftware.getModif()));
				cbFF.setSelectedItem(selectedSoftware.getFFormat());
				listAT.setSelectedIndices(findIndicesInList(animtools, selectedSoftware.getAlati()));
				trenutniNaziv = selectedSoftware.getName();
	        }
	     
	        
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
					if (input == 0) {
						dijalogSoftware.dispose();
					}
				}
	             });
			
			btnOk.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (proveraNaziva(tip)) {
						String ime = txtName.getText().trim();
						List<Brush> brushes = new ArrayList<Brush>();
						int[] indeksiB = TableBrushes.getSelectedRows();
						for (int i = 0; i < indeksiB.length; i++) {
							brushes.add(BazaCetkica.getInstance().getBrushes().get(indeksiB[i]));
				        }
						List<String> modif = new ArrayList<String>();
						int[] indeksiM = listModif.getSelectedIndices();
						for (int i = 0; i < indeksiM.length; i++) {
							modif.add(modifikatori[i]);
				        }
						String ff =(String) cbFF.getSelectedItem();
						List<String> animationtools = new ArrayList<String>();
						int[] indeksiAT = listAT.getSelectedIndices();
						for (int i = 0; i < indeksiAT.length; i++) {
							animationtools.add(animtools[i]);
				        }
						List<Render> renders = new ArrayList<Render>();
						int[] indeksiR = TableRenders.getSelectedRows();
						for (int i = 0; i < indeksiR.length; i++) {
							renders.add(BazaRenderi.getInstance().getRenders().get(indeksiR[i]));
						}
						if (tip == 'u') {
							Software nov = new Software(ime, brushes, modif, ff, animationtools, renders);
							BazaSoftware.getInstance().addSoftware(nov);
						}
						
						if (tip == 'i') {

							BazaSoftware.getInstance().editSoftware(trenutniNaziv, ime, brushes, modif, ff, animationtools, renders);
						}

						MyFrame.getInstance().updateDisplay();
						dijalogSoftware.dispose();
				    }
					else {
						int input = JOptionPane.showConfirmDialog(null,
							    "Name must be unique!", "CONFIRMATION", 
							    JOptionPane.PLAIN_MESSAGE, JOptionPane.INFORMATION_MESSAGE, icon);
						}
				}
			});
			
			panBottom.add(Box.createRigidArea(new Dimension(30,50))); //mozda jos cackati velicine
			
	        
		dijalogSoftware.setResizable(false);
		dijalogSoftware.setVisible(true); 
		pack();
		
	}
private boolean proveraNaziva(char tipA) {
	if (tipA == 'u' && existsByNaziv(txtName.getText())) {
		return false;
		}
	
	if (tipA == 'i' && !trenutniNaziv.equals(txtName.getText())) 
		if (existsByNaziv(txtName.getText())) {
			return false;
			}
	return true;
}

private boolean existsByNaziv(String naziv) {
	for (Software software : BazaSoftware.getInstance().getSoftware()) {
		if (software.getName().equals(naziv))
			return true;
	}
	return false;
}

public static JTable getTableBrushes() {
	return TableBrushes;
}

public static JTable getTableRenders() {
	return TableRenders;
}

public void updateDisplay() {
    AbstractTableModelCetkice model1 = (AbstractTableModelCetkice) TableBrushes.getModel();
	// azuriranje modela tabele, kao i njenog prikaza
    AbstractTableModelRenderi model2 = (AbstractTableModelRenderi) TableRenders.getModel();
	// azuriranje modela tabele, kao i njenog prikaza
	model1.fireTableDataChanged();
	model2.fireTableDataChanged();
	validate();
}

private String getHtml(Color color) {
	String boja;
  	boja = String.valueOf(color.getRed())+","+String.valueOf(color.getGreen())+","+String.valueOf(color.getBlue());
    StringBuilder sb = new StringBuilder();
    sb.append("<html><body>");
    sb.append("<div style='background-color:rgb(");
    sb.append(boja);
    sb.append("); height:100px; width:100px'></div>");
    sb.append("</body></html>");
    return sb.toString();
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
