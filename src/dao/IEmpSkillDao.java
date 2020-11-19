package dao;

import model.EmpSkill;

public interface IEmpSkillDao {
	void getAllEmpSkill();
	void addEmpSkill(EmpSkill empskill);
	EmpSkill getEmpSkillById(int id);
	void updateEmpSkill(EmpSkill empskill);
	void deactivateEmpSkill(int id);
	void deleteEmpSkill(int id);
}
