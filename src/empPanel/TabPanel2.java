package empPanel;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.EmployeeController;
import model.Employee;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import view.RoundedBorder;

public class TabPanel2 extends JPanel{
	private static final long serialVersionUID = 1L;
	JPanel inPanel, switchP1, switchP2, switchP3;
	JButton bName, bPassword, bPhoneNumber, bSwitch1, bSwitch2, bSwitch3;
	JLabel lTextS1, lText1S2, lText2S2, lText3S2, lText1S3;
	JTextField tText1S1, tText2S1, tText1S3;
	JPasswordField tText1S2, tText2S2, tText3S2;
	JFrame jpane;
	EmployeeController empController=null;
	
	public TabPanel2(Employee emp) throws ClassNotFoundException, SQLException {
		
		jpane=new JFrame();
		
		inPanel=new JPanel();
		switchP1=new JPanel();
		switchP2=new JPanel();
		switchP3=new JPanel();
		
		lTextS1=new JLabel("Enter First & Last Name: ");
		tText1S1=new JTextField(7);
		tText2S1=new JTextField(7);
		
		lText1S2=new JLabel("Enter old Password");
		lText2S2=new JLabel("Enter new Passoword");
		lText3S2=new JLabel("Enter confirm Password");
		tText1S2=new JPasswordField(8);
		tText2S2=new JPasswordField(8);
		tText3S2=new JPasswordField(8);
		String validatePass= "^(?=.*[0-9])"+"(?=.*[a-z])(?=.*[A-Z])"+"(?=.*[@#$%&+=^])"+"(?=\\S+$).{8,18}$";
		
		lText1S3=new JLabel("Enter the Phone Number : ");
		tText1S3=new JTextField(12);
		String validatePh="[7-9][0-9]{9}";
		
		switchP1.setVisible(false);
		switchP2.setVisible(false);
		switchP3.setVisible(false);
		
		bName=new JButton("Update Name");
		bPassword=new JButton("Update Password");
		bPhoneNumber=new JButton("Update Phone Number");
		
		bSwitch1=new JButton("Update");
		bSwitch2=new JButton("Update");
		bSwitch3=new JButton("Update");
		
		inPanel.setLayout(new BoxLayout(inPanel, BoxLayout.LINE_AXIS));
		inPanel.add(bName);
		inPanel.add(Box.createRigidArea(new Dimension(20, 0)));
		inPanel.add(bPassword);
		inPanel.add(Box.createRigidArea(new Dimension(20, 0)));
		inPanel.add(bPhoneNumber);
		
		bName.setBackground(new Color(246, 71, 71));
        bName.setForeground(new Color(240, 240, 240));
        bName.setBorder(new RoundedBorder(5));
		
        bPassword.setBackground(new Color(246, 71, 71));
        bPassword.setForeground(new Color(240, 240, 240));
        bPassword.setBorder(new RoundedBorder(5));
        
        bPhoneNumber.setBackground(new Color(246, 71, 71));
        bPhoneNumber.setForeground(new Color(240, 240, 240));
        bPhoneNumber.setBorder(new RoundedBorder(5));
		
		//name update
		switchP1.setLayout(new BoxLayout(switchP1, BoxLayout.LINE_AXIS));
		switchP1.add(lTextS1);
		switchP1.add(Box.createRigidArea(new Dimension(25, 0)));
		switchP1.add(tText1S1);
		switchP1.add(Box.createRigidArea(new Dimension(10, 0)));
		switchP1.add(tText2S1);
		switchP1.add(Box.createRigidArea(new Dimension(25, 0)));
		switchP1.add(bSwitch1);
		
		//update password
		switchP2.setLayout(new BoxLayout(switchP2, BoxLayout.PAGE_AXIS));
		switchP2.add(Box.createRigidArea(new Dimension(0, 20)));
		switchP2.add(lText1S2);
		switchP2.add(tText1S2);
		switchP2.add(Box.createRigidArea(new Dimension(0, 20)));
		switchP2.add(lText2S2);
		switchP2.add(tText2S2);
		switchP2.add(Box.createRigidArea(new Dimension(0, 20)));
		switchP2.add(lText3S2);
		switchP2.add(tText3S2);
		switchP2.add(Box.createRigidArea(new Dimension(0, 20)));
		switchP2.add(bSwitch2);
		
		//update phone number
		switchP3.setLayout(new BoxLayout(switchP3, BoxLayout.LINE_AXIS));
		switchP3.add(lText1S3);
		switchP3.add(Box.createRigidArea(new Dimension(25, 0)));
		switchP3.add(tText1S3);
		switchP3.add(Box.createRigidArea(new Dimension(25, 0)));
		switchP3.add(bSwitch3);
		
		inPanel.setBorder(new EmptyBorder(new Insets(20, 200, 20, 200)));
		inPanel.setBackground(Color.LIGHT_GRAY);
		
        lTextS1.setFont(new java.awt.Font("Tahoma", 1, 13));
        lText1S3.setFont(new java.awt.Font("Tahoma", 1, 13));
        
		this.add(inPanel);
		this.add(switchP1);
		this.add(switchP2);
		this.add(switchP3);
		
		empController=new EmployeeController();
		
		bName.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				switchP1.setVisible(true);
				
				bSwitch1.setPreferredSize(new Dimension(100,25));
				bSwitch1.setBackground(new Color(35, 203, 167));
				bSwitch1.setForeground(new Color(240, 240, 240));
				bSwitch1.setBorder(new RoundedBorder(12));
		        
				switchP1.setBorder(new EmptyBorder(new Insets(110, 200, 143, 200)));
				switchP1.setBackground(Color.LIGHT_GRAY);
				
			}
			
		});
		
		bSwitch1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(tText1S1.getText().isEmpty() || tText2S1.getText().isEmpty()) {
					JOptionPane.showMessageDialog(jpane, "Enter the name to update!");
				}
				else {
					int opt=JOptionPane.showConfirmDialog(jpane, "Do you want to update your name!", "Confirmation Message", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
					
					if(opt==JOptionPane.YES_OPTION) {
						int ID;
						String fName, lName;
						ID=emp.getEmployeeID();
						fName=tText1S1.getText();
						lName=tText2S1.getText();
						
						EmployeeController.UpdateEmployee upName=empController.new UpdateEmployee();
						upName.updateName(ID, fName, lName);
						
						tText1S1.setText(null);
						tText2S1.setText(null);
					}
				}
			}
			
		});
		
		//password
		bPassword.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				switchP1.setVisible(false);
				switchP2.setVisible(true);
				
				bSwitch2.setPreferredSize(new Dimension(100,25));
				bSwitch2.setBackground(new Color(35, 203, 167));
				bSwitch2.setForeground(new Color(240, 240, 240));
				bSwitch2.setBorder(new RoundedBorder(10));
		        
				switchP2.setBorder(new EmptyBorder(new Insets(20, 200, 45, 200)));
				switchP2.setBackground(Color.LIGHT_GRAY);
				
			}
			
		});
		
		bSwitch2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String password=new String(tText1S2.getPassword());
				String password1=new String(tText2S2.getPassword());
				String password2=new String(tText3S2.getPassword());
				
				if(password.isEmpty()) {
					JOptionPane.showMessageDialog(jpane, "Password field is empty!");
				}
				else 
					{
						if(password1.isEmpty() || password2.isEmpty()) {
							JOptionPane.showMessageDialog(jpane, "Password field is empty!");
						}
						else {
							if(password.equals(emp.getPassword())) {
					
								if(password1.matches(validatePass)) {
									if(password1.equals(password2)) {
										try {
											
											int id=emp.getEmployeeID();
											empController.updateEmployee(id, password1);
											
										} catch (ClassNotFoundException | SQLException e) {
											e.printStackTrace();
										}
									}
									else {
										JOptionPane.showMessageDialog(jpane, "Password Doesn't match!");
									}
								}
								else {
									JOptionPane.showMessageDialog(jpane, "Enter a valid password!");
								}
							}
							else {
								JOptionPane.showMessageDialog(jpane, "old Password Doesn't match!");
							}
						}
					}	
				}
			});
		
		//phone number
		bPhoneNumber.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				switchP1.setVisible(false);
				switchP2.setVisible(false);
				switchP3.setVisible(true);
				
				bSwitch3.setPreferredSize(new Dimension(100,25));
				bSwitch3.setBackground(new Color(35, 203, 167));
				bSwitch3.setForeground(new Color(240, 240, 240));
				bSwitch3.setBorder(new RoundedBorder(12));
		        
				switchP3.setBorder(new EmptyBorder(new Insets(110, 200, 143, 200)));
				switchP3.setBackground(Color.LIGHT_GRAY);
			}
			
		});
		
		bSwitch3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(tText1S3.getText().isEmpty()) {
					JOptionPane.showMessageDialog(jpane, "Enter the phone number to update!");
				}
				else {
					
					int ID;
					String phoneNumber;
					ID=emp.getEmployeeID();
					phoneNumber=tText1S3.getText();
					
					if(phoneNumber.matches(validatePh)) {
						int opt=JOptionPane.showConfirmDialog(jpane, "Do you want to update your Number!", "Confirmation Message", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
						
						if(opt==JOptionPane.YES_OPTION) {
						
							EmployeeController.UpdateEmployee upPhone=empController.new UpdateEmployee();
							upPhone.updatePhone(ID, phoneNumber);
						
							tText1S3.setText(null);
						}
					}
					else {
						JOptionPane.showMessageDialog(jpane, "Enter valid phone number to update!");
					}
				}
			}
			
		});
	}
}
