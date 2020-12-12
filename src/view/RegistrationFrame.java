package view;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.*;
import javax.swing.text.MaskFormatter;

import controller.EmployeeController;

public class RegistrationFrame extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Container container=null;
	JLabel lHead, lName, lFName, lLName, lGender, lMailID, lDesgn, lPhno, lCph, lCph1, lPassword, lCrPassword, lCoPassword, lMessage;
	JTextField tFName, tLName, tMailID, tPhno;
	JPasswordField tCrPassword, tCoPassword;
	JFormattedTextField tPhnoCode;
	JPanel pHead;
	JButton bSubmit, bLogin;
	JCheckBox cAgree;
	JRadioButton rMale, rFemale;
	ButtonGroup buttonGroup;
	MaskFormatter mMailID, mPhnoCode, mPhno;
	@SuppressWarnings("rawtypes")
	JComboBox cDesgn;
	JFrame jpane;
	
	EmployeeController empController=null;
	@SuppressWarnings("unchecked")
	public RegistrationFrame() throws ClassNotFoundException, SQLException, ParseException {
		container=getContentPane();
		
		lHead=new JLabel("Registration Form");
		pHead=new JPanel();
		pHead.add(lHead);
		lName =new JLabel("Name");
		lFName =new JLabel("First Name");
		lLName =new JLabel("Last Name");
		lGender =new JLabel("Gender");
		lMailID =new JLabel("E-Mail ID");
		lDesgn =new JLabel("Designation");
		cDesgn =new JComboBox<String>();
		lPhno =new JLabel("Phone");
		lCph =new JLabel("Code");
		lCph1 =new JLabel("Phone Number");
		lPassword =new JLabel("Password");
		lCrPassword =new JLabel("Create Password");
		lCoPassword =new JLabel("Confirm Password");
		lMessage =new JLabel();
		jpane=new JFrame();
		
		buttonGroup =new ButtonGroup();
		rMale =new JRadioButton("Male");
		rMale.setActionCommand("Male");
		rFemale =new JRadioButton("Female");
		rFemale.setActionCommand("Female");
		
		buttonGroup.add(rMale);
		buttonGroup.add(rFemale);
		
		tFName =new JTextField();
		tLName =new JTextField();
		tMailID =new JTextField();
		tPhno=new JTextField();
		String validateMail = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
		String validatePh="[7-9][0-9]{9}";
		
		cDesgn.addItem("HRA");
		cDesgn.addItem("PME");
		cDesgn.addItem("EMP");
		
		mPhnoCode =new MaskFormatter("+91");
		tPhnoCode =new JFormattedTextField(mPhnoCode);
		
		tCrPassword =new JPasswordField();
		tCoPassword =new JPasswordField();
		String validatePass= "^(?=.*[0-9])"+"(?=.*[a-z])(?=.*[A-Z])"+"(?=.*[@#$%&+=^])"+"(?=\\S+$).{8,18}$";
		
		bSubmit =new JButton("REGISTER");
		bLogin =new JButton("BACK");
	
		cAgree =new JCheckBox("I agree the terms & conditions");
		
		empController =new EmployeeController();
		
		bSubmit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				if (tFName.getText().isEmpty() || tLName.getText().isEmpty()) {
					lMessage.setText("* Enter the Name!");
				}
				else {
					lMessage.setText(null);
					if (buttonGroup.getSelection()==null) {
						lMessage.setText("* select a button");
					}
					else {
						lMessage.setText(null);
					if (tMailID.getText().isEmpty()) {
						lMessage.setText("* Enter the EmailID!");
					}
					else {
						lMessage.setText(null);
						boolean result=tMailID.getText().matches(validateMail);
						if (result==false) {
							lMessage.setText("Enter a valid EmailID");
						}
						else {
							lMessage.setText(null);
							if (tPhno.getText().isEmpty()) {
							lMessage.setText("* Enter the Phone number!");
						}
							else {
								lMessage.setText(null);
								boolean result1=tPhno.getText().matches(validatePh);
								if (result1==false) {
									lMessage.setText("Enter a valid Phone number");
								}
								else {
									lMessage.setText(null);
									String pass1, pass2;
									pass1=new String (tCrPassword.getPassword());
									pass2=new String (tCoPassword.getPassword());
									if (pass1.isEmpty() || pass2.isEmpty()) {
										lMessage.setText("* Enter the Password!");
									}
									else {
										lMessage.setText(null);
										boolean result2=pass1.matches(validatePass);
										if (result2==false) {
											lMessage.setText("* password should contain atleast 1 UC, 1SC, no space, between 8 and 18 characters");
										}
										else {
											Pattern pat=Pattern.compile(pass1);
											Matcher mat=pat.matcher(pass2);
											boolean matchFound=mat.matches();
								
											if (matchFound==true) {
												lMessage.setText(null);
												if (cAgree.isSelected()) {
													lMessage.setText(null);
													try {
														if (connectDB()==true) {
															bSubmit.setEnabled(false);
															bLogin.setText("LOGIN");
															bLogin.addActionListener(new ActionListener() {

																@Override
																public void actionPerformed(ActionEvent e) {
																	try {
																		new LoginFrame();
																		dispose();
																	} catch (ClassNotFoundException | SQLException e1) {
																		e1.printStackTrace();
																	}
																
																}
															
															});
														}
													} catch (IOException e) {
														e.printStackTrace();
													}
												}
												else {
													lMessage.setText("* Please agree the terms & conditions!!");
												}
											}
											else {
												lMessage.setText("* Password does not match!");
									
											}
										}
									}
								}
							}
						}
					}
					}
				
				}
			}
	});
		
		
		bLogin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new LoginFrame();
					dispose();
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
			
			}
		
		});
		
		setLayoutManager();
		setLocationAndSize();
		setAddToComponentsToContainer();
		this.setTitle("Registration Form");
		this.setVisible(true);
		this.setBounds(10, 10, 570, 570);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
	}
	
	public boolean connectDB() throws IOException {
		
		int option=JOptionPane.showConfirmDialog(jpane, "Do you want to register?", "Confirmation Message", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
		
		if (option==JOptionPane.YES_OPTION) {
			String fName, lName, gender, emailId, password, desgn;
			Long phone;
			fName=tFName.getText();
			lName=tLName.getText();
			gender=buttonGroup.getSelection().getActionCommand();
			emailId=tMailID.getText().toLowerCase();
			password=new String(tCrPassword.getPassword());
			desgn=(String) cDesgn.getSelectedItem();
			phone=Long.parseLong(tPhno.getText());
			empController.addEmployee(fName, lName, gender, emailId, password, desgn, phone);
			return true;
		}
		else {
			return false;
		}
		
	}
	
	public void setLayoutManager() {
		container.setLayout(null);
	}
	
	public void setLocationAndSize() {
		pHead.setBounds(0, 20, 570, 50);
		lName.setBounds(50, 100, 100, 25);
		lFName.setBounds(230, 120, 100, 25);
		tFName.setBounds(230, 100, 130, 25);
		lLName.setBounds(375, 120, 100, 25);
		tLName.setBounds(375, 100, 130, 25);
		
		lGender.setBounds(50, 160, 50, 25);
		rMale.setBounds(230, 160, 80, 25);
		rFemale.setBounds(320, 160, 80, 25);
		
		lMailID.setBounds(50, 210, 100, 25);
		tMailID.setBounds(230, 210, 275, 25);
		
		lDesgn.setBounds(50, 260, 100, 25);
		cDesgn.setBounds(230, 260, 275, 25);
		
		lPhno.setBounds(50, 310,  100, 25);
		tPhnoCode.setBounds(230, 310, 50, 25);
		lCph.setBounds(230, 330, 50, 25);
		tPhno.setBounds(295, 310, 210, 25);
		lCph1.setBounds(295, 330, 100, 25);
		
		lPassword.setBounds(50, 360, 100, 25);
		lCrPassword.setBounds(230, 380, 100, 25);
		tCrPassword.setBounds(230, 360, 130, 25);
		lCoPassword.setBounds(375, 380, 110, 25);
		tCoPassword.setBounds(375, 360, 130, 25);
		
		cAgree.setBounds(50, 425, 200, 25);
		lMessage.setBounds(70, 450, 520, 25);
		lMessage.setForeground(new Color(246, 71, 71));
		
		lHead.setFont(new java.awt.Font("Tahoma", 1, 18));
		lHead.setForeground(new java.awt.Color(255, 255, 255));
		pHead.setBackground(new java.awt.Color(243, 156, 18));
		
		bSubmit.setBounds(50, 480, 100, 30);
		bSubmit.setBackground(new Color(246, 71, 71));
        bSubmit.setForeground(new Color(240, 240, 240));
        bSubmit.setBorder(new RoundedBorder(12));
        
        bLogin.setBounds(405, 480, 100, 30);
        bLogin.setBackground(new Color(35, 203, 167));
        bLogin.setForeground(new Color(240, 240, 240));
        bLogin.setBorder(new RoundedBorder(12));
        
        lFName.setFont(new java.awt.Font("Helvetica", 1, 11));
        lLName.setFont(new java.awt.Font("Helvetica", 1, 11));
        lCph.setFont(new java.awt.Font("Helvetica", 1, 11));
        lCph1.setFont(new java.awt.Font("Helvetica", 1, 11));
        lCrPassword.setFont(new java.awt.Font("Helvetica", 1, 11));
        lCoPassword.setFont(new java.awt.Font("Helvetica", 1, 11));
	}
	
	public void setAddToComponentsToContainer() {
		container.add(pHead);
		container.add(lName);
		container.add(lFName);
		container.add(tFName);
		container.add(lLName);
		container.add(tLName);
		container.add(lGender);
		container.add(rMale);
		container.add(rFemale);
		container.add(lMailID);
		container.add(tMailID);
		container.add(lDesgn);
		container.add(cDesgn);
		container.add(lPhno);
		container.add(tPhnoCode);
		container.add(lCph);
		container.add(tPhno);
		container.add(lCph1);
		container.add(lPassword);
		container.add(lCrPassword);
		container.add(tCrPassword);
		container.add(lCoPassword);
		container.add(tCoPassword);
		container.add(cAgree);
		container.add(lMessage);
		container.add(bSubmit);
		container.add(bLogin);
	}
}
