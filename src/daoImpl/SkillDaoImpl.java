package daoImpl;

import java.sql.*;

import config.JDBCConnection;
import dao.ISkillDao;
import model.Skill;

public class SkillDaoImpl implements ISkillDao{
	Connection conn=null;
	public SkillDaoImpl() throws ClassNotFoundException, SQLException {
		conn = JDBCConnection.getDBConnection();
	}
	@Override
	public void getAllSkills() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void addSkill(Skill skill) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Skill getSkillById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void updateSkill(Skill skill) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deactivateSkill(int id) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deleteSkill(int id) {
		// TODO Auto-generated method stub
		
	}
	
}
