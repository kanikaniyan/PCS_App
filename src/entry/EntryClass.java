package entry;
import java.sql.SQLException;
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
		System.out.println("Enter Employee Detail: ");
		empController.addEmployee();
		System.out.println("Following are all Employees Details: ");
		empController.getAllEmployees();
		
		JobController jbController=new JobController();
		System.out.println("Enter Job Details");
		jbController.addJob();
		System.out.println("Following are all Jobs Listed");
		jbController.getAllJobs();

		SkillController sklController=new SkillController();
		System.out.println("Enter Skill Details: ");
		sklController.addSkill();
		System.out.println("Following are the Skills Listed...");
		sklController.getAllSkills();
		
		
	}

}
