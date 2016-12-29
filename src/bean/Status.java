package bean;

import java.util.Date;

public class Status {
	private int statusID;
	private String statusContent;
	private int userID;
	private Date publishTime;
	public int getStatusID() {
		return statusID;
	}
	public void setStatusID(int statusID) {
		this.statusID = statusID;
	}
	public String getStatusContent() {
		return statusContent;
	}
	public void setStatusContent(String statusContent) {
		this.statusContent = statusContent;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public Date getPublishTime() {
		return publishTime;
	}
	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}
	
}
