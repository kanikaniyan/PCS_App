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
	
	public Employee checkLogin(String userId, String password) {
		Employee emp=empDao.checkLogin(userId, password);
		return emp;
	}
	
	public Employee addEmployee(String fName, String lName, String gender, String emailId, String password, String desgn, Long phone) throws IOException {
		Employee emp=new Employee();
		emp.setFirstName(fName);
		emp.setLastName(lName);
		emp.setUserID(emailId);
		emp.setPassword(password);
		emp.setGender(gender);
		emp.setPhoneNumber(phone);
		String role=(desgn);
		emp.setRole(role);
		if (role.equals("HRA") || role.equals("EMP") || role.equals("PME")) {
			emp.setActive("YES");
		}
		else {
			emp.setActive("NO");
		}
		empDao.addEmployee(emp);
		return emp;
	}
	
	public List<Employee> getAllEmployees() {
		List<Employee> allEmpList=empDao.getAllEmployees();
		
		return allEmpList;
	}	
	
	public void getEmployeeById(int id) {
		
		empDao.getEmployeeById(id);
	}

	public class UpdateEmployee {
		
		public Employee updateName(int ID, String fName, String lName) {
			int id;
			String firstName, lastName;
			
			id=ID;
			firstName=fName;
			lastName=lName;
			Employee emp=empDao.getEmployeeById(id);
			emp.setFirstName(firstName);
			emp.setLastName(lastName);
			emp=empDao.updateName(emp);
			
			return emp;
		}
		
		public void updatePhone(int ID, String number) {
			int id=ID;
			Employee emp=empDao.getEmployeeById(id);
			Long num=Long.parseLong(number);
			emp.setEmployeeID(id);
			emp.setPhoneNumber(num);
			emp=empDao.updatePhone(emp);
		}
		
	}
	
	public void updateEmployee(int ID, String password1) throws ClassNotFoundException, SQLException {
		
			int id;
			id=ID;
			Employee emp=empDao.getEmployeeById(id);
		
			String password;
			password=(password1);
			emp.setPassword(password);
			empDao.updateEmployee(emp);
				
	}
	
	
	public void deactivateEmployee(String empid, String opt) {
		
		int id;
		String ask;
		id=Integer.parseInt(empid);
		System.out.println(id);
		Employee emp=empDao.getEmployeeById(id);
		ask=opt;
		
		if (ask.equals("1")) {
			emp.setActive("YES");
			empDao.deactivateEmployee(emp, "Activated");
		}
		else if(ask.equals("2")) {
			emp.setActive("NO");
			empDao.deactivateEmployee(emp, "Deactivated");
		}
	}
	
	public void deleteEmployee(String empid) {
		
		int id;
		id=Integer.parseInt(empid);
		empDao.deleteEmployee(id);
	}
}
