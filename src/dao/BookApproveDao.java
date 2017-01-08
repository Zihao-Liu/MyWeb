package dao;

import bean.BookApprove;

public interface BookApproveDao {
	public void addApprove(int commentID, int userID,int action);
	public BookApprove findApprove(int commentID,int userID);
	public void deleteApprove(int commentID);
}
