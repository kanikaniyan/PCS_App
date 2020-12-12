package view;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import controller.JobController;
import model.Job;

public class SortedJobFrame extends JFrame{

	private static final long serialVersionUID = 1L;
	JobController jobController=null;
	DefaultTableModel tableModel=null;
	JFrame jpane;
	
	public SortedJobFrame(String skill) throws ClassNotFoundException, SQLException {
		
		JTable table;
		jpane=new JFrame();
		jobController=new JobController();
		List<Job> sortedJobList= jobController.skillWiseJob(skill);
		
		tableModel=new DefaultTableModel();
		table=new JTable(tableModel);
		table.setPreferredScrollableViewportSize(table.getPreferredSize());
		
		tableModel.addColumn("Job ID");
		tableModel.addColumn("Job Title");
		tableModel.addColumn("Job Description");
		tableModel.addColumn("Company Name");
		tableModel.addColumn("Location");
		tableModel.addColumn("Key Skill");
		tableModel.addColumn("Salary");
		tableModel.addColumn("Active");
			
		if(sortedJobList.isEmpty()) {
			
			JOptionPane.showMessageDialog(jpane, "no data found!", "Alert!!", JOptionPane.WARNING_MESSAGE);
			
		}
		else {
			for (Job job:sortedJobList) {
				this.setVisible(true);
				displayJob(job);
			}
		}
		
		DefaultTableCellRenderer dtcr = (DefaultTableCellRenderer) table.getDefaultRenderer(String.class);
		dtcr.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
			
		table.getColumnModel().getColumn(0).setPreferredWidth(70);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.getColumnModel().getColumn(2).setPreferredWidth(300);
		table.getColumnModel().getColumn(3).setPreferredWidth(200);
		table.getColumnModel().getColumn(4).setPreferredWidth(100);
		table.getColumnModel().getColumn(5).setPreferredWidth(130);
		table.getColumnModel().getColumn(6).setPreferredWidth(80);
		table.getColumnModel().getColumn(7).setPreferredWidth(70);
		table.setRowHeight(25);
		     
		table.setDefaultEditor(Object.class, null);
		     
		this.add(new JScrollPane(table));
		table=new JTable();
		this.setTitle("table");
		this.setBounds(10,10,1100,350);
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
		
	public void displayJob(Job job){
		tableModel.insertRow(0, new Object[] { job.getJobID(), job.getJobTitle(), job.getJobDescription(), job.getCompanyName(), job.getLocation(), job.getKeySkill(), job.getSalary(), job.getActive() });	
	}
	
}
