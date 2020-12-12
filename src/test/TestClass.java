package test;

import static org.junit.Assert.*;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;


import java.sql.SQLException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import dao.IEmployeeDao;
import dao.IJobDao;
import dao.ISkillDao;
import daoImpl.EmployeeDaoImpl;
import daoImpl.JobDaoImpl;
import daoImpl.SkillDaoImpl;
import model.Employee;
import model.Job;
import model.Skill;

public class TestClass {
	IJobDao jobDao=null;
	IEmployeeDao empDao=null;
	ISkillDao skillDao=null;
	@Before
	public void setup() throws ClassNotFoundException {
			try {
				jobDao=new JobDaoImpl();
				empDao=new EmployeeDaoImpl();
				skillDao=new SkillDaoImpl();
			}
			catch (SQLException e) {
				
			}
	}
	
	@Test
	public void testGetJobById() {
		Job jobActual=new Job();
		Job jobExpected=new Job(314, "Java Developer", "Need a developer with an experience of 1 year", " Professionet Consultancy Services", "Chennai", "core & Advanced Java", 21000, "Yes");
		jobActual=jobDao.getJobById(314);
		assertEquals(jobExpected.getJobTitle(), jobActual.getJobTitle());
	}
	
	@Test
	public void testActDeactJob() {
		Job jobActual=new Job();
		Job JobExpected=new Job(314, "Java Developer", "Need a developer with an experience of 1 year", " Professionet Consultancy Services", "Chennai", "core & Advanced Java", 21000, "NO");
		Job job=jobDao.getJobById(314);
		job.setActive("NO");
		jobActual=jobDao.deactivateJob(job, "Deactivated");
		assertEquals(JobExpected.getActive(), jobActual.getActive());
	}
	
	@Test
	public void testDeleteJob() {
		Job jobActual=new Job();
		new Job(315, "HR", "Human resources manager", " Professionet Consultancy Services", "Cochin", "good leading power", 28000, "Yes");
		jobActual=jobDao.deleteJob(315);
		assertNull(jobActual);
	}
	
	@Test
	public void testAddEmployee() {
		Employee empActual=new Employee();
		empActual.setFirstName("vignesh");
		empActual.setLastName("kannan");
		empActual.setUserID("vignesh@gmail.com");
		empActual.setGender("Male");
		empActual.setPassword("Vignesh@56");
		empActual.setPhoneNumber(823422113);
		empActual.setRole("EMP");
		empDao.addEmployee(empActual);
		
		Employee empExpected=new Employee(134, "vignesh", "kannan", "vignesh@gmail.com", "Vignesh@56", "Male", 823422113, "EMP", "YES");
		assertEquals(empExpected.getFirstName(), empActual.getFirstName());
		assertEquals(empExpected.getUserID(), empActual.getUserID());
	}
	
	@Test
	public void testGetAllEmployees() {
		List<Employee> allEmpList=empDao.getAllEmployees();
		
		assertNotNull(allEmpList);
		
		Employee emp =allEmpList.get(3);
		assertEquals(126, emp.getEmployeeID());
		
		Employee emp1 =allEmpList.get(8);
		assertEquals("Kathir", emp1.getFirstName());

		assertTrue("Is Active ?", emp1.getActive().equals("YES"));
		
		assertThat(allEmpList.size(), is(11));
	}
	
	@Test
	public void testGetAllSkills() {
		List<Skill> allSkillList=skillDao.getAllSkills();
		
		Skill skill=allSkillList.get(2);
		assertEquals("React", skill.getSkillName());
		
		assertFalse("Is Active ?", skill.getActive().equals("NO"));
		
		assertThat(allSkillList.size(), is(3));
	}
	
}
