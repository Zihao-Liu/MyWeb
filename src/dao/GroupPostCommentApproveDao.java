package dao;


import bean.GroupPostCommentApprove;

public interface GroupPostCommentApproveDao {
	public void addApprove(int commentID, int userID,int action);
	public GroupPostCommentApprove findApprove(int commentID,int userID);
	public void deleteApprove(int commentID);
	public void modifyCommentApprove(int commentID, int action);
}
