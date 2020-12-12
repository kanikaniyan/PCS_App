package controller;

import java.sql.*;
import java.util.List;

import dao.IEmpJobDao;
import dao.IJobDao;
import daoImpl.EmpJobDaoImpl;
import daoImpl.JobDaoImpl;
import model.Applyjob;
import model.EmpJob;
import model.Job;

public class JobController {
	IJobDao jobDao =null;
	IEmpJobDao empJobDao=null;
	
	public JobController() throws ClassNotFoundException, SQLException {
		jobDao=new JobDaoImpl();
		empJobDao=new EmpJobDaoImpl();
	}
	public Job addJob(String jobTitle, String desc, String companyName, String location, String keySkill, String salary) {
		
		Job job=new Job();
		
		job.setJobTitle(jobTitle);
		job.setJobDescription(desc);
		job.setCompanyName(companyName);
		String loc=(location);
		job.setLocation(loc);
		job.setKeySkill(keySkill);
		job.setSalary(Integer.parseInt(salary));
		
		if (loc.equals("Chennai") || loc.equals("Mumbai") || loc.equals("Delhi") || loc.equals("Cochin") || loc.equals("Bangalore") || loc.equals("Kolkata") || loc.equals("Pune")) {
			job.setActive("Yes");
		}
		else {
			job.setActive("No");
		}
		jobDao.addJob(job);
		return job;
	}
	 
	public List<Job> getAllJobs() {
		List<Job> allJobList=jobDao.getAllJobs();

		return allJobList;
	}
	
	public Job getJobById(int jobid) {
		
			int id;
			id=jobid;
			Job job=jobDao.getJobById(id);
			
			return job;
	}
	
	
	public void deactivateJob(String empid, String opt) {
		
		int id;
		String ask;
		id=Integer.parseInt(empid);
		Job job=jobDao.getJobById(id);
		ask=opt;
		
		if (ask.equals("1")) {
			job.setActive("YES");
			String result="Job ID = "+id+" is Activated...";
			jobDao.deactivateJob(job, result);
		}
		else if (ask.equals("2")) {
			job.setActive("NO");
			String result="Job ID = "+id+" is now Deactivated...";
			jobDao.deactivateJob(job, result);
		}
	}
	
	public void deleteJob(String empid) {
		
		int id;
		id=Integer.parseInt(empid);
		jobDao.deleteJob(id);
	}
	
	public List<Job> skillWiseJob(String skill) {
		List<Job> sortedJobList=jobDao.skillWiseJob(skill);
		return sortedJobList;
	}
	
	public void applyJob(Job job, int empid) {
		
		int jobid=job.getJobID();
		jobDao.applyJob(jobid, empid);
	}
	
	public List<Applyjob> getAllAppliedJobs() {
		
		List<Applyjob> appliedJobList=jobDao.getAllAppliedJobs();
		return appliedJobList;
	}
	public void empJob(int empid, String string) {
		EmpJob empjob= new EmpJob();
		empjob.setEmployeeID(empid);
		empjob.setRecruited(string);
		
		empJobDao.empJob(empjob);
		
	}
	public List<EmpJob> RecruitedEmp() {
		List<EmpJob> EmpJobList=empJobDao.RecruitedEmp();
		return EmpJobList;
	}
}
