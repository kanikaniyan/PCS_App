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
				EmpJob empjob=new EmpJob();
				while(rst.next()) {
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
		// TODO Auto-generated method stub
		
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
