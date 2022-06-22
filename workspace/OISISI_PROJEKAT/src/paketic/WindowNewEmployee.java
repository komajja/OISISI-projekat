package paketic;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import baza.BazaEmployees;
import baza.BazaSoftware;
import listeneri.MyKeyListener1;
import listeneri.MyKeyListener2;
import model.Adress;
import model.Employee;
import model.Software;

public class WindowNewEmployee extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 598633886139384545L;
	
	private char tip;
	private JTextField txtName;
	private JTextField txtLastName;
	private JTextField txtJMBG;
	private JTextField txtDay;
	private JTextField txtMonth;
	private JTextField txtYear;
	private JTextField txtEmail;
	private JTextField txtAdressStreet;
	private JTextField txtAdressNum;
	private JTextField txtAdressCity;
	JList<String> listaSoftvera;
	JComboBox<String> CBradnoMesto;
	private String trenutniJMBG;
	
	//BOJE za GUI
		Color ColBraon=new Color(59,48,28);
		Color ColCrvena=new Color(207,68,39);
		Color ColKrem=new Color(235,226,195);
		Color ColBela=new Color(251,248,241);
		Color ColNaran=new Color(230,160,36);
		
		//
	
	public WindowNewEmployee(char t) {
		
		JDialog dijalogEmployee;
		tip = t;
		trenutniJMBG = "";
		ImageIcon icon=new ImageIcon("image/warning.png");
		//DialogExample() {  
	        JFrame f= new JFrame();  
	        dijalogEmployee = new JDialog(f , "Employee", true); 
	        dijalogEmployee.setSize(400,600);    
	        
	        JPanel panCenter=new JPanel();
			BoxLayout boxCenter=new BoxLayout(panCenter, BoxLayout.Y_AXIS);
			panCenter.setLayout(boxCenter);
			dijalogEmployee.add(panCenter,BorderLayout.CENTER);
			
			Dimension dim=new Dimension(150,20); //dim za labele
			
			//IME dodati da mogu samo slova
			JPanel panPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
	        JLabel lblName=new JLabel("Name:");
	        lblName.setPreferredSize(dim);
	        
			panPanel.setBackground(ColBela);

	        txtName=new JTextField();
	        txtName.setPreferredSize(dim);
	        KeyListener keyListener2=new MyKeyListener2();
	        txtName.addKeyListener(keyListener2);

	        panPanel.add(lblName);
	        panPanel.add(txtName);
	       			
	        //PREZIME dodati da mogu samo slova
	     
	        JLabel lblLastName=new JLabel("Last name:");
	        lblLastName.setPreferredSize(dim);

	        txtLastName=new JTextField();
	        txtLastName.setPreferredSize(dim);
	        KeyListener keyListener3=new MyKeyListener2();
	        txtLastName.addKeyListener(keyListener3);

	        panPanel.add(lblLastName);
	        panPanel.add(txtLastName);
	        
	        //JMBG dodati da mogu samo brojevi, odredjen br cifara i da je unique
	        JLabel lblJMBG=new JLabel("JMBG:");
	        lblJMBG.setPreferredSize(dim);

	        txtJMBG=new JTextField();
	        txtJMBG.setPreferredSize(dim);
	        KeyListener keyListener1=new MyKeyListener1();
	        txtJMBG.addKeyListener(keyListener1);

	        panPanel.add(lblJMBG);
	        panPanel.add(txtJMBG);
	        
	        //Datum rodjenja  isto da mogu samo brojevi
	        JLabel lblBirth=new JLabel("Date of birth (dd/mm/yyyy):");
	        lblBirth.setPreferredSize(dim);

	        txtDay=new JTextField();
	        txtDay.setPreferredSize(new Dimension(25,20));
	        txtDay.addKeyListener(new KeyListener(){ 
	        	 @Override
	        	 public void keyPressed(KeyEvent arg0) { 
	        		 
	        	 }
	        	 @Override
	        	 public void keyReleased(KeyEvent arg0) {
	        			if (arg0.isActionKey() || arg0.getKeyCode() == KeyEvent.VK_ENTER
	        					|| arg0.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
	        				return;
	        			}
	        		 	JTextField txt = (JTextField) arg0.getComponent();
	        		 	String str=txt.getText();
	        		 	int number;
	        		 	try{
	        	            number = Integer.parseInt(str);
	        	        }
	        	        catch (NumberFormatException ex){
	        	            number=0;
	        	        }
	        			if(number>31 || number<1) {
	        			// invalidan dan
	        			JOptionPane.showMessageDialog(null, "Day must be a number between 1 and 31!");
	        			txt.setText(txt.getText().substring(0, txt.getText().length() - 1));
	        			}
	        			str = txt.getText();
	        			System.out.println(str);
	        	 }
	        	@Override
	        	public void keyTyped(KeyEvent arg0) {

	        	}
	         });

	        txtMonth=new JTextField();
	        txtMonth.setPreferredSize(new Dimension(25,20));
	        txtMonth.addKeyListener(new KeyListener(){ 
	        	 @Override
	        	 public void keyPressed(KeyEvent arg0) { 
	        		 
	        	 }
	        	 @Override
	        	 public void keyReleased(KeyEvent arg0) {
	        			if (arg0.isActionKey() || arg0.getKeyCode() == KeyEvent.VK_ENTER
	        					|| arg0.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
	        				return;
	        			}
	        		 	JTextField txt = (JTextField) arg0.getComponent();
	        		 	String str=txt.getText();
	        		 	int number;
	        		 	try{
	        	            number = Integer.parseInt(str);
	        	        }
	        	        catch (NumberFormatException ex){
	        	            number=0;
	        	        }
	        			if(number>12 || number<1) {
	        			// invalidan dan
	        			JOptionPane.showMessageDialog(null, "Month must be a number between 1 and 12!");
	        			txt.setText(txt.getText().substring(0, txt.getText().length() - 1));
	        			}
	        			str = txt.getText();
	        			System.out.println(str);
	        	 }
	        	@Override
	        	public void keyTyped(KeyEvent arg0) {

	        	}
	         });
	        
	        txtYear=new JTextField();
	        txtYear.setPreferredSize(new Dimension(40,20));
	        txtYear.addKeyListener(new KeyListener(){ 
	        	 @Override
	        	 public void keyPressed(KeyEvent arg0) { 
	        		 if (arg0.isActionKey() || arg0.getKeyCode() == KeyEvent.VK_ENTER
	        					|| arg0.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
	        				return;
	        			}
	        		 	JTextField txt = (JTextField) arg0.getComponent();
	        		 	if (txt.getText().length() == 4) {
	        				// vec je uneto 4 karaktara
	        				JOptionPane.showMessageDialog(null, "You can only enter 4 characters!");
	        				txt.setText(txt.getText().substring(0, 4));
	        			}
	        	 }
	        	 
	        	 @Override
	        	 public void keyReleased(KeyEvent arg0) {
	        		// ako je action key, ne vrsi se provera
	        			if (arg0.isActionKey() || arg0.getKeyCode() == KeyEvent.VK_ENTER
	        					|| arg0.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
	        				return;
	        			}
	        			char c = arg0.getKeyChar();
	        			if (c != '0' && c != '1' && c != '2' && c != '3' && c != '4' && c != '5' && c != '6' && c != '7' && c != '8'
	        					&& c != '9') {
	        				JOptionPane.showMessageDialog(null, "You can only enter numbers!");
	        				JTextField txt = (JTextField) arg0.getComponent();
	        				txt.setText(txt.getText().substring(0, txt.getText().length() - 1));
	        			}
	        			JTextField txt = (JTextField) arg0.getComponent();
	        			String str = txt.getText();
	        			System.out.println(str);
	        	 }
	        	@Override
	        	public void keyTyped(KeyEvent arg0) {

	        	}
	         });

	        panPanel.add(lblBirth);
	        panPanel.add(txtDay);
	        panPanel.add(txtMonth);
	        panPanel.add(txtYear);
	        
	        //EMAIL
	        JLabel lblEmail=new JLabel("Email:");
	        lblEmail.setPreferredSize(dim);

	        txtEmail=new JTextField();
	        txtEmail.setPreferredSize(dim);
	        txtEmail.addKeyListener(new KeyListener(){ 
	        	 @Override
	        	 public void keyPressed(KeyEvent arg0) { 
	        		 
	        	 }
	        	 @Override
	        	 public void keyReleased(KeyEvent arg0) {
	        		JTextField txt = (JTextField) arg0.getComponent();
	        		String str = txt.getText();
	        		System.out.println(str);
	        	 }
	        	@Override
	        	public void keyTyped(KeyEvent arg0) {

	        	}
	         });

	        panPanel.add(lblEmail);
	        panPanel.add(txtEmail);
	        
	        //Adresa
	        JLabel lblAdress=new JLabel("Adress:");
	        lblAdress.setPreferredSize(dim);
	        
	        //ulica
	        JLabel lblAdressStreet=new JLabel("Street:");
	        lblAdressStreet.setPreferredSize(dim);
	        
	        txtAdressStreet=new JTextField();
	        txtAdressStreet.setPreferredSize(dim);
	        KeyListener keyListener4=new MyKeyListener2();
	        txtAdressStreet.addKeyListener(keyListener4);
	        
	        //broj
	        JLabel lblAdressNum=new JLabel("Number:");
	        lblAdressNum.setPreferredSize(dim);
	        
	        txtAdressNum=new JTextField();
	        txtAdressNum.setPreferredSize(dim);
	        txtAdressNum.addKeyListener(new KeyListener(){ 
	        	 @Override
	        	 public void keyPressed(KeyEvent arg0) { 
	        		 
	        	 }
	        	 @Override
	        	 public void keyReleased(KeyEvent arg0) {
	        		// ako je action key, ne vrsi se provera
	        			if (arg0.isActionKey() || arg0.getKeyCode() == KeyEvent.VK_ENTER
	        					|| arg0.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
	        				return;
	        			}
	        			char c = arg0.getKeyChar();
	        			if (c != '0' && c != '1' && c != '2' && c != '3' && c != '4' && c != '5' && c != '6' && c != '7' && c != '8'
	        					&& c != '9' && !Character.isAlphabetic(c)) {
	        			JOptionPane.showMessageDialog(null, "You can only enter letters and numbers!");
	        			JTextField txt = (JTextField) arg0.getComponent();
	        			txt.setText(txt.getText().substring(0, txt.getText().length() - 1));
	        			}
	        			JTextField txt = (JTextField) arg0.getComponent();
	        			String str = txt.getText();
	        	 }
	        	@Override
	        	public void keyTyped(KeyEvent arg0) {

	        	}
	         });
	        
	        
	        //grad
	        JLabel lblAdressCity=new JLabel("City:");
	        lblAdressCity.setPreferredSize(dim);
	        
	        txtAdressCity=new JTextField();
	        txtAdressCity.setPreferredSize(dim);
	        KeyListener keyListener5=new MyKeyListener2();
	        txtAdressCity.addKeyListener(keyListener5);

	        panPanel.add(lblAdress);
	        panPanel.add(Box.createRigidArea(new Dimension(500,0)));
	        panPanel.add(Box.createRigidArea(new Dimension(10,0)));
	        panPanel.add(lblAdressStreet);
	        panPanel.add(txtAdressStreet);
	        panPanel.add(Box.createRigidArea(new Dimension(500,0)));
	        panPanel.add(Box.createRigidArea(new Dimension(10,0)));
	        panPanel.add(lblAdressNum);
	        panPanel.add(txtAdressNum);
	        panPanel.add(Box.createRigidArea(new Dimension(50,0)));
	        panPanel.add(Box.createRigidArea(new Dimension(10,0)));
	        panPanel.add(lblAdressCity);
	        panPanel.add(txtAdressCity);
	        panPanel.add(Box.createRigidArea(new Dimension(50,0)));
	        
	        //SOFTVERI dropdown menu
	        JLabel lblSoftware=new JLabel ("Choose a software:");
	        lblSoftware.setPreferredSize(dim);
	        
	        DefaultListModel<String> model = new DefaultListModel<>();
	        for (int i = 0; i < BazaSoftware.getInstance().getSoftware().size(); i++) {
	        	model.addElement(BazaSoftware.getInstance().getSoftware().get(i).getName());
	        }

	        listaSoftvera = new JList<String>(model);
	        listaSoftvera.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
	        listaSoftvera.setFixedCellHeight(15);
	        listaSoftvera.setFixedCellWidth(200);
	        listaSoftvera.setVisibleRowCount(4);
	        JScrollPane listScroll = new JScrollPane(listaSoftvera);
	        listaSoftvera.setBackground(ColBela);
	        
	        panPanel.add(lblSoftware);
	        panPanel.add(listScroll);
	        
	        //RADNO MESTO dropdown
	        JLabel lblJobs=new JLabel ("Choose a job:");
	        lblJobs.setPreferredSize(dim);
	        
	        String[] poslovi = { "Rigger","Animator", "Designer", "3D Generalist", "Menager", "Illustrator", "Modeler", "Texture Artist"};
	        CBradnoMesto = new JComboBox<String>(poslovi);
	        CBradnoMesto.setVisible(true);
	        CBradnoMesto.setBackground(ColBela);
			
			panPanel.add(lblJobs);
	        panPanel.add(CBradnoMesto);
	        panCenter.add(panPanel);
	        
	        
	        int rowSelectedIndex = MyFrame.getTableEmployees().getSelectedRow();
	        if (tip == 'i' && rowSelectedIndex >= 0) {
	        	int a = MyFrame.getTableEmployees().convertRowIndexToModel(rowSelectedIndex);
				Employee selectedEmployee = BazaEmployees.getInstance().getRow(a);
				
				txtName.setText(selectedEmployee.getIme());
				txtLastName.setText(selectedEmployee.getPrezime());
				txtJMBG.setText(selectedEmployee.getJmbg());
				txtDay.setText(selectedEmployee.getDatumRodjenja().get(0));
				txtMonth.setText(selectedEmployee.getDatumRodjenja().get(1));
				txtYear.setText(selectedEmployee.getDatumRodjenja().get(2));
				txtEmail.setText(selectedEmployee.getEmail());
				txtAdressStreet.setText(selectedEmployee.getAdresa().getUlica());
				txtAdressNum.setText(selectedEmployee.getAdresa().getBroj());
				txtAdressCity.setText(selectedEmployee.getAdresa().getGrad());
				listaSoftvera.setSelectedIndices(findIndicesInList(BazaSoftware.getInstance().getSoftware(),selectedEmployee.getSoftver()));
				CBradnoMesto.setSelectedItem(selectedEmployee.getRadnoMesto());
				trenutniJMBG = selectedEmployee.getJmbg();
	        }
	        
	        JPanel panBottom=new JPanel();
			BoxLayout box=new BoxLayout(panBottom, BoxLayout.X_AXIS); //sredi posle u 1 liniju sve
			panBottom.setLayout(box);
			dijalogEmployee.add(panBottom,BorderLayout.SOUTH);
			panBottom.setBackground(ColBela);
			
			JButton btnOk=new JButton("Ok");
			btnOk.setPreferredSize(new Dimension(75,25));
			btnOk.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (proveraJMBG(tip)) {
						String ime = txtName.getText().trim();
						String prezime = txtLastName.getText().trim();
						String jmbg = txtJMBG.getText().trim();
						List<String> datumRodjenja = new ArrayList<String>();
						datumRodjenja.add(txtDay.getText().trim());
						datumRodjenja.add(txtMonth.getText().trim());
						datumRodjenja.add(txtYear.getText().trim());
						String email = txtEmail.getText().trim();
						Adress adresaStanovanja = new Adress(txtAdressStreet.getText().trim(), txtAdressNum.getText().trim(), txtAdressCity.getText().trim());
						List<Software> softver = new ArrayList<Software>();
						int[] indeksi = listaSoftvera.getSelectedIndices();
						for (int i = 0; i < indeksi.length; i++) {
							softver.add(BazaSoftware.getInstance().getSoftware().get(indeksi[i]));
				        }
						String radnoMesto =(String) CBradnoMesto.getSelectedItem();
						
						if (tip == 'u') {
							Employee nov = new Employee(ime, prezime, jmbg, datumRodjenja, email,
									adresaStanovanja, softver, radnoMesto);
							BazaEmployees.getInstance().addEmployee(nov);
						}
						
						if (tip == 'i') {

							BazaEmployees.getInstance().editEmployee(ime, prezime, jmbg, datumRodjenja,
									email, adresaStanovanja, softver, radnoMesto,trenutniJMBG);
						}

						MyFrame.getInstance().updateDisplay();
						dijalogEmployee.dispose();
				    }
					else {
						int input = JOptionPane.showConfirmDialog(null,
							    "JMBG must be unique!", "CONFIRMATION", 
							    JOptionPane.PLAIN_MESSAGE, JOptionPane.INFORMATION_MESSAGE, icon);
						}
				}
			});
			
			JButton btnCancel=new JButton("Cancel");
			btnCancel.setPreferredSize(new Dimension(75,25));
			btnCancel.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					ImageIcon icon=new ImageIcon("image/warning.png");
					
					int input = JOptionPane.showConfirmDialog(null,
								    "Are you sure you want to proceed?", "CONFIRMATION", 
								    JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, icon);
					if (input == 0) {
						dijalogEmployee.dispose();
					}
				}
			});
			
			panBottom.add(Box.createGlue());
			panBottom.add(btnOk);
			panBottom.add(Box.createHorizontalStrut(10));
			panBottom.add(btnCancel);
					
			panBottom.add(Box.createRigidArea(new Dimension(30,50))); //mozda jos cackati velicine
			
	     			
		dijalogEmployee.setResizable(false);
		dijalogEmployee.setVisible(true); 
		pack();
		
	}

	private boolean proveraJMBG(char tipA) {
		if (tipA == 'u' && existsByJMBG(txtJMBG.getText())) {
			return false;
			}
		
		if (tipA == 'i' && !trenutniJMBG.equals(txtJMBG.getText())) 
			if (existsByJMBG(txtJMBG.getText())) {
				return false;
				}
		return true;
	}

	private boolean existsByJMBG(String jmbg) {
		for (Employee employee : BazaEmployees.getInstance().getEmployees()) {
			if (employee.getJmbg().equals(jmbg))
				return true;
		}
		return false;
	}
	
	private int[] findIndicesInList(List<Software> outer, List<Software> inner){
		int[] indices = new int[inner.size()];
			for(int i = 0; i < outer.size(); i++) {
				for (int j = 0; j < inner.size(); j++) {
					if (inner.get(j).equals(outer.get(i))) {
						indices[j]=i;
		    	}
			}
		}
		return indices;
	}

}
