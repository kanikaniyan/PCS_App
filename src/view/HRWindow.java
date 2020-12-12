package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.SQLException;
import javax.swing.*;

import HRPanel.MainPanel;
import HRPanel.Panel1;
import HRPanel.Panel5;
import HRPanel.Panel6;
import controller.EmployeeController;
import controller.SkillController;
import model.Employee;

public class HRWindow extends JFrame{
	
	private static final long serialVersionUID = 1L;
	Container container=null;
	JLabel lHead, lTitle, lMessage;
	JButton bNext, bLogout, bBack, bActive, bDeactive, bActive1, bDeactive1, bDelete, bDelete1, bAdd, bRecruited;
	JPanel pHead;
	Panel1 panel1, panel2, panel3, panel4;
	Panel5 panel5;
	Panel6 panel6;
		
	EmployeeController empController=null;
	SkillController sklController=null;
	public HRWindow(Employee emp) throws ClassNotFoundException, SQLException {
		container =getContentPane();
		
		lHead=new JLabel("HR's View");
		pHead=new JPanel();
		pHead.add(lHead);
		lTitle=new JLabel("Welcome Mr. "+emp.getFirstName()+" To the portal!");
		lMessage=new JLabel();
		
		bNext= new JButton("Next");
		bLogout= new JButton("Logout");
		bBack= new JButton("Back");
		bActive= new JButton("Activate");
		bDeactive= new JButton("Deactivate");
		bActive1= new JButton("Active");
		bDeactive1= new JButton("Deactive");
		bDelete= new JButton("Delete");
		bDelete1= new JButton("Delete");
		bAdd= new JButton("Add");
		bRecruited=new JButton("Recruited Employees");
		
		bBack.setVisible(false);
		bActive.setVisible(false);
		bDeactive.setVisible(false);
		bActive1.setVisible(false);
		bDeactive1.setVisible(false);
		bDelete.setVisible(false);
		bDelete1.setVisible(false);
		bAdd.setVisible(false);
		bRecruited.setVisible(false);
		
		panel1=new Panel1("Enter the Employee ID to Take Action: ");
		add(panel1);
		panel1.setVisible(false);
		
		panel2=new Panel1("Enter the Employee ID to Delete: ");
		add(panel2);
		panel2.setVisible(false);
		
		panel3=new Panel1("Enter the Skill ID to take Action: ");
		add(panel3);
		panel3.setVisible(false);
		
		panel4=new Panel1("Enter the Skill ID to Delete: ");
		add(panel4);
		panel4.setVisible(false);
		
		panel5=new Panel5();
		add(panel5);
		panel5.setVisible(false);
		
		panel6=new Panel6();
		add(panel6);
		panel6.setVisible(false);
		
		MainPanel panel=new MainPanel();
		add(panel);
		
		empController =new EmployeeController();
		sklController =new SkillController();
		
		bNext.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				panel1.setVisible(false);
				panel2.setVisible(false);
				panel3.setVisible(false);
				panel4.setVisible(false);
				panel5.setVisible(false);
				panel6.setVisible(false);
				bNext.setVisible(false);
				bDelete.setVisible(false);
				bBack.setBounds(30, 390, 100, 25);
				lMessage.setText(null);
				if(panel.lActDeEmp.isSelected()) {
					
					panel.setVisible(false);
					panel1.setVisible(true);
					
					bBack.setVisible(true);
					
				}
				
				else if (panel.lDeleteEmp.isSelected()) {
					
					panel.setVisible(false);
					panel2.setVisible(true);
					
					bBack.setVisible(true);
				}
				else if (panel.lAllEmp.isSelected()) {
					new AllEmpFrame();
					bNext.setVisible(true);
				}
				else if (panel.lAppEmp.isSelected()) {
					panel.setVisible(false);
					panel6.setVisible(true);
					bRecruited.setVisible(true);
					bBack.setVisible(true);
				}
				else if (panel.lAddSkill.isSelected()) {
					panel.setVisible(false);
					panel5.setVisible(true);
					
					bBack.setVisible(true);
				}
				else if (panel.lAllSkill.isSelected()) {
					new AllSkillFrame();
					bNext.setVisible(true);
				}
				else if (panel.lActDeSkill.isSelected()) {
					panel.setVisible(false);
					panel3.setVisible(true);
					
					bBack.setVisible(true);
				}
				else if (panel.lDeleteSkill.isSelected()) {
					panel.setVisible(false);
					panel4.setVisible(true);
					
					bBack.setVisible(true);
				}
				
				else if (panel.buttonGroup.getSelection()==null) {
					lMessage.setText("* select an option to continue !!");
				}
					
			}
			
		});
		
		bLogout.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				JFrame jpane = new JFrame();
				int option=JOptionPane.showConfirmDialog(jpane, "Do you want to logout!", "Confirmation Message", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
				if (option==JOptionPane.YES_OPTION) {
					try {
						dispose();
						new LoginFrame();
					} catch (ClassNotFoundException | SQLException e) {
						e.printStackTrace();
					}
				}
			}
			
		});
		
		bBack.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				bBack.setVisible(false);
				panel1.setVisible(false);
				panel2.setVisible(false);
				panel3.setVisible(false);
				panel4.setVisible(false);
				panel5.setVisible(false);
				panel6.setVisible(false);
				bRecruited.setVisible(false);
				bNext.setVisible(true);
				panel.setVisible(true);
				lMessage.setText(null);
			}
			
		});
		
		//panel1
		
		panel1.tID.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent arg0) {
				bActive.setVisible(true);
				bDeactive.setVisible(true);
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				bActive.setVisible(false);
				bDeactive.setVisible(false);
			}
			
		});
		
		bActive.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(panel1.tID.getText().isEmpty()) {
					lMessage.setText("Enter the ID");
				}
				else {
					lMessage.setText(null);
					if (panel1.tID.getText().matches("[0-9]{3}")) {
						
						connectDBActEmp("1");
					}
					else {
					lMessage.setText("id doesn't match !");
					}
				}
			}
			
		});
		
		bDeactive.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(panel1.tID.getText().isEmpty()) {
					lMessage.setText("Enter the ID");
				}
				else {
					lMessage.setText(null);
					if (panel1.tID.getText().matches("[0-9]{3}")) {
						
						connectDBActEmp("2");
					}
					else {
					lMessage.setText("id doesn't match !");
					}
				}
			}
			
		});
		
		//panel2
		
		panel2.tID.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent arg0) {
				bDelete.setVisible(true);
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				bDelete.setVisible(false);
			}
			
		});
		
		bDelete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(panel2.tID.getText().isEmpty()) {
					lMessage.setText("Enter the ID");
				}
				else {
					lMessage.setText(null);
					if (panel2.tID.getText().matches("[0-9]{3}")) {
						
						connectDBDelEmp();
					}
					else {
					lMessage.setText("id doesn't match !");
					}
				}
			}
			
		});
		
		//panel3
		
		panel3.tID.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent arg0) {
				bActive1.setVisible(true);
				bDeactive1.setVisible(true);
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				bActive1.setVisible(false);
				bDeactive1.setVisible(false);
			}
			
		});
		
		bActive1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(panel3.tID.getText().isEmpty()) {
					lMessage.setText("Enter the ID");
				}
				else {
					lMessage.setText(null);
					if (panel3.tID.getText().matches("[0-9]{3}")) {
						
						connectDBActSkill("1");
					}
					else {
					lMessage.setText("id doesn't match !");
					}
				}
			}
			
		});
		
		bDeactive1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(panel3.tID.getText().isEmpty()) {
					lMessage.setText("Enter the ID");
				}
				else {
					lMessage.setText(null);
					if (panel3.tID.getText().matches("[0-9]{3}")) {
						
						connectDBActSkill("2");
					}
					else {
					lMessage.setText("id doesn't match !");
					}
				}
			}
			
		});
		
		//panel4
		
		panel4.tID.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent arg0) {
				bDelete1.setVisible(true);
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				bDelete1.setVisible(false);
			}
			
		});
		
		bDelete1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(panel4.tID.getText().isEmpty()) {
					lMessage.setText("Enter the ID");
				}
				else {
					lMessage.setText(null);
					if (panel4.tID.getText().matches("[0-9]{3}")) {
						connectDBDelSkill();
					}
					else {
					lMessage.setText("id doesn't match !");
					}
				}
			}
			
		});
		
		panel5.tSkillDesc.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent arg0) {
				bAdd.setVisible(true);
				
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				bAdd.setVisible(false);				
			}
			
		});
		
		//panel5
		bAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				lMessage.setText(null);
				if (panel5.tSkillName.getText().isEmpty() || panel5.tSkillDesc.getText().isEmpty()) {
					lMessage.setText("Enter the Details");
				}
				else {
					connectDBAddSkill();
				}
			}
			
		});
		
		//panel6
		bRecruited.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					new RecruitedEmp();
				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}
			}
			
		});
		
		setLayoutManager();
		setLocationAndSize();
		addComponentsToContainer();
		
		this.setTitle("HR WINDOW");
		this.setVisible(true);
		this.setBounds(10, 10, 500, 490);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
	
	}
	
	public void connectDBActEmp(String num) {
		String empid, opt;
		empid=panel1.tID.getText();
		opt=num;
		empController.deactivateEmployee(empid, opt);
		
	}
	
	public void connectDBDelEmp() {
		String empid;
		empid=panel2.tID.getText();
		empController.deleteEmployee(empid);
	}
	
	public void connectDBActSkill(String num) {
		String empid;
		empid=panel3.tID.getText();
		sklController.deactivateSkill(empid, num);
	}
	
	public void connectDBDelSkill() {
		String empid;
		empid=panel4.tID.getText();
		sklController.deleteSkill(empid);
	}
	
	public void connectDBAddSkill() {
		String skillName, skillDesc;
		skillName=panel5.tSkillName.getText();
		skillDesc=panel5.tSkillDesc.getText();
		sklController.addSkill(skillName, skillDesc);
	}
	
	public void setLayoutManager() {
		container.setLayout(null);
	}
	
	public void setLocationAndSize() {
		pHead.setBounds(0, 20, 500, 50);
		
		lHead.setFont(new java.awt.Font("Tahoma", 1, 18));
		lHead.setForeground(new java.awt.Color(255, 255, 255));
		pHead.setBackground(new java.awt.Color(243, 156, 18));
		
		lTitle.setBounds(30, 70, 300, 50);
		lTitle.setFont(new java.awt.Font("Tahoma", 1, 12));
		
		lMessage.setBounds(280, 385, 200, 35);
		lMessage.setForeground(new Color(246, 71, 71));

		bLogout.setBounds(370, 80, 100, 25);
		bLogout.setBackground(new Color(246, 71, 71));
        bLogout.setForeground(new Color(240, 240, 240));
        bLogout.setBorder(new RoundedBorder(12));
        
        bActive.setBounds(30, 220, 100, 25);
        bActive.setBackground(new Color(35, 203, 167));
        bActive.setForeground(new Color(240, 240, 240));
        bActive.setBorder(new RoundedBorder(12));
        
        bDeactive.setBounds(250, 220, 100,25);
        bDeactive.setBackground(new Color(246, 71, 71));
        bDeactive.setForeground(new Color(240, 240, 240));
        bDeactive.setBorder(new RoundedBorder(12));
        
        bActive1.setBounds(30, 220, 100, 25);
        bActive1.setBackground(new Color(35, 203, 167));
        bActive1.setForeground(new Color(240, 240, 240));
        bActive1.setBorder(new RoundedBorder(12));
        
        bDeactive1.setBounds(250, 220, 100,25);
        bDeactive1.setBackground(new Color(246, 71, 71));
        bDeactive1.setForeground(new Color(240, 240, 240));
        bDeactive1.setBorder(new RoundedBorder(12));
        
        bBack.setBackground(new Color(246, 71, 71));
        bBack.setForeground(new Color(240, 240, 240));
        bBack.setBorder(new RoundedBorder(12));
        
		bNext.setBounds(30, 390, 100, 25);
		bNext.setBackground(new Color(35, 203, 167));
        bNext.setForeground(new Color(240, 240, 240));
        bNext.setBorder(new RoundedBorder(12));
        
        bRecruited.setBounds(300, 390, 150, 25);
		bRecruited.setBackground(new Color(35, 203, 167));
        bRecruited.setForeground(new Color(240, 240, 240));
        bRecruited.setBorder(new RoundedBorder(12));
        
        bDelete.setBounds(250, 220, 100,25);
        bDelete.setBackground(new Color(246, 71, 71));
        bDelete.setForeground(new Color(240, 240, 240));
        bDelete.setBorder(new RoundedBorder(12));
        
        bDelete1.setBounds(250, 220, 100,25);
        bDelete1.setBackground(new Color(246, 71, 71));
        bDelete1.setForeground(new Color(240, 240, 240));
        bDelete1.setBorder(new RoundedBorder(12));
        
        bAdd.setBounds(250, 300, 100, 25);
		bAdd.setBackground(new Color(35, 203, 167));
        bAdd.setForeground(new Color(240, 240, 240));
        bAdd.setBorder(new RoundedBorder(12));
	}
	
	public void addComponentsToContainer() {
		container.add(pHead);
		container.add(lTitle);
		container.add(lMessage);
		container.add(bLogout);
		container.add(bNext);
		container.add(bBack);
		container.add(bActive);
		container.add(bDeactive);
		container.add(bActive1);
		container.add(bDeactive1);
		container.add(bDelete);
		container.add(bDelete1);
		container.add(bAdd);
		container.add(bRecruited);
	}
}
