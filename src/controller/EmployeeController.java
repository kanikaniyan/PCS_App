package controller;

import java.io.*;

import dao.IEmployeeDao;
import daoImpl.EmployeeDaoImpl;
import model.Employee;
import java.sql.*;
import java.util.List;

import config.JDBCConnection;

public class EmployeeController {
	
	IEmployeeDao empDao =null;
	public EmployeeController() throws ClassNotFoundException, SQLException {
		empDao=new EmployeeDaoImpl();
	}
	public Employee addEmployee() {
		Employee emp=new Employee();
		try {
			BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter First Name: ");
			emp.setFirstName(reader.readLine());
			System.out.println("Enter Last Name: ");
			emp.setLastName(reader.readLine());
			System.out.println("Enter UserID: ");
			emp.setUserID(reader.readLine());
			System.out.println("Enter Password: ");
			emp.setPassword(reader.readLine());
			System.out.println("Enter Gender: ");
			emp.setGender(reader.readLine());
			System.out.println("Enter Role: ");
			String role=(reader.readLine());
			emp.setRole(role);
			if (role.equals("HRA")) {
				emp.setActive("Yes");
			}
			else {
				emp.setActive("No");
			}
			empDao.addEmployee(emp);
		
		}
		catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
		return emp;
	}
	
	public void getAllEmployees() {
		List<Employee> allEmpList=empDao.getAllEmployees();
		for(Employee emp:allEmpList) {
			System.out.println(emp);
		}
	}
	
	public void getEmployeeById() {
		try {
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		int id;
		System.out.println("Enter EmployeeId whose record you want to access: ");
		id=Integer.parseInt(reader.readLine());
		Employee emp=empDao.getEmployeeById(id);
		System.out.println(emp);
		}
		catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
	}

	public void updateEmployee() throws ClassNotFoundException, SQLException {
		try {
			
			BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
			int id;
			String oldpassword;
			System.out.println("Enter EmployeeId whose record you want to update: ");
		
			id=Integer.parseInt(reader.readLine());
			Employee emp=empDao.getEmployeeById(id);
		
			System.out.println("Enter old password: ");
			oldpassword=(reader.readLine());
		
			Connection conn=JDBCConnection.getDBConnection();
			PreparedStatement pst=conn.prepareStatement("select * from employee where Password =? and EmployeeID=?");
			pst.setString(1, oldpassword);
			pst.setInt(2, id);
			
			ResultSet rst = pst.executeQuery();
			if(rst.next()) {
				System.out.println("Old password matches!!");
				
				String password, confirmpassword;
				System.out.println("Now enter new password: ");
				password=(reader.readLine());
				System.out.println("Enter the same password to confirm: ");
				confirmpassword=reader.readLine();
				if (password.equals(confirmpassword)) {
					emp.setPassword(confirmpassword);
					empDao.updateEmployee(emp);
				}
				else {
					System.out.println("You have entered the wrong password!");
				}
			}
			else {
				System.out.println("old password does not match!!");
			}
		
		}
		catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	
	public void deactivateEmployee() {
		try {
			BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
			int id;
			String ask;
			System.out.println("Enter EmployeeId which you want to deactivate: ");
			id=Integer.parseInt(reader.readLine());
			Employee emp=empDao.getEmployeeById(id);
			System.out.println("Press '1'/'2' to deactivate/Activate the ID: ");
			ask=reader.readLine();
			
			if (ask.equals("1")) {
				emp.setActive("NO");
				empDao.deactivateEmployee(emp);
			}
			else if(ask.equals("2")) {
				emp.setActive("YES");
				empDao.deactivateEmployee(emp);
			}
			else {
				System.out.println("wrong input!.. Enter either '1' or '2'");
				
				deactivateEmployee();
				
			}
		}
		catch (IOException ex) {
			System.out.println("ex.getMessage()");
		}
	}
	
	public void deleteEmployee() {
		try {
			BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
			int id;
			System.out.println("Enter the employee ID you want to delete: ");
			id=Integer.parseInt(reader.readLine());
			empDao.deleteEmployee(id);
			
		}
		catch (IOException ex) {
			System.out.println("ex.getMessage()");
		}
	}
}
