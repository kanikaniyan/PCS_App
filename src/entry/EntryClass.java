package entry;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import config.JDBCConnection;
import controller.EmployeeController;
import controller.JobController;
import controller.SkillController;

public class EntryClass {

	private static Scanner sc;

	public void testConnection() throws ClassNotFoundException, SQLException {
		if (JDBCConnection.getDBConnection().isClosed()) {
			System.out.println("Connection is closed");
		}
		else {
			System.out.println("Connection is opened");
		}
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException{
		
		EmployeeController empController=new EmployeeController();
		JobController jbController=new JobController();
		SkillController sklController=new SkillController();
		
		int access, option;
		char ch;
		sc = new Scanner(System.in);
		
		access=access();
		switch(access) {
			
			case 1:
				ch='y';
				while (ch=='y' || ch=='Y') {
					
					option=empmenu();
					switch (option) {
						case 1:
							System.out.println("Following are all Employees Details: ");
							empController.getAllEmployees();
							break;
						case 2:
							empController.getEmployeeById(option);
							break;
						case 3:
							System.out.println("Enter Employee Detail: ");
							empController.addEmployee(null, null, null, null, null, null, null);
							break;
						case 4:
							empController.updateEmployee(option, null);
							break;
						case 5:
							empController.deactivateEmployee(null, null);
							break;
						case 6:
							empController.deleteEmployee(null);
							break;
						case 7:
							System.out.println("Closing the application!!\n\n Thank you!!!");
							System.exit(0);
						default:
							System.out.println("wrong input!!");
					}
					
					ch = goAgain("Employee");
				}
				break;
				
			case 2:
				ch='y';
				while (ch=='y' || ch=='Y') {
					
					option=jobmenu();
					switch (option) {
						case 1:
							System.out.println("Following are all JOB Details: ");
							jbController.getAllJobs();
							break;
						case 2:
							jbController.getJobById(option);
							break;
						case 3:
							System.out.println("Enter Job Detail: ");
							jbController.addJob(null, null, null, null, null, null);
							break;
						case 4:
							break;
						case 5:
							jbController.deactivateJob(null, null);
							break;
						case 6:
							jbController.deleteJob(null);
							break;
						case 7:
							System.out.println("Closing the application...\n\nThank you!!");
							System.exit(0);
						default:
							System.out.println("wrong input!!");
					}
					
					ch = goAgain("Job");
				}
				break;
			case 3:
				ch='y';
				while (ch=='y' || ch=='Y') {
					
					option=skillmenu();
					switch (option) {
						case 1:
							System.out.println("Following are all SKILL Details: ");
							sklController.getAllSkills();
							break;
						case 2:
							sklController.getSkillById();
							break;
						case 3:
							System.out.println("Enter Skill Detail: ");
							sklController.addSkill(null, null);
							break;
						case 4:
							break;
						case 5:
							sklController.deactivateSkill(null, null);
							break;
						case 6:
							sklController.deleteSkill(null);
							break;
						case 7:
							System.out.println("Closing the application...\n\nThank you!!");
							System.exit(0);
						default:
							System.out.println("wrong input!!");
					}
					
					ch = goAgain("Skill");
				}
				break;
		}

	}
	
	private static char goAgain(String col) {
		System.out.println("Do you want to continue accessing "+col+" or exit? (y/n)");
		char ch=sc.next().charAt(0);
		if (ch=='y'||ch=='Y') {
			System.out.println("Continues accessing "+col+"....");
		}
		else if (ch=='n' || ch=='N') {
			System.out.println("exits accessing "+col+"...");
			System.out.println("\nThank you!!");
			System.exit(0) ;
		}
		else {
			System.out.println("entered the wrong input!! \n\nTry Again !!");
			System.exit(0);
		}
		return ch;
	}
	
	
	private static int access() {
		
		System.out.println("\nWhat you want to access...\n--------------------------\n1. Access Employee \n2. Access Job\n3. Access Skill\n\n Enter your choice: ");
		int access=sc.nextInt();
		return access;
	}
	
	private static int empmenu() {
		
		System.out.println("EMPLOYEE CRUD OPERATION MENU");
		System.out.println("----------------------------");
		System.out.println("1. View all employees records");
		System.out.println("2. View single employee record");
		System.out.println("3. Add an employee");
		System.out.println("4. Update an employee record");
		System.out.println("5. Activate/Deactivate an employee record");
		System.out.println("6. Delete an employee record");
		System.out.println("7. Exit");
		System.out.println("\nEnter your choice");
		
		int option=sc.nextInt();
		return option;
	}
	
	private static int jobmenu() {
		
		System.out.println("JOB CRUD OPERATION MENU");
		System.out.println("-----------------------");
		System.out.println("1. View all JOB records");
		System.out.println("2. View single job record");
		System.out.println("3. Add a Job");
		System.out.println("4. Update a Job record");
		System.out.println("5. Activate/Deactivate an Job record");
		System.out.println("6. Delete an Job record");
		System.out.println("7. exit");
		System.out.println("\nEnter your choice");
		
		int option=sc.nextInt();
		return option;
	}
	
	private static int skillmenu() {
		System.out.println("SKILL CRUD OPERATION MENU");
		System.out.println("-----------------------");
		System.out.println("1. View all SKILL records");
		System.out.println("2. View single Skill record");
		System.out.println("3. Add a Skill");
		System.out.println("4. Update a Skill record");
		System.out.println("5. Activate/Deactivate an Skill record");
		System.out.println("6. Delete an Skill record");
		System.out.println("7. exit");
		System.out.println("\nEnter your choice");
		
		int option=sc.nextInt();
		return option;
	}
	
}
