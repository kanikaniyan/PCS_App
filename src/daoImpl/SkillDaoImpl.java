package daoImpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import config.JDBCConnection;
import dao.ISkillDao;
import model.Skill;

public class SkillDaoImpl implements ISkillDao{
	Connection conn=null;
	public SkillDaoImpl() throws ClassNotFoundException, SQLException {
		conn = JDBCConnection.getDBConnection();
	}
	@Override
	public List<Skill> getAllSkills() {
		List<Skill> allSkillList=new ArrayList<Skill>();
		try {
			Statement stmt=conn.createStatement();
			ResultSet rst=stmt.executeQuery("select * from skill");
			if(rst!=null) {
				Skill skill= null;
				while(rst.next()) {
					skill= new Skill();
					skill.setSkillID(rst.getInt(1));
					skill.setSkillName(rst.getString(2));
					skill.setSkillDescription(rst.getString(3));
					skill.setActive(rst.getString(4));
					System.out.println(skill);
				}
			}
		}
		catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return allSkillList;
		
	}
	@Override
	public void addSkill(Skill skill) {
		try {
			PreparedStatement pst=conn.prepareStatement("insert into Skill(SkillName, SkillDescription, Active) values(?,?,?)");
			pst.setString(1, skill.getSkillName());
			pst.setString(2, skill.getSkillDescription());
			pst.setString(3, skill.getActive());
			int i=pst.executeUpdate();
			if(i==1) {
				System.out.println("1 record inserted...");
			}
			else {
				System.out.println("insertion falied...");
			}
		}
		catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		
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
