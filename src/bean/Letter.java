package bean;

import java.util.Date;

public class Letter {
	private int letterID;
	private int sendUserID;
	private int receiveUserID;
	private String letterContent;
	private int letterRead;
	private Date letterSendTime; 
	public int getLetterID() {
		return letterID;
	}
	public void setLetterID(int letterID) {
		this.letterID = letterID;
	}
	public int getSendUserID() {
		return sendUserID;
	}
	public void setSendUserID(int sendUserID) {
		this.sendUserID = sendUserID;
	}
	public int getReceiveUserID() {
		return receiveUserID;
	}
	public void setReceiveUserID(int receiveUserID) {
		this.receiveUserID = receiveUserID;
	}
	public String getLetterContent() {
		return letterContent;
	}
	public void setLetterContent(String letterContent) {
		this.letterContent = letterContent;
	}
	public int getLetterRead() {
		return letterRead;
	}
	public void setLetterRead(int letterRead) {
		this.letterRead = letterRead;
	}
	public Date getLetterSendTime() {
		return letterSendTime;
	}
	public void setLetterSendTime(Date letterSendTime) {
		this.letterSendTime = letterSendTime;
	}
}
