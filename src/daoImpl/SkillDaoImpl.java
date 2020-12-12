package daoImpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import config.JDBCConnection;
import dao.ISkillDao;
import model.Skill;

public class SkillDaoImpl implements ISkillDao{
	Connection conn=null;
	public SkillDaoImpl() throws ClassNotFoundException, SQLException {
		conn = JDBCConnection.getDBConnection();
		conn.setAutoCommit(false);
	}
	
	JFrame jpane=new JFrame();
	
	@Override
	public List<Skill> getAllSkills() {
		List<Skill> allSkillList=new ArrayList<Skill>();
		try {
			Statement stmt=conn.createStatement();
			ResultSet rst=stmt.executeQuery("select * from skill");
			conn.commit();
			if(rst!=null) {
				Skill skill= null;
				while(rst.next()) {
					skill= new Skill();
					skill.setSkillID(rst.getInt(1));
					skill.setSkillName(rst.getString(2));
					skill.setSkillDescription(rst.getString(3));
					skill.setActive(rst.getString(4));
					allSkillList.add(skill);
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
			conn.commit();
			if(i==1) {
				JOptionPane.showMessageDialog(jpane,skill.getSkillName()+"'s Record is added Successfully!!", "Alert!!", JOptionPane.WARNING_MESSAGE);
			}
			else {
				JOptionPane.showMessageDialog(jpane, "Deletion failed.. check the details you have entered!", "Alert!!", JOptionPane.WARNING_MESSAGE);
			}
		}
		catch (SQLException ex) {
			try {
				conn.rollback();
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	@Override
	public Skill getSkillById(int id) {
		Skill skill=new Skill();
		try {
		PreparedStatement pst=conn.prepareStatement("select * from Skill where SkillID=?");
		pst.setInt(1, id);
		ResultSet rst=pst.executeQuery();
		if (rst!=null) {
			if(rst.next()) {
				skill.setSkillID(rst.getInt(1));
				skill.setSkillName(rst.getString(2));
				skill.setSkillDescription(rst.getString(3));
				skill.setActive(rst.getString(4));
			}
		}
		}
		catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return skill;
	}
	
	@Override
	public void deactivateSkill(Skill skill, String act) {
		
		try {
			PreparedStatement pst=conn.prepareStatement("update skill set Active=? where SkillID=?");
			pst.setString(1, skill.getActive());
			pst.setInt(2, skill.getSkillID());
			int i=pst.executeUpdate();
			conn.commit();
			
			if (i==1) {
				JOptionPane.showMessageDialog(jpane, "SkillID : "+skill.getSkillID()+" / SkillName : "+skill.getSkillName()+" Record "+act+" Successfully!!", "Alert!!", JOptionPane.WARNING_MESSAGE);
			}
			else {
				JOptionPane.showMessageDialog(jpane, "Updation failed.. May be invalid ID..", "Alert!!", JOptionPane.WARNING_MESSAGE);
			}
		}
		catch (SQLException ex) {
			try {
				conn.rollback();
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	@Override
	public void deleteSkill(int id) {
		try {
			PreparedStatement pst, pst1;
			pst=conn.prepareStatement("select skillName from skill where skillid=?");
			pst.setInt(1, id);
			ResultSet rst=pst.executeQuery();
			conn.commit();
			
			if(rst!=null) {
				if (rst.next()) {

					int option=JOptionPane.showConfirmDialog(jpane, "Do you want to delete SkillID: "+ id +"/SkillName: "+rst.getString(1)+"\n record..", "Deletion Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
					if (option==JOptionPane.YES_OPTION) {
						pst1=conn.prepareStatement("delete from skill where SkillID=?");
						pst1.setInt(1, id);
						int i=pst1.executeUpdate();
						conn.commit();
						if (i==1) {
							JOptionPane.showMessageDialog(jpane,id+"/"+rst.getString(1)+"'s record deleted Successfully!!", "Alert!!", JOptionPane.WARNING_MESSAGE);
						}
					}
				}
				else {
					JOptionPane.showMessageDialog(jpane, "Deletion failed.. May be invalid ID..", "Alert!!", JOptionPane.WARNING_MESSAGE);
				}
			}
			
		}
		catch (SQLException ex) {
			try {
				conn.rollback();
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}
