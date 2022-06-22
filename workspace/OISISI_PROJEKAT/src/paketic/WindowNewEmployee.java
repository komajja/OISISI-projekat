package paketic;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

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

	        panPanel.add(lblName);
	        panPanel.add(txtName);
	       			
	        //PREZIME dodati da mogu samo slova
	        //JPanel panLastName=new JPanel(new FlowLayout(FlowLayout.LEFT));
	        JLabel lblLastName=new JLabel("Last name:");
	        lblLastName.setPreferredSize(dim);

	        JTextField txtLastName=new JTextField();
	        txtLastName.setPreferredSize(dim);

	        panPanel.add(lblLastName);
	        panPanel.add(txtLastName);
	        
	        //JMBG dodati da mogu samo brojevi, odredjen br cifara i da je unique
	        JLabel lblJMBG=new JLabel("JMBG:");
	        lblJMBG.setPreferredSize(dim);

	        JTextField txtJMBG=new JTextField();
	        txtJMBG.setPreferredSize(dim);

	        panPanel.add(lblJMBG);
	        panPanel.add(txtJMBG);
	        
	        //Datum rodjenja  isto da mogu samo brojevi
	        JLabel lblBirth=new JLabel("Date of birth:");
	        lblBirth.setPreferredSize(dim);

	        JTextField txtBirth=new JTextField();
	        txtBirth.setPreferredSize(dim);

	        panPanel.add(lblBirth);
	        panPanel.add(txtBirth);
	        
	        //EMAIL
	        JLabel lblEmail=new JLabel("Email:");
	        lblEmail.setPreferredSize(dim);

	        JTextField txtEmail=new JTextField();
	        txtEmail.setPreferredSize(dim);

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
	        //broj
	        JLabel lblAdressNum=new JLabel("Number:");
	        lblAdressNum.setPreferredSize(dim);
	        
	        JTextField txtAdressNum=new JTextField();
	        txtAdressNum.setPreferredSize(dim);
	        //grad
	        JLabel lblAdressCity=new JLabel("City:");
	        lblAdressCity.setPreferredSize(dim);
	        
	        JTextField txtAdressCity=new JTextField();
	        txtAdressCity.setPreferredSize(dim);

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
	        JComboBox<String> cb = new JComboBox<String>(poslovi);

	        cb.setVisible(true);
	        
//	        JRadioButton radBtn1 = new JRadioButton("Job 1");
//			JRadioButton radBtn2 = new JRadioButton("Job 2");
			
//			ButtonGroup btnGroupJob = new ButtonGroup();
//			btnGroupJob.add(radBtn1);
//			btnGroupJob.add(radBtn2);
			
			panPanel.add(lblJobs);
	        panPanel.add(cb);
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
