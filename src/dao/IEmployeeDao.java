package dao;

import model.Employee;

public interface IEmployeeDao {
	
	void getAllEmployees();
	void addEmployee(Employee emp);
	Employee getEmployeeById(int id);
	void updateEmployee(Employee emp);
	void deactivateEmployee(int id);
	void deleteEmployee(int id);
}
