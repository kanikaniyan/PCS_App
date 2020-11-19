package dao;

import model.EmpJob;

public interface IEmpJobDao {
	void getAllEmpJob();
	void addEmpJob(EmpJob empjob);
	EmpJob getEmpJobById(int id);
	void updateEmpJob(EmpJob empjob);
	void deactivateEmpJob(int id);
	void deleteEmpJob(int id);
}
