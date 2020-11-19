package daoImpl;

import java.sql.*;

import config.JDBCConnection;
import dao.IEmployeeDao;
import model.Employee;

public class EmployeeDaoImpl implements IEmployeeDao{
	
	Connection conn=null;
	public void employeeDaoImpl() throws ClassNotFoundException, SQLException{
		conn=JDBCConnection.getDBConnection();
	}
	
	@Override
	public void getAllEmployees() {
		try {
			Statement stmt=conn.createStatement();
			ResultSet rst= stmt.executeQuery("select * from Employee");
			if(rst!=null) {
				Employee emp=new Employee();
				while(rst.next()) {
					emp.setEmployeeID(rst.getInt(1));
					emp.setFirstName(rst.getString(2));
					emp.setLastName(rst.getString(3));
					emp.setUserID(rst.getInt(4));
					emp.setPassword(rst.getString(5));
					emp.setRole(rst.getString(6));
					emp.setGender(rst.getString(7));
					emp.setActive(rst.getString(8));
					System.out.println(emp);
				}
			}
		}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}

	@Override
	public void addEmployee(Employee emp) {
		try {
		PreparedStatement pst=conn.prepareStatement("insert into Employee values(?,?,?,?,?,?,?)");
		pst.setString(1, emp.getFirstName());
		pst.setString(2, emp.getLastName());
		pst.setInt(3, emp.getUserID());
		pst.setString(4, emp.getPassword());
		pst.setString(5, emp.getGender());
		pst.setString(6, emp.getRole());
		pst.setString(7, emp.getActive());
		int i=pst.executeUpdate();
		if(i=1) {
			System.out.println("1 record inserted...");
		}
		else {
			System.out.println("Insertion failed...");
		}
		}
		catch (SQLException ex) {
			
		}
	}	

	@Override
	public Employee getEmployeeById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateEmployee(Employee emp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deactivateEmployee(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteEmployee(int id) {
		// TODO Auto-generated method stub
		
	}

}
