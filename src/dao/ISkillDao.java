package dao;

import java.util.List;

import model.Skill;

public interface ISkillDao {
	List<Skill> getAllSkills();
	void addSkill(Skill skill);
	Skill getSkillById(int id);
	void updateSkill(Skill skill);
	void deactivateSkill(int id);
	void deleteSkill(int id);
}
