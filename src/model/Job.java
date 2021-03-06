package model;

public class Job {
	
	private int JobID;
	private String JobTitle;
	private String JobDescription;
	private String CompanyName;
	private String Location;
	private String KeySkill;
	private int Salary;
	private String Active;
	
	public Job() {
		
	}

	public Job(int jobId, String jobTitle, String jobDescription, String companyName, String location, String keySkill, int salary, String active) {
		this.JobID=jobId;
		this.JobTitle = jobTitle;
		this.JobDescription = jobDescription;
		this.CompanyName = companyName;
		this.Location = location;
		this.KeySkill = keySkill;
		this.Salary = salary;
		this.Active = active;
	}
	
	public Job(String jobTitle, String jobDescription, String companyName, String location, String keySkill, int salary) {
		super();
		this.JobTitle = jobTitle;
		this.JobDescription = jobDescription;
		this.CompanyName = companyName;
		this.Location = location;
		this.KeySkill = keySkill;
		this.Salary = salary;
	}

	public int getJobID() {
		return JobID;
	}

	public void setJobID(int jobID) {
		this.JobID = jobID;
	}

	public String getJobTitle() {
		return JobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.JobTitle = jobTitle;
	}
	
	public String getJobDescription() {
		return JobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.JobDescription = jobDescription;
	}

	public String getCompanyName() {
		return CompanyName;
	}

	public void setCompanyName(String companyName) {
		this.CompanyName = companyName;
	}

	public String getLocation() {
		return Location;
	}

	public void setLocation(String location) {
		this.Location = location;
	}

	public String getKeySkill() {
		return KeySkill;
	}

	public void setKeySkill(String keySkill) {
		this.KeySkill = keySkill;
	}

	public int getSalary() {
		return Salary;
	}

	public void setSalary(int salary) {
		this.Salary = salary;
	}

	public String getActive() {
		return Active;
	}

	public void setActive(String active) {
		this.Active = active;
	}

	@Override
	public String toString() {
		return "Job [JobID=" + JobID + ", JobTitle=" + JobTitle + ", JobDescription=" + JobDescription
				+ ", CompanyName=" + CompanyName + ", Location=" + Location + ", KeySkill=" + KeySkill + ", Salary="
				+ Salary + ", Active=" + Active + "]";
	}

	
	
}
