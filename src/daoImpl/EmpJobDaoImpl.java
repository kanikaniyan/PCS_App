package daoImpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import config.JDBCConnection;
import dao.IEmpJobDao;
import model.EmpJob;

public class EmpJobDaoImpl implements IEmpJobDao{
	Connection conn=null;
	public EmpJobDaoImpl() throws ClassNotFoundException, SQLException{
		conn=JDBCConnection.getDBConnection(); //Open connection
		conn.setAutoCommit(false);
	}
	
	JFrame jpane=new JFrame();
	
	@Override
	public List<EmpJob> RecruitedEmp() {
		List<EmpJob> EmpJobList=new ArrayList <EmpJob> ();
		try {
			Statement stmt=conn.createStatement();
			ResultSet rst=stmt.executeQuery("select * from empjob");
			conn.commit();
			if(rst!=null) {
				EmpJob empjob=null;
				while(rst.next()) {
					empjob=new EmpJob();
					empjob.setEJID(rst.getInt(1));
					empjob.setEmployeeID(rst.getInt(2));
					empjob.setJobID(rst.getInt(3));
					empjob.setRecruited(rst.getString(4));
					EmpJobList.add(empjob);
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
		return EmpJobList;
	}

	@Override
	public void empJob(EmpJob empjob) {
		try {
			PreparedStatement pst1=conn.prepareStatement("select * from applyjob where employeeid=?");
			pst1.setInt(1, empjob.getEmployeeID());
			ResultSet rst=pst1.executeQuery();
			conn.commit();
			if (rst!=null) {
				if (rst.next()) {
					int jobid=rst.getInt(2);
					
					PreparedStatement pst=conn.prepareStatement("insert into empjob (jobid, empid, recruited) values(?,?,?)");
					pst.setInt(2, empjob.getEmployeeID());
					pst.setInt(1, jobid);
					pst.setString(3, empjob.getRecruited());
					int i=pst.executeUpdate();
					
					conn.commit();
					
					if(i==1) {
						JOptionPane.showMessageDialog(jpane,"Emp id: "+empjob.getEmployeeID()+"-- recruited Successfully!!", "Alert!!", JOptionPane.WARNING_MESSAGE);
					}
					else {
						JOptionPane.showMessageDialog(jpane, "Updation failed.. May be invalid ID..", "Alert!!", JOptionPane.WARNING_MESSAGE);
					}
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
