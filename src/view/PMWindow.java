package view;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.SQLException;
import javax.swing.*;

import controller.JobController;
import model.Employee;
import pmPanel.MainPanel;
import pmPanel.Panel2;

public class PMWindow extends JFrame{
	
	private static final long serialVersionUID = 1L;
	Container container=null;
	JLabel lHead, lTitle, lMessage;
	JButton bNext, bLogout, bBack, bActive, bDeactive, bDelete, bView, bAdd;
	JPanel pHead;
	Panel2 panel1, panel2, panel3;
	JobController jobController=null;
	
	public PMWindow(Employee emp) throws ClassNotFoundException, SQLException {
		container =getContentPane();
		
		lHead=new JLabel("PM's View");
		pHead=new JPanel();
		pHead.add(lHead);
		lTitle=new JLabel("Welcome Mr."+emp.getFirstName()+" To the portal!");
		lMessage=new JLabel();
		
		bNext= new JButton("Next");
		bLogout= new JButton("Logout");
		bBack= new JButton("Back");
		
		bActive=new JButton("Active");
		bDeactive=new JButton("Deactive");
		
		bDelete=new JButton("Delete");
		
		bView=new JButton("View");
		
		bActive.setVisible(false);
		bDeactive.setVisible(false);
		bDelete.setVisible(false);
		bView.setVisible(false);
		bBack.setVisible(false);
		
		MainPanel panel=new MainPanel();
		add(panel);
		
		panel1=new Panel2("Enter the Skill name to search: ");
		add(panel1);
		panel1.setVisible(false);
		
		panel2=new Panel2("Enter the Job ID to Take Action: ");
		add(panel2);
		panel2.setVisible(false);
		
		panel3=new Panel2("Enter the Job ID to Delete: ");
		add(panel3);
		panel3.setVisible(false);
		
		jobController=new JobController();
		
		bNext.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				panel.setVisible(false);
				bBack.setBounds(30, 390, 100, 25);
				bNext.setVisible(false);
				bBack.setVisible(true);
				lMessage.setText(null);
				if (panel.lAddJob.isSelected()) {
					panel.setVisible(false);
					bBack.setVisible(true);
					dispose();
					try {
						new AddJob(emp);
						panel.setVisible(true);
						bNext.setVisible(true);
	
					} catch (ClassNotFoundException | SQLException e) {
						e.printStackTrace();
					}
				}
				else if(panel.lAllJob.isSelected()) {
					
					try {
						new AllJobFrame();
						panel.setVisible(true);
						bNext.setVisible(true);
					} catch (ClassNotFoundException | SQLException e) {
						e.printStackTrace();
					}
				}
				else if (panel.lSkillwJob.isSelected()) {
					panel1.setVisible(true);
					
				}
				else if(panel.lAppliedEmp.isSelected()) {
					try {
						new JobApplied();
						panel.setVisible(true);
						bNext.setVisible(true);
						
					} catch (ClassNotFoundException | SQLException e) {
						e.printStackTrace();
					}
				}
				else if (panel.lDeaJob.isSelected()) {
					panel2.setVisible(true);
					
				}
				else if(panel.lDeleteJob.isSelected()) {
					panel3.setVisible(true);
				}
				else {
					lMessage.setText("Select one option!");
				}
				
			}
			
		});
		
		//panel1
		panel1.tID.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent arg0) {
				bView.setVisible(true);
				
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				bView.setVisible(false);
				
			}
			
		});
		
		bView.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(panel1.tID.getText().isEmpty()) {
					lMessage.setText("Enter the ID");
				}
				else {
					lMessage.setText(null);
					try {
						connectDBViewJob();
					} catch (ClassNotFoundException | SQLException e) {
						e.printStackTrace();
					  }
				}
			}
		});
		
		//panel2
		panel2.tID.addFocusListener(new FocusListener() {

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
				if (panel2.tID.getText().isEmpty()) {
					lMessage.setText("Enter the ID");
				}
				else {
					lMessage.setText(null);
					if(panel2.tID.getText().matches("[0-9]{3}")) {
						connectDBActJob("1");
					}
					else {
						lMessage.setText("Id doestn't match!");
					}
				}
				
			}
			
		});
		
		bDeactive.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (panel2.tID.getText().isEmpty()) {
					lMessage.setText("Enter the ID");
				}
				else {
					lMessage.setText(null);
					if(panel2.tID.getText().matches("[0-9]{3}")) {
						connectDBActJob("2");
					}
					else {
						lMessage.setText("Id doestn't match!");
					}
				}
				
			}
			
		});
		
		//panel3
		
		panel3.tID.addFocusListener(new FocusListener() {

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
			public void actionPerformed(ActionEvent arg0) {
				if (panel3.tID.getText().isEmpty()) {
					lMessage.setText("Enter the ID");
				}
				else {
					lMessage.setText(null);
					if(panel3.tID.getText().matches("[0-9]{3}")) {
						connectDBDelJob();
					}
					else {
						lMessage.setText("Id doestn't match!");
					}
				}
				
			}
			
		});
		
		
		bLogout.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				JFrame jpane = new JFrame();
				int option=JOptionPane.showConfirmDialog(jpane, "Do you want to logout !", "Confirmation Message", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
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
				
				bNext.setVisible(true);
				panel.setVisible(true);
				lMessage.setText(null);
			}
			
		});
		
		setLayoutManager();
		setLocationAndSize();
		addComponentsToContainer();
		
		this.setTitle("PM WINDOW");
		this.setVisible(true);
		this.setBounds(10, 10, 500, 490);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
	}
	
	public void connectDBViewJob() throws ClassNotFoundException, SQLException {
		String skill;
		skill=panel1.tID.getText();
		new SortedJobFrame(skill);
	}
	
	public void connectDBActJob(String opt) {
		String jobid;
		jobid=panel2.tID.getText();
		jobController.deactivateJob(jobid, opt);
	}
	
	public void connectDBDelJob() {
		String jobid;
		jobid=panel3.tID.getText();
		jobController.deleteJob(jobid);
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
		
		bLogout.setBounds(370, 80, 100, 25);
		bLogout.setBackground(new Color(246, 71, 71));
        bLogout.setForeground(new Color(240, 240, 240));
        bLogout.setBorder(new RoundedBorder(12));
		
		bNext.setBounds(30, 390, 100, 25);
		bNext.setBackground(new Color(35, 203, 167));
        bNext.setForeground(new Color(240, 240, 240));
        bNext.setBorder(new RoundedBorder(12));
        
        bBack.setBounds(30, 390, 100, 25);
        bBack.setBackground(new Color(246, 71, 71));
        bBack.setForeground(new Color(240, 240, 240));
        bBack.setBorder(new RoundedBorder(12));
        
        bActive.setBounds(50, 220, 100, 25);
        bActive.setBackground(new Color(35, 203, 167));
        bActive.setForeground(new Color(240, 240, 240));
        bActive.setBorder(new RoundedBorder(12));
        
        bDeactive.setBounds(230, 220, 100,25);
        bDeactive.setBackground(new Color(246, 71, 71));
        bDeactive.setForeground(new Color(240, 240, 240));
        bDeactive.setBorder(new RoundedBorder(12));
        
        bDelete.setBounds(211, 220, 100,25);
        bDelete.setBackground(new Color(246, 71, 71));
        bDelete.setForeground(new Color(240, 240, 240));
        bDelete.setBorder(new RoundedBorder(12));
        
        bView.setBounds(230, 220, 100,25);
        bView.setBackground(new Color(246, 71, 71));
        bView.setForeground(new Color(240, 240, 240));
        bView.setBorder(new RoundedBorder(12));
   
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
		container.add(bDelete);
		container.add(bView);
	}	
}