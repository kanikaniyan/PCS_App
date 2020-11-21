package dao;

import java.util.List;

import model.Employee;

public interface IEmployeeDao {
	
	List<Employee> getAllEmployees();
	void addEmployee(Employee emp);
	Employee getEmployeeById(int id);
	void updateEmployee(Employee emp);
	void deactivateEmployee(Employee emp);
	void deleteEmployee(int id);
}


