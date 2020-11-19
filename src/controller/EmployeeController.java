package controller;

import java.io.*;
import model.Employee;

public class EmployeeController {
	
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
		System.out.println("Enter Role: ");
		emp.setRole(reader.readLine());
		System.out.println("Enter Gender: ");
		emp.setGender(reader.readLine());
		
		}
		catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
		return emp;
	}
}
