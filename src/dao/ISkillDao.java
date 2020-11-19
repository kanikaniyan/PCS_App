package dao;

import model.Skill;

public interface ISkillDao {
	void getAllSkills();
	void addSkill(Skill skill);
	Skill getSkillById(int id);
	void updateSkill(Skill skill);
	void deactivateSkill(int id);
	void deleteSkill(int id);
}
