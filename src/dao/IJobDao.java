package dao;

import java.util.List;

import model.Applyjob;
import model.Job;

public interface IJobDao {
	List<Job> getAllJobs();
	void addJob(Job job);
	Job getJobById(int id);
	Job deactivateJob(Job job, String record);
	Job deleteJob(int id);
	List<Job> skillWiseJob(String skill);
	Applyjob applyJob(int jobid, int empid);
	List<Applyjob> getAllAppliedJobs();
}
