package model;

public class Applyjob {
	private int applicationID;
	private int employeeID;
	private String empName;
	private int jobID;
	private String jobName;
	private String status;
	
	public Applyjob() {
		
	}
	
	public Applyjob(int applicationID, int jobID, int employeeID, String status) {
		this.applicationID = applicationID;
		this.jobID = jobID;
		this.employeeID = employeeID;
		this.status = status;
	}

	public Applyjob(int employeeID, String empName, int jobID, String jobName, String status) {
		super();
		this.employeeID = employeeID;
		this.empName = empName;
		this.jobID = jobID;
		this.jobName = jobName;
		this.status = status;
	}

	public int getApplicationID() {
		return applicationID;
	}

	public void setApplicationID(int applicationID) {
		this.applicationID = applicationID;
	}

	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public int getJobID() {
		return jobID;
	}

	public void setJobID(int jobID) {
		this.jobID = jobID;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Applyjob [applicationID=" + applicationID + ", employeeID=" + employeeID + ", empName=" + empName
				+ ", jobID=" + jobID + ", jobName=" + jobName + ", status=" + status + "]";
	}
	
	
}
