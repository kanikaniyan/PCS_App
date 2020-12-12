package controller;

import java.sql.*;
import java.util.List;

import java.io.*;

import dao.IEmpSkillDao;
import dao.ISkillDao;
import daoImpl.EmpSkillDaoImpl;
import daoImpl.SkillDaoImpl;
import model.EmpSkill;
import model.Skill;

public class SkillController {
	
	ISkillDao skillDao=null;
	IEmpSkillDao empSkillDao=null;
	
	public SkillController() throws ClassNotFoundException, SQLException {
		skillDao=new SkillDaoImpl();
		empSkillDao=new EmpSkillDaoImpl();
	}
	public Skill addSkill(String skillName, String skillDesc) {
		
		Skill skill=new Skill();
		String skl=skillName;
		skill.setSkillName(skl);
		skill.setSkillDescription(skillDesc);
		skill.setActive("Yes");
		
		skillDao.addSkill(skill);
		return skill;
	}
	
	public List<Skill> getAllSkills() {
		List<Skill> allSkillList=skillDao.getAllSkills();
		return allSkillList;
	}
	
	public void getSkillById() {
		try {
			BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
			int id;
			System.out.println("Enter SkillId to access: ");
			id=Integer.parseInt(reader.readLine());
			Skill skill=skillDao.getSkillById(id);
			System.out.println(skill);
		}
		catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
	}
		
	
	public void deactivateSkill(String empid, String num) {
		
		int id;
		String ask;
		id=Integer.parseInt(empid);
		Skill skill=skillDao.getSkillById(id);
		ask=num;
		
		if (ask.equals("1")) {
			skill.setActive("YES");
			skillDao.deactivateSkill(skill, "activated");
		}
		else if (ask.equals("2")) {
			skill.setActive("NO");
			skillDao.deactivateSkill(skill, "deactivated");
		}
	}
	
	public void deleteSkill (String empid) {
		
		int id;
		id=Integer.parseInt(empid);
		skillDao.deleteSkill(id);

	}
	
	public void empSkill (int skillId, int empId, int year) {
		
		EmpSkill empskill=new EmpSkill();
		empskill.setEmployeeID(empId);
		empskill.setSkillID(skillId);
		empskill.setExpYear(year);
		empSkillDao.empSkill(empskill);
	
	}
}
