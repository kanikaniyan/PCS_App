package view;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import controller.EmployeeController;
import model.Employee;

import javax.swing.JScrollPane;

public class AllEmpFrame extends JFrame{
	
	private static final long serialVersionUID = 1L;
	JTable table;
	EmployeeController empController=null;
	DefaultTableModel tableModel=null;
	
	public AllEmpFrame() 
	{
		try {
			
			empController=new EmployeeController();
			
			List<Employee> empl= empController.getAllEmployees();
			List<Employee> emplSorted=new ArrayList<Employee>();
			
			tableModel=new DefaultTableModel();
			JTable table=new JTable(tableModel);
			table.setPreferredScrollableViewportSize(table.getPreferredSize());
			
			tableModel.addColumn("Employee ID");
			tableModel.addColumn("First Name");
			tableModel.addColumn("Last Name");
			tableModel.addColumn("UserID");
			tableModel.addColumn("Password");
			tableModel.addColumn("Gender");
			tableModel.addColumn("Phone Number");
			tableModel.addColumn("Role");
			tableModel.addColumn("Active");
			
			for (int i = empl.size()-1; i >= 0; i--) {
				emplSorted.add(empl.get(i));
			}
			
			for (Employee emp:emplSorted) {
				displayEmp(emp);
			}
			
			DefaultTableCellRenderer dtcr = (DefaultTableCellRenderer) table.getDefaultRenderer(String.class);
			 dtcr.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
			 
			 table.getColumnModel().getColumn(0).setPreferredWidth(60);
			 table.getColumnModel().getColumn(3).setPreferredWidth(140);
		     table.getColumnModel().getColumn(4).setPreferredWidth(125);
		     table.getColumnModel().getColumn(5).setPreferredWidth(50);
		     table.getColumnModel().getColumn(7).setPreferredWidth(50);
		     table.getColumnModel().getColumn(8).setPreferredWidth(50);
		     table.setRowHeight(25);
		     
		     table.setDefaultEditor(Object.class, null);
		     
			this.add(new JScrollPane(table));
			table=new JTable();
			this.setTitle("table");
			this.setBounds(10,10,900,250);
			this.setVisible(true);			this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			
	} catch (Exception e) {
		e.printStackTrace();
	}
		
	}  
	
	public void displayEmp(Employee emp){
			tableModel.insertRow(0, new Object[] { emp.getEmployeeID(), emp.getFirstName(), emp.getLastName(), emp.getUserID(), emp.getPassword(), emp.getGender(), emp.getPhoneNumber(), emp.getRole(), emp.getActive() });	
	}
	
}

