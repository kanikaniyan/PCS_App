package daoImpl;

import java.sql.*;

import config.JDBCConnection;
import dao.IEmpJobDao;
import model.EmpJob;

public class EmpJobDaoImpl implements IEmpJobDao{
	Connection conn=null;
	public EmpJobDaoImpl() throws ClassNotFoundException, SQLException{
		conn=JDBCConnection.getDBConnection(); //Open connection
	}
	@Override
	public void getAllEmpJob() {
		try{
			Statement stmt=conn.createStatement();
			ResultSet rst=stmt.executeQuery("select * from Employee");
			if(rst!=null) {
				EmpJob empjob=null;
				while(rst.next()) {
					empjob=new EmpJob();
					empjob.setRecruited(rst.getString(1));
				}
			}
		}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		
	}
	@Override
	public void addEmpJob(EmpJob empjob) {
		try {
			PreparedStatement pst=conn.prepareStatement("insert into EmpJob values(?,?,?,?,?,?,?)");
			pst.setString(1, empjob.getRecruited());
			int i=pst.executeUpdate();
			if(i==1) {
				System.out.println("1 record inserted...");
			}
			else {
				System.out.println("insertion failed...");
			}
		}
		
		catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		
	}
	
	@Override
	public EmpJob getEmpJobById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void updateEmpJob(EmpJob empjob) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deactivateEmpJob(int id) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deleteEmpJob(int id) {
		// TODO Auto-generated method stub
		
	}
	
	
}
