package daoImpl;

import java.sql.*;

import config.JDBCConnection;
import dao.IEmpSkillDao;
import model.EmpSkill;
import model.Employee;

public class EmpSkillDaoImpl implements IEmpSkillDao{
	Connection conn=null;
	public EmpSkillDaoImpl() throws ClassNotFoundException, SQLException {
		conn=JDBCConnection.getDBConnection();
	}
	@Override
	public void getAllEmpSkill() {
		try {
			Statement stmt=conn.createStatement();
			ResultSet rst=stmt.executeQuery("select * from EmpSkill");
			if(rst!=null) {
				EmpSkill empskill=new EmpSkill();
				while(rst.next()) {
					
				}
		}
		catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		
	}
	@Override
	public void addEmpSkill(EmpSkill empskill) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public EmpSkill getEmpSkillById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void updateEmpSkill(EmpSkill empskill) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deactivateEmpSkill(int id) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deleteEmpSkill(int id) {
		// TODO Auto-generated method stub
		
	}
	
	
}
