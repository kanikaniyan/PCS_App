package empPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.JobController;
import model.Employee;
import model.Job;
import view.AllJobFrame;
import view.RoundedBorder;

public class TabPanel4 extends JPanel{
	private static final long serialVersionUID = 1L;
	JPanel bPanel, cPanel;
	JLabel lJobID;
	JTextField tJobID;
	JButton b1, b2;
	JFrame jpane;
	JobController jbController=null;
	
	public TabPanel4(Employee emp) throws ClassNotFoundException, SQLException {
		
		jpane=new JFrame();
		
		//bPanel
		bPanel=new JPanel();
		b1=new JButton("Click here to see available jobs");
		
		bPanel.setLayout(new BoxLayout(bPanel, BoxLayout.PAGE_AXIS));
		bPanel.add(b1);
		b1.setPreferredSize(new Dimension(200,25));
		bPanel.setBorder(new EmptyBorder(new Insets(50, 200, 50, 200)));
		bPanel.setBackground(Color.LIGHT_GRAY);
		b1.setBackground(new Color(35, 203, 167));
		b1.setForeground(new Color(50, 56, 52));
		b1.setBorder(new RoundedBorder(12));
		
		this.add(bPanel);
		
		//cPanel
		cPanel=new JPanel();
		lJobID=new JLabel("Enter the Job ID to apply: ");
		tJobID=new JTextField(10);
		b2=new JButton("Apply");
		
		b2.setPreferredSize(new Dimension(110,25));
		b2.setBackground(new Color(35, 203, 167));
		b2.setForeground(new Color(50, 56, 52));
		b2.setBorder(new RoundedBorder(12));
		
		cPanel.setLayout(new BoxLayout(cPanel, BoxLayout.LINE_AXIS));
		cPanel.add(lJobID);
		cPanel.add(Box.createRigidArea(new Dimension(25, 0)));
		cPanel.add(tJobID);
		cPanel.add(Box.createRigidArea(new Dimension(25, 0)));
		cPanel.add(b2);
		cPanel.setBackground(Color.LIGHT_GRAY);

		cPanel.setBorder(new EmptyBorder(new Insets(50, 200, 50, 200)));
		
		this.add(cPanel);
		
		jbController=new JobController();
		
		b1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					new AllJobFrame();
				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}
			}
			
		});
		
		b2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (tJobID.getText().isEmpty()) {
					JOptionPane.showMessageDialog(jpane, "Fill the Field to Apply!");
				}
				
				else {
					if (tJobID.getText().matches("[1-9]{3}")) {
						int jbid=Integer.parseInt(tJobID.getText());
						int empid=emp.getEmployeeID();
						Job job= jbController.getJobById(jbid);
						
						if(job!=null) {
							jbController.applyJob(job, empid);
						}
					}
					else {
						JOptionPane.showMessageDialog(jpane, "ID doesn't matches!");
					}
				}
			}
			
		});
	}
}
