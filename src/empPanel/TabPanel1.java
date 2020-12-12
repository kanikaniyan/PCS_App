package empPanel;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Employee;

public class TabPanel1 extends JPanel{
	private static final long serialVersionUID = 1L;
	JPanel inPanel1, inPanel2;
	JLabel lName, lUserID, lPassword, lGender, lPhoneNumber, lRole, lActive;
	public static JTextField tName, tPassword, tPhoneNumber;
	JTextField tUserID, tGender, tRole, tActive;
	public TabPanel1(Employee emp) {
		
		inPanel1 =new JPanel();
		inPanel2 =new JPanel();
		
		lName=new JLabel("Name : ");
		lUserID=new JLabel("User ID : ");
		lPassword= new JLabel("Password : ");
		lGender=new JLabel("Gender : ");
		lPhoneNumber=new JLabel("Phone Number : ");
		lRole=new JLabel("Role : ");
		lActive=new JLabel("Active : ");

		tName=new JTextField(emp.getFirstName()+" "+emp.getLastName(), 12);
		tUserID=new JTextField(emp.getUserID(), 12);
		tPassword=new JTextField(emp.getPassword(), 12);
		tGender=new JTextField(emp.getGender(), 12);
		tPhoneNumber=new JTextField(String.valueOf(emp.getPhoneNumber()), 12);
		tRole=new JTextField(emp.getRole(), 12);
		tActive=new JTextField(emp.getActive(), 12);
		
		tName.setEditable(false);
		tUserID.setEditable(false);
		tPassword.setEditable(false);
		tGender.setEditable(false);
		tPhoneNumber.setEditable(false);
		tRole.setEditable(false);
		tActive.setEditable(false);
		
		inPanel1.setLayout(new BoxLayout(inPanel1, BoxLayout.PAGE_AXIS));
		inPanel1.add(Box.createRigidArea(new Dimension(0, 17)));
		inPanel1.add(lName);
		inPanel1.add(Box.createRigidArea(new Dimension(0, 24)));
		inPanel1.add(lUserID);
		inPanel1.add(Box.createRigidArea(new Dimension(0, 24)));
		inPanel1.add(lPassword);
		inPanel1.add(Box.createRigidArea(new Dimension(0, 24)));
		inPanel1.add(lGender);
		inPanel1.add(Box.createRigidArea(new Dimension(0, 24)));
		inPanel1.add(lPhoneNumber);
		inPanel1.add(Box.createRigidArea(new Dimension(0, 24)));
		inPanel1.add(lRole);
		inPanel1.add(Box.createRigidArea(new Dimension(0, 25)));
		inPanel1.add(lActive);
		
		this.add(inPanel1, Component.LEFT_ALIGNMENT); 
		
		inPanel2.setLayout(new BoxLayout(inPanel2, BoxLayout.PAGE_AXIS));
		inPanel2.add(Box.createRigidArea(new Dimension(0, 20)));
		inPanel2.add(tName);
		inPanel2.add(Box.createRigidArea(new Dimension(0, 20)));
		inPanel2.add(tUserID);
		inPanel2.add(Box.createRigidArea(new Dimension(0, 20)));
		inPanel2.add(tPassword);
		inPanel2.add(Box.createRigidArea(new Dimension(0, 20)));
		inPanel2.add(tGender);
		inPanel2.add(Box.createRigidArea(new Dimension(0, 20)));
		inPanel2.add(tPhoneNumber);
		inPanel2.add(Box.createRigidArea(new Dimension(0, 20)));
		inPanel2.add(tRole);
		inPanel2.add(Box.createRigidArea(new Dimension(0, 20)));
		inPanel2.add(tActive);
		
		this.add(inPanel2, Component.LEFT_ALIGNMENT); 
	}
	
}
