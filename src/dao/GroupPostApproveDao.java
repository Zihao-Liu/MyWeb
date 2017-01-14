package dao;


import bean.GroupPostApprove;

public interface GroupPostApproveDao {
	public void addApprove(int postID, int userID,int action);
	public GroupPostApprove findApprove(int postID,int userID);
	public void deleteApprove(int postID);
}
