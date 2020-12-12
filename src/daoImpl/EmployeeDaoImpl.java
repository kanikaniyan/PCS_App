package daoImpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import config.JDBCConnection;
import dao.IEmployeeDao;
import empPanel.TabPanel1;
import model.Employee;

public class EmployeeDaoImpl implements IEmployeeDao{

	Connection conn=null;
	public EmployeeDaoImpl() throws ClassNotFoundException, SQLException{
		conn=JDBCConnection.getDBConnection(); //Open connection
		conn.setAutoCommit(false);
	}
	
	public Employee checkLogin(String userId, String password) {
		Employee emp=new Employee();
		try{
			PreparedStatement pst=conn.prepareStatement("select * from Employee where userId=? and password=?");
			pst.setString(1, userId);
			pst.setString(2, password);
			ResultSet rst=pst.executeQuery();
			if(rst!=null) {
				if(rst.next()) {
					emp.setEmployeeID(rst.getInt(1));
					emp.setFirstName(rst.getString(2));
					emp.setLastName(rst.getString(3));
					emp.setUserID(rst.getString(4));
					emp.setPassword(rst.getString(5));
					emp.setGender(rst.getString(6));
					emp.setPhoneNumber(rst.getLong(7));
					emp.setRole(rst.getString(8));
					emp.setActive(rst.getString(9));
				}
			}
			conn.commit();
		}
		catch(SQLException ex) {
			try {
				conn.rollback();
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}	
		return emp;
	}
	JFrame jpane=new JFrame();
	
	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> allEmpList=new ArrayList<Employee>();
		try{
			Statement stmt=conn.createStatement();
			ResultSet rst=stmt.executeQuery("select * from Employee");
			conn.commit();
			if(rst!=null) {
				Employee emp= null;
				while(rst.next()) {
					emp=new Employee();
					emp.setEmployeeID(rst.getInt(1));
					emp.setFirstName(rst.getString(2));
					emp.setLastName(rst.getString(3));
					emp.setUserID(rst.getString(4));
					emp.setPassword(rst.getString(5)) ;
					emp.setGender(rst.getString(6));
					emp.setPhoneNumber(rst.getLong(7));
					emp.setRole(rst.getString(8));
					emp.setActive(rst.getString(9));
					allEmpList.add(emp);
				}
			}
		}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return allEmpList;
	}

