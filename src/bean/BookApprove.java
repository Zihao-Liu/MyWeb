package bean;

public class BookApprove {
	private int approveID;
	private int commentID;
	private int userID;
	private String approveAction;
	public int getApproveID() {
		return approveID;
	}
	public void setApproveID(int approveID) {
		this.approveID = approveID;
	}
	public int getCommentID() {
		return commentID;
	}
	public void setCommentID(int commentID) {
		this.commentID = commentID;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getApproveAction() {
		return approveAction;
	}
	public void setApproveAction(String approveAction) {
		this.approveAction = approveAction;
	}
	
}
