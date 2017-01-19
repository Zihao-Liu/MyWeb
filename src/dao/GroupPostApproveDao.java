package dao;


import bean.GroupPostApprove;

public interface GroupPostApproveDao {
	public void addApprove(int postID, int userID,int action);
	public GroupPostApprove findApprove(int postID,int userID);
	public void deleteApprove(int postID);
	public void modifyPostApprove(int postID, int action);//action为赞成或反对，0为反对，1为赞成
}
