import java.io.Serializable;

public class person implements Serializable {
	
	//attributes
	String name;
	String phoneNum;
	String dob;
	String email;
	
	//default constructor
	public person() {
		super();
	}

	//constructor using arguments
	public person(String name, String phoneNum, String dob, String email) {
		super();
		this.name = name;
		this.phoneNum = phoneNum;
		this.dob = dob;
		this.email = email;
	}

	//getters and setters
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	//output
	@Override
	public String toString() {
		return "person [name=" + name + ", phoneNum=" + phoneNum + ", dob=" + dob + ", email=" + email + "]";
	}

}
