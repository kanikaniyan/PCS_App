package view;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controller.JobController;
import model.Employee;

public class AddJob extends JFrame{

	private static final long serialVersionUID = 1L;
	JLabel lHead, lTitle, lJobTitle, lDesc, lCompanyName, lLocation, lKeySkill, lSalary, lMessage;
	JTextField tJobTitle, tCompanyName, tKeySkill, tSalary;
	JTextArea tDesc;
	JPanel pHead;
	JComboBox<Object> cLocation;
	JButton bAdd, bBack, bAdd2;
	JFrame jpane;
	Container container=null;
	JobController jobController=null;
	
	public AddJob(Employee emp) throws ClassNotFoundException, SQLException {
		container =getContentPane();
		
		lHead=new JLabel("PM's View");
		pHead=new JPanel();
		pHead.add(lHead);
		
		jpane=new JFrame();
		
		lTitle=new JLabel("Enter the Details to Add a Job");
		lJobTitle=new JLabel("Job Title");
		lDesc=new JLabel("Job Description");
		lCompanyName=new JLabel("Company Name");
		lLocation=new JLabel("Location");
		lKeySkill=new JLabel("Key Skill");
		lSalary=new JLabel("Salary");
		lMessage=new JLabel();
		
		tJobTitle=new JTextField();
		tCompanyName=new JTextField(" Professionet Consultancy Services");
		tCompanyName.setEditable(false);
		tKeySkill=new JTextField();
		tSalary=new JTextField();
		
		tDesc=new JTextArea();
		tDesc.setWrapStyleWord(true);
		tDesc.setLineWrap(true);
		
		cLocation=new JComboBox<Object>();
		cLocation.addItem("Chennai");
		cLocation.addItem("Mumbai");
		cLocation.addItem("Delhi");
		cLocation.addItem("Pune");
		cLocation.addItem("Cochin");
		cLocation.addItem("Bangalore");
		cLocation.addItem("Kolkata");
		
		bAdd=new JButton("Add Job");
		bBack=new JButton("Back");
		bAdd2=new JButton("Add Another Job");
		
		bAdd2.setVisible(false);
		
		jobController=new JobController();
		
		bAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				lMessage.setText(null);
				if (tJobTitle.getText().isEmpty()) {
					lMessage.setText("* Enter the Job Title!");
				}
				else {
					if (tDesc.getText().isEmpty()) {
						lMessage.setText("* Enter Job Description!");
					}
					else {
						if (tKeySkill.getText().isEmpty()) {
							lMessage.setText("* Enter the Key SKill!");
						}
						else {
							if (tSalary.getText().isEmpty()) {
								lMessage.setText("* Enter the Salary!");
							}
							else {
								if (connectJobDB()==true) {
									bAdd.setVisible(false);
									bAdd2.setVisible(true);
									
									bAdd2.addActionListener(new ActionListener() {

										@Override
										public void actionPerformed(ActionEvent arg0) {
											dispose();
											try {
												new AddJob(emp);
											} catch (ClassNotFoundException | SQLException e) {
												e.printStackTrace();
											}
										}
										
									});
								}
							}
						}
					}
				}
			}
			
		});
		
		bBack.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				try {
					new PMWindow(emp);
				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}
			}
			
		});
		
		setLayoutManager();
		setLocationAndSize();
		setAddToComponentsToContainer();
		
		this.setTitle("Add Job");
		this.setVisible(true);
		this.setBounds(10, 10, 485, 540);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
	}
	
	public boolean connectJobDB() {
		
		int option=JOptionPane.showConfirmDialog(jpane, "Do you want to add this Job?", "Confirmation Message", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
		if (option==JOptionPane.YES_OPTION) {
			String JobTitle, Desc, CompanyName, Location, KeySkill, Salary;
			JobTitle=tJobTitle.getText();
			Desc=tDesc.getText();
			CompanyName=tCompanyName.getText();
			Location=(String) cLocation.getSelectedItem();
			KeySkill=tKeySkill.getText();
			Salary=tSalary.getText();
			jobController.addJob(JobTitle, Desc, CompanyName, Location, KeySkill, Salary);
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
		pHead.setBounds(0, 20, 485, 50);
		pHead.setBackground(new java.awt.Color(243, 156, 18));
		lHead.setFont(new java.awt.Font("Tahoma", 1, 18));
		lHead.setForeground(new java.awt.Color(255, 255, 255));
		
		lTitle.setBounds(30, 80, 300, 30);
		lTitle.setFont(new java.awt.Font("Tahoma", 1, 14));
		
		lJobTitle.setBounds(50, 150, 100, 25);
		tJobTitle.setBounds(230, 150, 200, 25);
		
		lDesc.setBounds(50, 196, 100, 25);
		tDesc.setBounds(230, 190, 200, 40);
		
		lCompanyName.setBounds(50, 245, 100, 25);
		tCompanyName.setBounds(230, 245, 200, 25);
		
		lLocation.setBounds(50, 285, 100, 25);
		cLocation.setBounds(230, 285, 200, 25);
		
		lKeySkill.setBounds(50, 325, 100, 25);
		tKeySkill.setBounds(230, 325, 200, 25);
		
		lSalary.setBounds(50, 365, 100, 25);
		tSalary.setBounds(230, 365, 200, 25);
		
		lMessage.setBounds(230, 390, 200, 25);
		lMessage.setForeground(new Color(246, 71, 71));
		
		bAdd.setBounds(330, 435, 100, 25);
		bAdd.setBackground(new Color(35, 203, 167));
        bAdd.setForeground(new Color(240, 240, 240));
        bAdd.setBorder(new RoundedBorder(12));
        
        bAdd2.setBounds(300, 435, 130, 25);
		bAdd2.setBackground(new Color(35, 203, 167));
        bAdd2.setForeground(new Color(240, 240, 240));
        bAdd2.setBorder(new RoundedBorder(12));
        
        bBack.setBounds(50, 435, 100, 25);
        bBack.setBackground(new Color(246, 71, 71));
        bBack.setForeground(new Color(240, 240, 240));
        bBack.setBorder(new RoundedBorder(12));
	}
	
	public void setAddToComponentsToContainer() {
		container.add(pHead);
		container.add(lTitle);
		container.add(lJobTitle);
		container.add(tJobTitle);
		container.add(lDesc);
		container.add(tDesc);
		container.add(lCompanyName);
		container.add(tCompanyName);
		container.add(lLocation);
		container.add(cLocation);
		container.add(lKeySkill);
		container.add(tKeySkill);
		container.add(lSalary);
		container.add(tSalary);
		container.add(bAdd);
		container.add(bAdd2);
		container.add(bBack);
		container.add(lMessage);
	}
}
