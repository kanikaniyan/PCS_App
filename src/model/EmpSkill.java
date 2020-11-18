package model;

public class EmpSkill {
	private int ESId;
	private int EmployeeID;
	private int SkillID;
	private int ExpYear;
	
	public EmpSkill() {
		
	}

	public EmpSkill(int eSId, int employeeID, int skillID, int expYear) {
		this.ESId = eSId;
		this.EmployeeID = employeeID;
		this.SkillID = skillID;
		this.ExpYear = expYear;
	}

	public int getESId() {
		return ESId;
	}

	public void setESId(int eSId) {
		this.ESId = eSId;
	}

	public int getEmployeeID() {
		return EmployeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.EmployeeID = employeeID;
	}

	public int getSkillID() {
		return SkillID;
	}

	public void setSkillID(int skillID) {
		this.SkillID = skillID;
	}

	public int getExpYear() {
		return ExpYear;
	}

	public void setExpYear(int expYear) {
		this.ExpYear = expYear;
	}

	@Override
	public String toString() {
		return "EmpSkill [ESId=" + ESId + ", EmployeeID=" + EmployeeID + ", SkillID=" + SkillID + ", ExpYear=" + ExpYear
				+ "]";
	}
	
	
}

