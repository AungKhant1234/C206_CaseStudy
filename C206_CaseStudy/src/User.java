
public class User {
	private String UserId;
	private String UserName;
	private String mobileNumber;
	private String email;

	public User(String UserId, String UserName, String mobileNumber, String email) {
		this.UserId = UserId;
		this.UserName = UserName;
		this.mobileNumber = mobileNumber;
		this.email = email;
	}

	public String getUserId() {
		return UserId;
	}

	public void setuserId(String UserId) {
		this.UserId = UserId;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String UserName) {
		this.UserName = UserName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getemail() {
		return email;
	}

	public void setquantity(String email) {
		this.email = email;
	}

	public String toString() {
		String output = "";
		// Write your codes here
		return output;
	}

}
