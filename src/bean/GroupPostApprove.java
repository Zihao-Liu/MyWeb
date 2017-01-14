package bean;

public class GroupPostApprove {
	private int approveID;
	private int postID;
	private int userID;
	private String approveAction;
	public int getApproveID() {
		return approveID;
	}
	public void setApproveID(int approveID) {
		this.approveID = approveID;
	}
	public int getPostID() {
		return postID;
	}
	public void setPostID(int postID) {
		this.postID = postID;
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
