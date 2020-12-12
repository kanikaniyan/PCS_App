package view;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.text.ParseException;

import javax.swing.*;

import controller.EmployeeController;
import model.Employee;

public class LoginFrame extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7483283843347525854L;
	Container container;
	JPanel pHead;
	JLabel lHead, lUserID, lPassword, lMessage;
	JTextField tUserID;
	JPasswordField tPassword;
	JButton bLogin, bRegister;
	JCheckBox cShowPassword;
	EmployeeController empController=null;
	
	public LoginFrame() throws ClassNotFoundException, SQLException {
		container=getContentPane();
		lHead=new JLabel("Login Page");
		pHead=new JPanel();
		pHead.add(lHead);
		lUserID=new JLabel("UserName");
		lMessage=new JLabel();
		lPassword=new JLabel("Password");
		tUserID=new JTextField();
		tPassword=new JPasswordField();
		tPassword.setEchoChar('*');
		bLogin=new JButton("LOGIN");
		bRegister=new JButton("Register");
		empController =new EmployeeController();
		
		bLogin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String userId, password;
				userId=tUserID.getText();
				password=new String (tPassword.getPassword());
				Employee emp=empController.checkLogin(userId, password);
				if (emp.getUserID()==null || emp.getPassword()==null) {
					lMessage.setText("* you are not authorized user! Retry or Register");
				}
				else {
					if ((emp.getActive()).equals("YES")) {
						if ((emp.getRole()).equals("HRA")) {
							try {
								new HRWindow(emp);
								dispose();
							} catch (ClassNotFoundException | SQLException e1) {
								e1.printStackTrace();
							}
						}
						else if (emp.getRole().equals("PME")) {
							try {
								new PMWindow(emp);
								dispose();
							} catch (ClassNotFoundException | SQLException e1) {
								e1.printStackTrace();
							}
						}
						else {
							try {
								new EmpWindow(emp);
							} catch (ClassNotFoundException | SQLException e1) {
								e1.printStackTrace();
							}
							dispose();
						}
						
					}
					else {
						lMessage.setText("you are not authorized user! Retry or Register");
					}
				}
			}
			
		});
		
		
		bRegister.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new RegistrationFrame();
					dispose();
				} catch (ClassNotFoundException | SQLException | ParseException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		cShowPassword=new JCheckBox("Show Password");
		
		cShowPassword.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (cShowPassword.isSelected()) {
				      tPassword.setEchoChar((char)0);
				   } else {
				      tPassword.setEchoChar('*');
				   }
				
			}
			
		});
		
		setLayoutManager();
		setLocationAndSize();
		addComponentsToContainer();
		this.setTitle("Login Form");
		this.setBounds(10,10,400,465);
		setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
	}
	
	public void setLayoutManager() {
		container.setLayout(null);
	}
	
	public void setLocationAndSize() {
		lMessage.setBounds(115, 320, 300, 30);
		pHead.setBounds(0, 20, 400, 50);
		lUserID.setBounds(30,150,100,30);
		lPassword.setBounds(30, 220, 150, 30);
		tUserID.setBounds(220, 150, 150, 25);
		tPassword.setBounds(220, 220, 150, 25);
		cShowPassword.setBounds(220, 260, 150, 30);
		bLogin.setBounds(30, 320, 100, 25);
		bRegister.setBounds(270, 320, 100, 25);
		
		lHead.setFont(new java.awt.Font("Tahoma", 1, 18));
		lHead.setForeground(new java.awt.Color(255, 255, 255));
		pHead.setBackground(new java.awt.Color(243, 156, 18));
		
		bLogin.setBackground(new Color(35, 203, 167));
        bLogin.setForeground(new Color(240, 240, 240));
        bLogin.setBorder(new RoundedBorder(12));
        
        bRegister.setBackground(new Color(246, 71, 71));
        bRegister.setForeground(new Color(240, 240, 240));
        bRegister.setBorder(new RoundedBorder(12));
	}
	
	public void addComponentsToContainer() {
		container.add(pHead, BorderLayout.CENTER);
		container.add(lUserID);
		container.add(tUserID);
		container.add(lPassword);
		container.add(tPassword);
		container.add(cShowPassword);
		container.add(bLogin);
		container.add(bRegister);
		container.add(lMessage);
	}

}
