package view;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import controller.JobController;
import model.Job;

public class AllJobFrame extends JFrame{

	private static final long serialVersionUID = 1L;
	JTable table;
	JobController jobController=null;
	DefaultTableModel tableModel=null;
	public AllJobFrame() throws ClassNotFoundException, SQLException {
		
		jobController=new JobController();
		
		List<Job> jobl= jobController.getAllJobs();
		List<Job> joblSorted=new ArrayList<Job>();
		
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
		
		for (int i = jobl.size()-1; i >= 0; i--) {
			joblSorted.add(jobl.get(i));
		}
		
		for (Job job:joblSorted) {
			displayJob(job);
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
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
	public void displayJob(Job job){
		tableModel.insertRow(0, new Object[] { job.getJobID(), job.getJobTitle(), job.getJobDescription(), job.getCompanyName(), job.getLocation(), job.getKeySkill(), job.getSalary(), job.getActive() });	
	}

}
