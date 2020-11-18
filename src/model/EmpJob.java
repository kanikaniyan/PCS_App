package model;

public class EmpJob {
	private int EJID; 
	private int EmployeeID;
	private int JobID;
	private String Recruited;
	
	public EmpJob() {
		
	}

	public EmpJob(int eJID, int employeeID, int jobID, String recruited) {
		this.EJID = eJID;
		this.EmployeeID = employeeID;
		this.JobID = jobID;
		this.Recruited = recruited;
	}

	public int getEJID() {
		return EJID;
	}

	public void setEJID(int eJID) {
		this.EJID = eJID;
	}

	public int getEmployeeID() {
		return EmployeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.EmployeeID = employeeID;
	}

	public int getJobID() {
		return JobID;
	}

	public void setJobID(int jobID) {
		this.JobID = jobID;
	}

	public String getRecruited() {
		return Recruited;
	}

	public void setRecruited(String recruited) {
		this.Recruited = recruited;
	}

	@Override
	public String toString() {
		return "EmpJob [EJID=" + EJID + ", EmployeeID=" + EmployeeID + ", JobID=" + JobID + ", Recruited=" + Recruited
				+ "]";
	}
	
	
}
