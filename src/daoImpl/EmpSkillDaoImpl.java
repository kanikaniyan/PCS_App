package daoImpl;

import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import config.JDBCConnection;
import dao.IEmpSkillDao;
import model.EmpSkill;

public class EmpSkillDaoImpl implements IEmpSkillDao{
	Connection conn=null;
	public EmpSkillDaoImpl() throws ClassNotFoundException, SQLException {
		conn=JDBCConnection.getDBConnection();
		conn.setAutoCommit(false);
	}
	
	JFrame jpane=new JFrame();
	@Override
	public void empSkill(EmpSkill empskill) {
		try {
			PreparedStatement pst=conn.prepareStatement("insert into empskill (employeeid, skillid, expyear) values(?,?,?)");
			pst.setInt(1, empskill.getEmployeeID());
			pst.setInt(2, empskill.getSkillID());
			pst.setInt(3, empskill.getExpYear());
			int i=pst.executeUpdate();
			conn.commit();
			if(i==1) {
				JOptionPane.showMessageDialog(jpane,"Record updated Successfully!!", "Alert!!", JOptionPane.WARNING_MESSAGE);
			}
			else {
				JOptionPane.showMessageDialog(jpane, "Updation Failed.. May be invalid ID..", "Alert!!", JOptionPane.WARNING_MESSAGE);
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
