package daoImpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import config.JDBCConnection;
import dao.IEmployeeDao;
import model.Employee;

public class EmployeeDaoImpl implements IEmployeeDao{

	Connection conn=null;
	public EmployeeDaoImpl() throws ClassNotFoundException, SQLException{
		conn=JDBCConnection.getDBConnection(); //Open connection
	}
	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> allEmpList=new ArrayList<Employee>();
		try{
			Statement stmt=conn.createStatement();
			ResultSet rst=stmt.executeQuery("select * from Employee");
			if(rst!=null) {
				Employee emp= null;
				while(rst.next()) {
					emp=new Employee();
					emp.setEmployeeID(rst.getInt(1));
					emp.setFirstName(rst.getString(2));
					emp.setLastName(rst.getString(3));
					emp.setUserID(rst.getString(4));
					emp.setPassword(rst.getString(5));
					emp.setGender(rst.getString(6));
					emp.setRole(rst.getString(7));
					emp.setActive(rst.getString(8));
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
			PreparedStatement pst=conn.prepareStatement("insert into Employee(FirstName,LastName,UserID,Password,Gender,Role,Active) values(?,?,?,?,?,?,?)");
			pst.setString(1, emp.getFirstName());
			pst.setString(2, emp.getLastName());
			pst.setString(3, emp.getUserID());
			pst.setString(4, emp.getPassword());
			pst.setString(5, emp.getGender());
			pst.setString(6, emp.getRole());
			pst.setString(7, emp.getActive());
			int i=pst.executeUpdate();
			if(i==1){
				System.out.println("1 record inserted...");
			}
			else {
				System.out.println("insertion failed...");
			}
		}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
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


