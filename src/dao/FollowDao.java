package dao;

import java.util.List;

import bean.Follow;

public interface FollowDao {
	public void addFollow(int followerUserID, int followingUserID );
	public void deleteFollow(int followerUserID, int followingUserID);
	public List<Follow> findFollowerUser(int userID);
	public List<Follow> findFollowingUser(int userID);
	public Follow findFollow(int followerUserID,int followingUserID);
}
