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
import model.EmpJob;

	
public class RecruitedEmp extends JFrame{

		private static final long serialVersionUID = 1L;
		JTable table;
		JobController jobController=null;
		DefaultTableModel tableModel=null;
		public RecruitedEmp() throws ClassNotFoundException, SQLException {
			
			jobController=new JobController();
			
			List<EmpJob> empjobl= jobController.RecruitedEmp();
			List<EmpJob> empjoblSorted=new ArrayList<EmpJob>();
			
			tableModel=new DefaultTableModel();
			table=new JTable(tableModel);
			table.setPreferredScrollableViewportSize(table.getPreferredSize());
			
			tableModel.addColumn("EmployeeJob ID");
			tableModel.addColumn("Employee ID");
			tableModel.addColumn("Job ID");
			tableModel.addColumn("Recruited");
			
			for (int i = empjobl.size()-1; i >= 0; i--) {
				empjoblSorted.add(empjobl.get(i));
			}
			
			for (EmpJob empjob:empjoblSorted) {
				displayJob(empjob);
			}
			
			DefaultTableCellRenderer dtcr = (DefaultTableCellRenderer) table.getDefaultRenderer(String.class);
			 dtcr.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
			
			 table.getColumnModel().getColumn(0).setPreferredWidth(70);
			 table.getColumnModel().getColumn(1).setPreferredWidth(70);
			 table.getColumnModel().getColumn(2).setPreferredWidth(70);
		     table.getColumnModel().getColumn(3).setPreferredWidth(150);
		    
		     table.setRowHeight(25);
		     
		     table.setDefaultEditor(Object.class, null);
		     
			this.add(new JScrollPane(table));
			table=new JTable();
			this.setTitle("table");
			this.setBounds(10,10,500,350);
			this.setVisible(true);
			this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		}
		
		public void displayJob(EmpJob empjob){
			tableModel.insertRow(0, new Object[] { empjob.getEJID(), empjob.getEmployeeID(), empjob.getJobID(), empjob.getRecruited() });	
		}

}
