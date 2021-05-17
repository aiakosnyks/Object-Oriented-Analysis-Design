package SmartDevice;

public class UserAccount {
	
	private int userId;
	private int password;

	public UserAccount(int userId, int password) {
		this.userId=userId;
		this.userId = userId;
	}

	public int getUserId() {
		return userId;
	}

	public double getPassword() {
		return password;
	}

	public void setPassword(int password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserAccount{" + "id:"+ userId +
				"password=" + password +
				'}';
	}
}
