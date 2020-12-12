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
import model.Applyjob;

public class JobApplied extends JFrame{
	private static final long serialVersionUID = 1L;
	
	JTable table;
	JobController jobController=null;
	static DefaultTableModel tableModel=null;
	public JobApplied() throws ClassNotFoundException, SQLException {
		
		jobController=new JobController();
		
		List<Applyjob> appliedJobList=jobController.getAllAppliedJobs();
		List<Applyjob> appliedJobListsorted=new ArrayList<Applyjob>();
		
		tableModel=new DefaultTableModel();
		table=new JTable(tableModel);
		table.setPreferredScrollableViewportSize(table.getPreferredSize());
		
		tableModel.addColumn("Application ID");
		tableModel.addColumn("Employee ID");
		tableModel.addColumn("Name");
		tableModel.addColumn("Job ID");
		tableModel.addColumn("Job Name");
		tableModel.addColumn("Status");
		
		for (int i = appliedJobList.size()-1; i >= 0; i--) {
			appliedJobListsorted.add(appliedJobList.get(i));
		}
		
		for (Applyjob apjob:appliedJobListsorted) {
			displayJob(apjob);
		}
		
		DefaultTableCellRenderer dtcr = (DefaultTableCellRenderer) table.getDefaultRenderer(String.class);
		 dtcr.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);

	     table.setRowHeight(22);
	     
	     table.setDefaultEditor(Object.class, null);
	     
		this.add(new JScrollPane(table));
		table=new JTable();
		this.setTitle("table");
		this.setBounds(10,10,1100,350);
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
	public void displayJob(Applyjob apjob){
		tableModel.insertRow(0, new Object[] { apjob.getApplicationID(), apjob.getEmployeeID(), apjob.getEmpName(), apjob.getJobID(), apjob.getJobName(), apjob.getStatus()});	
	}
}
