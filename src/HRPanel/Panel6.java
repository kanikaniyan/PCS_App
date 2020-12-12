package HRPanel;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.JobController;
import view.JobApplied;
import view.RoundedBorder;

public class Panel6 extends JPanel{

	private static final long serialVersionUID = 1L;
	
	JLabel lempID, lEmpty, lEmpty1;
	public JTextField tempID;
	public JButton bSeeJob, bRecruit;
	
	JFrame jpane = new JFrame();
	JobController jbController=null;
	
	public Panel6() throws ClassNotFoundException, SQLException {
		
		bSeeJob=new JButton("Click to see Employees who appied for the job");
		bRecruit=new JButton("Recruit");
		lEmpty=new JLabel();
		lEmpty1=new JLabel();
		lempID=new JLabel("Enter the employee id to recruit: ");
		tempID=new JTextField(10);
		
		
		this.add(bSeeJob);
		this.add(lEmpty);
		this.add(lempID);
		this.add(tempID);
		this.add(lEmpty1);
		this.add(bRecruit);
		
		setLocationAndSize();
		this.setVisible(true);
		
		jbController = new JobController();
		
		bSeeJob.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
					try {
						new JobApplied();
					} catch (ClassNotFoundException | SQLException e) {
						e.printStackTrace();
					}
			}
			
		});
		
		bRecruit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (tempID.getText().isEmpty()) {
					JOptionPane.showMessageDialog(jpane, "Fill the Field to Apply!");
				}
						
				else {
					if (tempID.getText().matches("[1-9]{3}")) {
						int empid=Integer.parseInt(tempID.getText());
						jbController.empJob(empid, "Yes");
					}
					else {
						JOptionPane.showMessageDialog(jpane, "ID doesn't matches!");
					}
				}
			}
			
		});
		
	}
	
	public void setLocationAndSize() {
		this.setBounds(20, 150, 300, 200);
		
		bRecruit.setPreferredSize(new Dimension(110,25));
		bSeeJob.setPreferredSize(new Dimension(300,25));
		
		lEmpty1.setPreferredSize(new Dimension(200,15));
		lEmpty.setPreferredSize(new Dimension(200,25));
		tempID.setPreferredSize(new Dimension(50,25));
		
		bRecruit.setBackground(new Color(35, 203, 167));
		bRecruit.setForeground(new Color(50, 56, 52));
		bRecruit.setBorder(new RoundedBorder(12));
		
		bSeeJob.setBackground(new Color(35, 203, 167));
		bSeeJob.setForeground(new Color(50, 56, 52));
		bSeeJob.setBorder(new RoundedBorder(12));
		
		bSeeJob.setAlignmentX(Component.LEFT_ALIGNMENT);
		lempID.setAlignmentX(Component.LEFT_ALIGNMENT);
		tempID.setAlignmentX(Component.LEFT_ALIGNMENT);
		
	}
	
}	














































//package HRPanel;
//
//import java.awt.Color;
//import java.awt.Dimension;
//import java.awt.Insets;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.sql.SQLException;
//
//import javax.swing.Box;
//import javax.swing.BoxLayout;
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JOptionPane;
//import javax.swing.JPanel;
//import javax.swing.JTextField;
//import javax.swing.border.EmptyBorder;
//
//import controller.JobController;
//import view.JobApplied;
//import view.RoundedBorder;
//
//public class Panel6 extends JPanel{
//
//	private static final long serialVersionUID = 1L;
//	JPanel bPanel, cPanel;
//	JLabel lEmpID;
//	JTextField tEmpID;
//	JButton b1, b2;
//	JFrame jpane;
//	JobController jbController=null;
//	public Panel6() throws ClassNotFoundException, SQLException {
//	
//		jpane=new JFrame();
//			
//			//bPanel
//			bPanel=new JPanel();
//			b1=new JButton("Click here to see Employees who appied for the job");
//			
//			bPanel.setLayout(new BoxLayout(bPanel, BoxLayout.PAGE_AXIS));
//			bPanel.add(b1);
//			b1.setPreferredSize(new Dimension(200,25));
//			bPanel.setBorder(new EmptyBorder(new Insets(50, 200, 50, 200)));
//			bPanel.setBackground(Color.LIGHT_GRAY);
//			b1.setBackground(new Color(35, 203, 167));
//			b1.setForeground(new Color(50, 56, 52));
//			b1.setBorder(new RoundedBorder(12));
//			
//			this.add(bPanel);
//			
//			//cPanel
//			cPanel=new JPanel();
//			lEmpID=new JLabel("Enter the Employee ID to recriut an employee: ");
//			tEmpID=new JTextField(10);
//			b2=new JButton("Recruit");
//			
//			b2.setPreferredSize(new Dimension(110,25));
//			b2.setBackground(new Color(35, 203, 167));
//			b2.setForeground(new Color(50, 56, 52));
//			b2.setBorder(new RoundedBorder(12));
//			
//			cPanel.setLayout(new BoxLayout(cPanel, BoxLayout.LINE_AXIS));
//			cPanel.add(lEmpID);
//			cPanel.add(Box.createRigidArea(new Dimension(25, 0)));
//			cPanel.add(tEmpID);
//			cPanel.add(Box.createRigidArea(new Dimension(25, 0)));
//			cPanel.add(b2);
//			cPanel.setBackground(Color.LIGHT_GRAY);
//
//			cPanel.setBorder(new EmptyBorder(new Insets(50, 200, 50, 200)));
//			
//			this.add(cPanel);
//			
//			jbController=new JobController();
//			
//			b1.addActionListener(new ActionListener() {
//
//				@Override
//				public void actionPerformed(ActionEvent arg0) {
//					try {
//						new JobApplied();
//					} catch (ClassNotFoundException | SQLException e) {
//						e.printStackTrace();
//					}
//				}
//				
//			});
//			
//			b2.addActionListener(new ActionListener() {
//
//				@Override
//				public void actionPerformed(ActionEvent e) {
//					if (tEmpID.getText().isEmpty()) {
//						JOptionPane.showMessageDialog(jpane, "Fill the Field to Apply!");
//					}
//					
//					else {
//						if (tEmpID.getText().matches("[1-9]{3}")) {
//							int empid=Integer.parseInt(tEmpID.getText());
//							jbController.empJob(empid, "Recruited");
//						}
//						else {
//							JOptionPane.showMessageDialog(jpane, "ID doesn't matches!");
//						}
//					}
//				}
//				
//			});
//		}
//}
