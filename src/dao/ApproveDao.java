package dao;

import bean.Approve;

public interface ApproveDao {
	public void addApprove(int commentID, int userID,int action);
	public Approve findApprove(int commentID,int userID);
	public void deleteApprove(int commentID,int userID);
}
