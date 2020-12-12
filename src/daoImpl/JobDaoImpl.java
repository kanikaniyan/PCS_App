package daoImpl;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import config.JDBCConnection;
import dao.IJobDao;
import model.Applyjob;
import model.Job;

public class JobDaoImpl implements IJobDao{
	Connection conn=null;
	public JobDaoImpl() throws ClassNotFoundException, SQLException {
		conn=JDBCConnection.getDBConnection();
		conn.setAutoCommit(false);
	}
	
	JFrame jpane=new JFrame();
	
	@Override
	public List<Job> getAllJobs() {
		List<Job> allJobList=new ArrayList<Job>();
		try {
			Statement stmt=conn.createStatement();
			ResultSet rst=stmt.executeQuery("select * from Job");
			conn.commit();
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
					allJobList.add(job);
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
			conn.commit();
			if(i==1) {
				JOptionPane.showMessageDialog(jpane, "Job Added Successfully!!?", "Alert!!", JOptionPane.WARNING_MESSAGE);
			}
			else {
				JOptionPane.showMessageDialog(jpane, "Updation failed", "Alert!!", JOptionPane.WARNING_MESSAGE);
			}
		}
		catch (SQLException ex) {
			try {
				conn.rollback();
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	@Override
	public Job getJobById(int id) {
		Job job=new Job();
		try {
			PreparedStatement pst=conn.prepareStatement("Select * from Job where JobID=?");
			pst.setInt(1, id);
			ResultSet rst=pst.executeQuery();
			if(rst!=null) {
				if(rst.next()) {
					job.setJobID(rst.getInt(1));
					job.setJobTitle(rst.getString(2));
					job.setJobDescription(rst.getString(3));
					job.setCompanyName(rst.getString(4));
					job.setLocation(rst.getString(5));
					job.setKeySkill(rst.getString(6));
					job.setSalary(rst.getInt(7));
					job.setActive(rst.getString(8));
				}
			}
		}
		catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return job;
	}
	
	@Override
	public Job deactivateJob(Job job, String record) {
		
		try {
			PreparedStatement pst=conn.prepareStatement("update Job set Active=? where JobID=?");
			pst.setString(1, job.getActive());
			pst.setInt(2, job.getJobID());
			int i=pst.executeUpdate();
			conn.commit();
			if (i==1) {
				JOptionPane.showMessageDialog(jpane,job.getJobTitle()+"'s Record "+ record+" Successfully!!", "Alert!!", JOptionPane.WARNING_MESSAGE);
			}
			else {
				JOptionPane.showMessageDialog(jpane, "Updation failed.. May be invalid ID..", "Alert!!", JOptionPane.WARNING_MESSAGE);
			}
		}
		
		catch (SQLException ex) {
			try {
				conn.rollback();
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return job;
	}
	@Override
	public Job deleteJob(int id) {
		try {
			PreparedStatement pst=conn.prepareStatement("delete from Job where JobID=?");
			pst.setInt(1, id);
			int i=pst.executeUpdate();
			conn.commit();
			if (i==1) {
				JOptionPane.showMessageDialog(jpane,"Job id: "+id+"'s Record deleted Successfully!!", "Alert!!", JOptionPane.WARNING_MESSAGE);
			}
			else {
				JOptionPane.showMessageDialog(jpane, "Updation failed.. May be invalid ID..", "Alert!!", JOptionPane.WARNING_MESSAGE);
			}
		}
		catch (SQLException ex) {
			try {
				conn.rollback();
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
		
	}
	@Override
	public List<Job> skillWiseJob(String skill) {
		List<Job> sortedJobList=new ArrayList<Job>();
		Job job=new Job();
		try {
			PreparedStatement pst=conn.prepareStatement("select * from Job where keyskill like CONCAT('%', ?, '%')");
			pst.setString(1, skill);
			ResultSet rst=pst.executeQuery();
			conn.commit();
			if (rst!=null) {
				if(rst.next()) {
					job.setJobID(rst.getInt(1));
					job.setJobTitle(rst.getString(2));
					job.setJobDescription(rst.getString(3));
					job.setCompanyName(rst.getString(4));
					job.setLocation(rst.getString(5));
					job.setKeySkill(rst.getString(6));
					job.setSalary(rst.getInt(7));
					job.setActive(rst.getString(8));
					sortedJobList.add(job);
				}
			}
		}
		catch (SQLException ex) {
			try {
				conn.rollback();
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return sortedJobList;
	}
	@Override
	public Applyjob applyJob(int jobid, int empid) {
		try {
			PreparedStatement pst=conn.prepareStatement("insert into applyjob (jobid, employeeid, status) values(?,?,?)");
			pst.setInt(1, jobid);
			pst.setInt(2, empid);
			pst.setString(3, "Applied");
			int i=pst.executeUpdate();
			
			conn.commit();
			
			if(i==1) {
				JOptionPane.showMessageDialog(jpane,"Job id: "+jobid+"-- applied Successfully!!", "Alert!!", JOptionPane.WARNING_MESSAGE);
			}
			else {
				JOptionPane.showMessageDialog(jpane, "Updation failed.. May be invalid ID..", "Alert!!", JOptionPane.WARNING_MESSAGE);
			}
		}
		
		catch (SQLException ex) {
			try {
				conn.rollback();
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
		
	}
	@Override
	public List<Applyjob> getAllAppliedJobs() {
		List<Applyjob> appliedJobList=new ArrayList <Applyjob> ();
		try {
			Statement stmt=conn.createStatement();
			ResultSet rst=stmt.executeQuery("select * from appliedlist");
			conn.commit();
			if(rst!=null) {
				Applyjob appjob=null;
				while(rst.next()) {
					appjob=new Applyjob();
					appjob.setApplicationID(rst.getInt(1));
					appjob.setEmployeeID(rst.getInt(2));
					appjob.setEmpName(rst.getString(3));
					appjob.setJobID(rst.getInt(4));
					appjob.setJobName(rst.getString(5));
					appjob.setStatus(rst.getString(6));
					appliedJobList.add(appjob);
				}
				
			}
		}
		
		catch (SQLException ex) {
			try {
				conn.rollback();
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return appliedJobList;
	}
	
}
