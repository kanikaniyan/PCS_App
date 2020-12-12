package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import empPanel.TabPanel1;
import empPanel.TabPanel2;
import empPanel.TabPanel3;
import empPanel.TabPanel4;
import empPanel.TabPanel5;
import model.Employee;

public class EmpWindow extends JFrame{

	private static final long serialVersionUID = 1L;
	JLabel lHead, lTitle;
	JPanel pHead, tabPanel1, tabPanel2, tabPanel3, tabPanel4, tabPanel5;
	JTabbedPane tab;
	JFrame jpane =new JFrame();
	
	public EmpWindow(Employee emp) throws ClassNotFoundException, SQLException {
		
		lHead=new JLabel("Employee's View");
		lTitle=new JLabel();
		tabPanel1=new TabPanel1(emp);
		tabPanel2=new TabPanel2(emp);
		tabPanel3=new TabPanel3(emp);
		tabPanel4=new TabPanel4(emp);
		tabPanel5=new TabPanel5(emp);
		
		pHead=new JPanel();
		pHead.add(lHead);
		
		tab=new JTabbedPane(JTabbedPane.TOP);
		tab.addTab("View Profile", tabPanel1);
		tab.addTab("Update Profile", tabPanel2);
		tab.addTab("Update Skill", tabPanel3);
		tab.addTab("Apply Job", tabPanel4); 
		tab.addTab("Logout", tabPanel5);
		
		this.add(tab);
		this.add(pHead);
		this.add(lTitle);
		
		setLocationAndSize();
		this.setBounds(0, 0, 505, 478);
		this.setVisible(true);
		this.setLayout(null);
		this.setTitle("Employee Window");
		this.setResizable(false);
		
		TabPanel5.bLogout.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int opt=JOptionPane.showConfirmDialog(jpane,"Do you want to logout?","Confirmation message", JOptionPane.YES_NO_OPTION);
				if (opt==JOptionPane.YES_OPTION) {
					try {
						new LoginFrame();
					} catch (ClassNotFoundException | SQLException e) {
						e.printStackTrace();
					}
					dispose();
					
				}
				
				
			}
			
		});
	}
	
	public void setLocationAndSize() {
		
		lHead.setFont(new java.awt.Font("Tahoma", 1, 18));
		lHead.setForeground(new java.awt.Color(255, 255, 255));
		pHead.setBackground(new java.awt.Color(243, 156, 18));
		pHead.setBounds(0, 20, 500, 70);
		
		tab.setBounds(0, 60, 500, 390);
		
		tab.setBackground(new Color(35, 203, 167));
		tab.setForeground(new Color(50, 56, 52));
		
		tab.setBackgroundAt(4, new Color(246, 71, 71));
		tab.setForegroundAt(4, new Color(50, 56, 52));
	}
}
