package bean;

public class User {
	private int userID;
	private String userName;
	private String userSex;
	private String password;
	private int userApprove;
	private int userRead;
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserSex() {
		return userSex;
	}
	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getUserApprove() {
		return userApprove;
	}
	public void setUserApprove(int userApprove) {
		this.userApprove = userApprove;
	}
	public int getUserRead() {
		return userRead;
	}
	public void setUserRead(int userRead) {
		this.userRead = userRead;
	}
}
