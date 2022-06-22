package paketic;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import listeneri.MyKeyListener1;
import listeneri.MyKeyListener2;

public class WindowNewEmployee extends JFrame {

	public WindowNewEmployee() {
		
		JDialog dijalogEmployee;  
		//DialogExample() {  
	        JFrame f= new JFrame();  
	        dijalogEmployee = new JDialog(f , "Employee", true); 
	        dijalogEmployee.setSize(400,600);    
	        
	        JPanel panCenter=new JPanel();
			BoxLayout boxCenter=new BoxLayout(panCenter, BoxLayout.Y_AXIS);
			panCenter.setLayout(boxCenter);
			dijalogEmployee.add(panCenter,BorderLayout.CENTER);
			
			
			Dimension dim=new Dimension(150,20); //dim za labele i to
			
			//IME dodati da mogu samo slova
			JPanel panPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
	        JLabel lblName=new JLabel("Name:");
	        lblName.setPreferredSize(dim);

	        JTextField txtName=new JTextField();
	        txtName.setPreferredSize(dim);
	        KeyListener keyListener2=new MyKeyListener2();
	        txtName.addKeyListener(keyListener2);

	        panPanel.add(lblName);
	        panPanel.add(txtName);
	       			
	        //PREZIME dodati da mogu samo slova
	        //JPanel panLastName=new JPanel(new FlowLayout(FlowLayout.LEFT));
	        JLabel lblLastName=new JLabel("Last name:");
	        lblLastName.setPreferredSize(dim);

	        JTextField txtLastName=new JTextField();
	        txtLastName.setPreferredSize(dim);
	        KeyListener keyListener3=new MyKeyListener2();
	        txtLastName.addKeyListener(keyListener3);

	        panPanel.add(lblLastName);
	        panPanel.add(txtLastName);
	        
	        //JMBG dodati da mogu samo brojevi, odredjen br cifara i da je unique
	        JLabel lblJMBG=new JLabel("JMBG:");
	        lblJMBG.setPreferredSize(dim);

	        JTextField txtJMBG=new JTextField();
	        txtJMBG.setPreferredSize(dim);
	        KeyListener keyListener1=new MyKeyListener1();
	        txtJMBG.addKeyListener(keyListener1);

	        panPanel.add(lblJMBG);
	        panPanel.add(txtJMBG);
	        
	        //Datum rodjenja  isto da mogu samo brojevi
	        JLabel lblBirth=new JLabel("Date of birth (dd/mm/yyyy):");
	        lblBirth.setPreferredSize(dim);

	        JTextField txtDay=new JTextField();
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
	        			JOptionPane.showMessageDialog(null, "Dan mora biti broj od 1 do 31!");
	        			txt.setText(txt.getText().substring(0, txt.getText().length() - 1));
	        			}
	        			str = txt.getText();
	        			System.out.println(str);
	        	 }
	        	@Override
	        	public void keyTyped(KeyEvent arg0) {

	        	}
	         });

	        JTextField txtMonth=new JTextField();
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
	        			JOptionPane.showMessageDialog(null, "Dan mora biti broj od 1 do 31!");
	        			txt.setText(txt.getText().substring(0, txt.getText().length() - 1));
	        			}
	        			str = txt.getText();
	        			System.out.println(str);
	        	 }
	        	@Override
	        	public void keyTyped(KeyEvent arg0) {

	        	}
	         });
	        
	        JTextField txtYear=new JTextField();
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
	        				JOptionPane.showMessageDialog(null, "Možete uneti maksimalno 4 karaktera!");
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
	        				JOptionPane.showMessageDialog(null, "Dozvoljen je unos samo brojeva!");
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

	        JTextField txtEmail=new JTextField();
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
	        
	        JTextField txtAdressStreet=new JTextField();
	        txtAdressStreet.setPreferredSize(dim);
	        KeyListener keyListener4=new MyKeyListener2();
	        txtAdressStreet.addKeyListener(keyListener4);
	        
	        //broj
	        JLabel lblAdressNum=new JLabel("Number:");
	        lblAdressNum.setPreferredSize(dim);
	        
	        JTextField txtAdressNum=new JTextField();
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
	        			JOptionPane.showMessageDialog(null, "Dozvoljen je unos samo brojeva i slova!");
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
	        
	        
	        //grad
	        JLabel lblAdressCity=new JLabel("City:");
	        lblAdressCity.setPreferredSize(dim);
	        
	        JTextField txtAdressCity=new JTextField();
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
	       	          
	        String[] softveri= {"Software 1","Software 2","Software 3","Software 4","Software 5"};
	        JComboBox<String> cb1=new JComboBox<String>(softveri);
	        
	        cb1.addItemListener(new ItemListener() {
	            public void itemStateChanged(ItemEvent arg0) {
	            	if (arg0.getStateChange() == ItemEvent.SELECTED) {
	            		String cb_value1 = (String) arg0.getItem();
	            		System.out.println(cb_value1);
	                 }
	            }
	        });
	        cb1.setVisible(true);
	        
//	        JCheckBox checkBox1=new JCheckBox("software1");
//	        JCheckBox checkBox2=new JCheckBox("software2");
//	        JCheckBox checkBox3=new JCheckBox("software3");
	        
	        panPanel.add(lblSoftware);
	        panPanel.add(cb1);
//	        panPanel.add(checkBox1);
//	        panPanel.add(checkBox2);
//	        panPanel.add(checkBox3);
//	        panPanel.add(Box.createRigidArea(new Dimension(300,0)));
	        
	        
	        //RADNO MESTO dropdown
	        JLabel lblJobs=new JLabel ("Choose a job:");
	        lblJobs.setPreferredSize(dim);
	        
	        String[] poslovi = { "CHOICE 1","CHOICE 2", "CHOICE 3","CHOICE 4","CHOICE 5","CHOICE 6"};
	        JComboBox<String> cb2 = new JComboBox<String>(poslovi);
	        cb2.addItemListener(new ItemListener() {
	            public void itemStateChanged(ItemEvent arg0) {
	            	if (arg0.getStateChange() == ItemEvent.SELECTED) {
	            		String cb_value2 = (String) arg0.getItem();
	            		System.out.println(cb_value2);
	                 }
	            }
	        });

	        cb2.setVisible(true);
	        
//	        JRadioButton radBtn1 = new JRadioButton("Job 1");
//			JRadioButton radBtn2 = new JRadioButton("Job 2");
			
//			ButtonGroup btnGroupJob = new ButtonGroup();
//			btnGroupJob.add(radBtn1);
//			btnGroupJob.add(radBtn2);
			
			panPanel.add(lblJobs);
	        panPanel.add(cb2);
//			panPanel.add(radBtn1);
//			panPanel.add(radBtn2);
	        //
	        
	        panCenter.add(panPanel);
	        
	        //panCenter.add(Box.createVerticalStrut(25));  
	        
	        
	       // add(panCenter,);
	        
	        JPanel panBottom=new JPanel();
			BoxLayout box=new BoxLayout(panBottom, BoxLayout.X_AXIS); //sredi posle u 1 liniju sve
			panBottom.setLayout(box);
			dijalogEmployee.add(panBottom,BorderLayout.SOUTH);
			
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
		dijalogEmployee.setResizable(false);
		dijalogEmployee.setVisible(true); 
		pack();
		
	}
}
