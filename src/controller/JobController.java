package controller;

import java.io.*;
import java.sql.*;
import java.util.List;

import dao.IJobDao;
import daoImpl.JobDaoImpl;
import model.Job;

public class JobController {
	IJobDao jobDao =null;
	public JobController() throws ClassNotFoundException, SQLException {
		jobDao=new JobDaoImpl();
	}
	public Job addJob() {
		Job job=new Job();
		try {
			BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter the Job Title: ");
			job.setJobTitle(reader.readLine());
			System.out.println("Enter Job Description: ");
			job.setJobDescription(reader.readLine());
			System.out.println("Enter Company Name: ");
			job.setCompanyName(reader.readLine());
			System.out.println("Enter the Location: ");
			String loc=(reader.readLine());
			job.setLocation(loc);
			System.out.println("Enter the key skill: ");
			job.setKeySkill(reader.readLine());
			System.out.println("Enter salary: ");
			job.setSalary(Integer.parseInt(reader.readLine()));
			
			
			if (loc!=("pune")) {
				job.setActive("Yes");
			}
			else {
				job.setActive("No");
			}
			jobDao.addJob(job);
		}
		catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
		return job;
	}
	
	public void getAllJobs() {
		List<Job> allJobList=jobDao.getAllJobs();
		for(Job job:allJobList) {
			System.out.println(job);
		}
	}
}
