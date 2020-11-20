package daoImpl;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import config.JDBCConnection;
import dao.IJobDao;
import model.Job;

public class JobDaoImpl implements IJobDao{
	Connection conn=null;
	public JobDaoImpl() throws ClassNotFoundException, SQLException {
		conn=JDBCConnection.getDBConnection();
	}
	@Override
	public List<Job> getAllJobs() {
		List<Job> allJobList=new ArrayList<Job>();
		try {
			Statement stmt=conn.createStatement();
			ResultSet rst=stmt.executeQuery("select * from Job");
			if(rst!=null) {
				Job job=null;
				while(rst.next()) {
					job=new Job();
					job.setJobID(rst.getInt(1));
					job.setJobTitle(rst.getString(2));
					job.setJobDescription(rst.getString(3));
					job.setCompanyName(rst.getString(4));
					job.setLocation(rst.getString(5));
					job.setKeySkill(rst.getString(6));
					job.setSalary(rst.getInt(7));
					job.setActive(rst.getString(8));
					System.out.println(job);
				}
			}
		}
		catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return allJobList;
	}
	@Override
	public void addJob(Job job) {
		try {
			PreparedStatement pst=conn.prepareStatement("insert into Job(JobTitle, JobDescription, CompanyName, Location, KeySkill, Salary, Active) values(?,?,?,?,?,?,?)");
			pst.setString(1, job.getJobTitle());
			pst.setString(2, job.getJobDescription());
			pst.setString(3, job.getCompanyName());
			pst.setString(4, job.getLocation());
			pst.setString(5, job.getKeySkill());
			pst.setInt(6, job.getSalary());
			pst.setString(7, job.getActive());
			int i=pst.executeUpdate();
			if(i==1) {
				System.out.println("1 record inserted");
			}
			else {
				System.out.println("insertion failed...");
			}
		}
		catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}
	@Override
	public Job getJobById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void updateJob(Job job) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deactivateJob(int id) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deleteJob(int id) {
		// TODO Auto-generated method stub
		
	}
	
	
}
