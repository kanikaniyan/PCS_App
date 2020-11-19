package dao;

import model.Job;

public interface IJobDao {
	void getAllJobs();
	void addJob(Job job);
	Job getJobById(int id);
	void updateJob(Job job);
	void deactivateJob(int id);
	void deleteJob(int id);
}
