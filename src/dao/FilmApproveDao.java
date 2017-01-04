package dao;

import bean.FilmApprove;

public interface FilmApproveDao {
	public void addApprove(int commentID, int userID,int action);
	public FilmApprove findApprove(int commentID,int userID);
	public void deleteApprove(int commentID,int userID);
}