	@Override
	public void addEmployee(Employee emp){
		try {
			//creating PreparedStatement object by passing query string
			PreparedStatement pst=conn.prepareStatement("insert into Employee(FirstName,LastName,UserID,Password,Gender,PhoneNumber,Role,Active) values(?,?,?,?,?,?,?,?)");
			pst.setString(1, emp.getFirstName());
			pst.setString(2, emp.getLastName());
			pst.setString(3, emp.getUserID());
			pst.setString(4, emp.getPassword());
			pst.setString(5, emp.getGender());
			pst.setLong(6, emp.getPhoneNumber());
			pst.setString(7, emp.getRole());
			pst.setString(8, emp.getActive());
			int i=pst.executeUpdate();
			conn.commit();
			if(i==1){
				JOptionPane.showMessageDialog(jpane, "Registered Successfully!!?", "Alert!!", JOptionPane.WARNING_MESSAGE);
			}
			else {
				JOptionPane.showMessageDialog(jpane, "Updation failed", "Alert!!", JOptionPane.WARNING_MESSAGE);
			}
		}
		catch(SQLException ex) {
			try {
				conn.rollback(); 
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public Employee getEmployeeById(int id) {
		Employee emp=new Employee();
		try{
			PreparedStatement pst=conn.prepareStatement("select * from Employee where EmployeeID=?");
			pst.setInt(1, id);
			ResultSet rst=pst.executeQuery();
			if(rst!=null) {
				if(rst.next()) {
					emp.setEmployeeID(rst.getInt(1));
					emp.setFirstName(rst.getString(2));
					emp.setLastName(rst.getString(3));
					emp.setUserID(rst.getString(4));
					emp.setPassword(rst.getString(5));
					emp.setGender(rst.getString(6));
					emp.setPhoneNumber(rst.getLong(7));
					emp.setRole(rst.getString(8));
					emp.setActive(rst.getString(9));
				}
			}
		}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return emp;
	}

	@Override
	public void updateEmployee(Employee emp) {
		
		
		try {
			//creating PreparedStatement object by passing query string
			PreparedStatement pst=conn.prepareStatement("update Employee set Password = ? where EmployeeID=?");
			pst.setString(1, emp.getPassword());
			pst.setInt(2, emp.getEmployeeID());
			int i=pst.executeUpdate();
			conn.commit();
			if(i==1){
				TabPanel1.tPassword.setText(emp.getPassword());
				JOptionPane.showMessageDialog(jpane,emp.getFirstName()+"'s Password Updated Successfully!!", "Alert!!", JOptionPane.WARNING_MESSAGE);
			}
			else {
				JOptionPane.showMessageDialog(jpane, "Updation failed.. May be invalid ID..", "Alert!!", JOptionPane.WARNING_MESSAGE);
			}
		}
		catch(SQLException ex) {
			try {
				conn.rollback();
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void deactivateEmployee(Employee emp, String act) {
		
		try {
			PreparedStatement pst;
			
			pst = conn.prepareStatement("update Employee set Active=? where EmployeeID=?");
			pst.setString(1, emp.getActive());
			pst.setInt(2, emp.getEmployeeID());
			
			int i=pst.executeUpdate();
			conn.commit();
			if(i==1) {
				JOptionPane.showMessageDialog(jpane,emp.getFirstName()+"'s Record "+ act+" Successfully!!", "Alert!!", JOptionPane.WARNING_MESSAGE);
			}
			else {
				JOptionPane.showMessageDialog(jpane, "Updation failed.. May be invalid ID..", "Alert!!", JOptionPane.WARNING_MESSAGE);
			}
		}
		catch (SQLException ex) {
			try {
				conn.rollback();
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
 
	@Override
	public void deleteEmployee(int id) {
		try {
			PreparedStatement pst, pst1;
			pst=conn.prepareStatement("select firstname from employee where employeeid=?");

			pst.setInt(1, id);
			ResultSet rst=pst.executeQuery();
			conn.commit();
			if(rst!=null) {
				if (rst.next()) {

					int option=JOptionPane.showConfirmDialog(jpane, "Do you want to delete "+rst.getString(1)+"'s record..", "Deletion Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
					if (option==JOptionPane.YES_OPTION) {
						pst1=conn.prepareStatement("delete from Employee where EmployeeID=?");
						pst1.setInt(1, id);
						int i =pst1.executeUpdate();
						conn.commit();
						if(i==1) {
							JOptionPane.showMessageDialog(jpane,rst.getString(1)+"'s Record deleted Successfully!!", "Alert!!", JOptionPane.WARNING_MESSAGE);
						}	
					}
				}
				else {
					JOptionPane.showMessageDialog(jpane, "Deletion failed.. May be invalid ID..", "Alert!!", JOptionPane.WARNING_MESSAGE);
				}
			}
				
			
		}
		catch (SQLException ex) {
			try {
				conn.rollback();
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public Employee updateName(Employee emp) {
		
		try {
			PreparedStatement pst1=conn.prepareStatement("update employee set firstname=? where employeeid=?");
			PreparedStatement pst2=conn.prepareStatement("update employee set lastname=? where employeeid=?");
			
			pst1.setString(1, emp.getFirstName());
			pst1.setInt(2, emp.getEmployeeID());
			
			pst2.setString(1, emp.getLastName());
			pst2.setInt(2, emp.getEmployeeID());
			
			int i=pst1.executeUpdate();
			int j=pst2.executeUpdate();
			conn.commit();
			
			if(i==1 && j==1) {
				TabPanel1.tName.setText(emp.getFirstName()+" "+emp.getLastName());
				JOptionPane.showMessageDialog(jpane,emp.getFirstName()+"'s Record Successfully!!", "Alert!!", JOptionPane.WARNING_MESSAGE);
			}
			else {
				JOptionPane.showMessageDialog(jpane, "Updation failed.. May be invalid ID..", "Alert!!", JOptionPane.WARNING_MESSAGE);
			}
			
		}
		catch (SQLException ex) {
			try {
				conn.rollback();
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return emp;
	}

	@Override
	public Employee updatePhone(Employee emp) {
		try {
			PreparedStatement pst=conn.prepareStatement("update employee set phonenumber=? where employeeid=?");
			
			pst.setLong(1, emp.getPhoneNumber());
			pst.setInt(2, emp.getEmployeeID());
			
			int i=pst.executeUpdate();
			conn.commit();
			
			if(i==1) {
				TabPanel1.tPhoneNumber.setText(String.valueOf(emp.getPhoneNumber()));
				JOptionPane.showMessageDialog(jpane,emp.getFirstName()+"'s phone number updated Successfully!!", "Alert!!", JOptionPane.WARNING_MESSAGE);
			}
			else {
				JOptionPane.showMessageDialog(jpane, "Updation failed.. May be invalid ID..", "Alert!!", JOptionPane.WARNING_MESSAGE);
			}
			
		}
		catch (SQLException ex) {
			try {
				conn.rollback();
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return emp;
	}
	
}


