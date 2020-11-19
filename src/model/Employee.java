package model;

public class Employee {
	
	private int EmployeeID;
	private String FirstName;
	private String LastName;
	private String UserID;
	private String Password;
	private String Gender;
	private String Role;
	private String Active;
	
	//default constructor method
	public Employee() {
		
	}

	public Employee(String firstName, String lastName, String userID, String password, String gender,
			String role) {
		super();
		this.FirstName = firstName;
		this.LastName = lastName;
		this.UserID = userID;
		this.Password = password;
		this.Gender = gender;
		this.Role = role;
	}

	public int getEmployeeID() {
		return EmployeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.EmployeeID = employeeID;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		this.FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		this.LastName = lastName;
	}

	public String getUserID() {
		return UserID;
	}

	public void setUserID(String userID) {
		this.UserID = userID;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		this.Password = password;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		this.Gender = gender;
	}

	public String getRole() {
		return Role;
	}

	public void setRole(String role) {
		this.Role = role;
	}

	public String getActive() {
		return Active;
	}

	public void setActive(String active) {
		this.Active = active;
	}

	@Override
	public String toString() {
		return "Employee [EmployeeID=" + EmployeeID + ", FirstName=" + FirstName + ", LastName=" + LastName
				+ ", UserID=" + UserID + ", Password=" + Password + ", Gender=" + Gender + ", Role=" + Role
				+ ", Active=" + Active + "]";
	}		
	
}

