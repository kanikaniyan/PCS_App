package entry;
import java.sql.SQLException;
import java.util.Scanner;

import config.JDBCConnection;
import controller.EmployeeController;
import controller.JobController;
import controller.SkillController;

public class EntryClass {

	public void testConnection() throws ClassNotFoundException, SQLException {
		if (JDBCConnection.getDBConnection().isClosed()) {
			System.out.println("Connection is closed");
		}
		else {
			System.out.println("Connection is opened");
		}
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		
		EmployeeController empController=new EmployeeController();
		Scanner sc =new Scanner(System.in);
		int option;
		char ch='y';
		while (ch=='y' || ch=='Y') {
			System.out.println("CRUD operation Menu:");
			System.out.println("1. View all employees records");
			System.out.println("2. View single employee record");
			System.out.println("3. Add an employee");
			System.out.println("4. Update an employee record");
			System.out.println("5. Activate/Deactivate an employee record");
			System.out.println("6. Delete an employee record");
			System.out.println("7. Exit");
			System.out.println("Enter your choice");
			
			option=sc.nextInt();
			switch (option) {
			case 1:
				System.out.println("Following are all Employees Details: ");
				empController.getAllEmployees();
				break;
			case 2:
				empController.getEmployeeById();
				break;
			case 3:
				System.out.println("Enter Employee Detail: ");
				empController.addEmployee();
				break;
			case 4:
				empController.updateEmployee();
				break;
			case 5:
				empController.deactivateEmployee();
				break;
			case 6:
	
				break;
			case 7:
	
				break;

			default:
				System.out.println("wrong input!!");
			}
			System.out.println("Do you want to continue? (y/n)");
			ch=sc.next().charAt(0);
		}
		
		
//		System.out.println("Enter Employee Detail: ");
//		empController.addEmployee();
//		System.out.println("Following are all Employees Details: ");
//		empController.getAllEmployees();
//		
//		JobController jbController=new JobController();
//		System.out.println("Enter Job Details");
//		jbController.addJob();
//		System.out.println("Following are all Jobs Listed");
//		jbController.getAllJobs();
//
//		SkillController sklController=new SkillController();
//		System.out.println("Enter Skill Details: ");
//		sklController.addSkill();
//		System.out.println("Following are the Skills Listed...");
//		sklController.getAllSkills();
//		
		
	}

}
