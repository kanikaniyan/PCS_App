package controller;

import java.sql.*;
import java.util.List;
import java.io.*;
import dao.ISkillDao;
import daoImpl.SkillDaoImpl;
import model.Skill;

public class SkillController {
	
	ISkillDao skillDao=null;
	public SkillController() throws ClassNotFoundException, SQLException {
		skillDao=new SkillDaoImpl();
	}
	public Skill addSkill() {
		Skill skill=new Skill();
		try {
			BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter Skill Name: ");
			String skl=(reader.readLine());
			skill.setSkillName(skl);
			System.out.println("Enter Skill Description: ");
			skill.setSkillDescription(reader.readLine());
			
			if(skl.equals("java") || skl.equals("MEAN") || skl.equals("MERN") || skl.equals("Project Lead")) {
				skill.setActive("Yes");
			}
			else {
				skill.setActive("No");
			}
			skillDao.addSkill(skill);
		}
		catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
		return skill;
	}
	
	public void getAllSkills() {
		List<Skill> allSkillList=skillDao.getAllSkills();
		for (Skill skill:allSkillList) {
			System.out.println(skill);
		}
	}
}
