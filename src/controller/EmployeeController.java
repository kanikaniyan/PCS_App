package controller;

import java.io.*;

import dao.IEmployeeDao;
import daoImpl.EmployeeDaoImpl;
import model.Employee;
import java.sql.*;
import java.util.List;

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
}
