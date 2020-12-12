package dao;

import java.util.List;

import model.EmpJob;

public interface IEmpJobDao {
	
	List<EmpJob> RecruitedEmp();

	void empJob(EmpJob empjob);
}
