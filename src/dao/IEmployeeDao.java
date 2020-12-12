package dao;

import java.util.List;

import model.Employee;

public interface IEmployeeDao {
	
	List<Employee> getAllEmployees();
	void addEmployee(Employee emp);
	Employee getEmployeeById(int id);
	void updateEmployee(Employee emp);
	void deactivateEmployee(Employee emp, String act);
	void deleteEmployee(int id);
	
	Employee checkLogin(String userId, String password);
	Employee updateName(Employee emp);
	Employee updatePhone(Employee emp);
}


