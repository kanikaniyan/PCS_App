package model;

public class Skill {
	
	private int SkillID;
	private String SkillName;
	private String SkillDescription;
	private String Active;
	
	public Skill() {
		
	}

	public Skill(int skillID, String skillName, String skillDescription, String active) {
		this.SkillID = skillID;
		this.SkillName = skillName;
		this.SkillDescription = skillDescription;
		this.Active = active;
	}

	public int getSkillID() {
		return SkillID;
	}

	public void setSkillID(int skillID) {
		this.SkillID = skillID;
	}

	public String getSkillName() {
		return SkillName;
	}

	public void setSkillName(String skillName) {
		this.SkillName = skillName;
	}

	public String getSkillDescription() {
		return SkillDescription;
	}

	public void setSkillDescription(String skillDescription) {
		this.SkillDescription = skillDescription;
	}

	public String getActive() {
		return Active;
	}

	public void setActive(String active) {
		this.Active = active;
	}

	@Override
	public String toString() {
		return "Skill [SkillID=" + SkillID + ", SkillName=" + SkillName + ", SkillDescription=" + SkillDescription
				+ ", Active=" + Active + "]";
	}
	
	
	
	
}


