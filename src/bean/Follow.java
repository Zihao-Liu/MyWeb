package bean;

public class Follow {
	private int followID;
	private int followerUserID;//被关注人ID
	private int followingUserID;//关注人ID
	public int getFollowID() {
		return followID;
	}
	public void setFollowID(int followID) {
		this.followID = followID;
	}
	public int getFollowerUserID() {
		return followerUserID;
	}
	public void setFollowerUserID(int followerUserID) {
		this.followerUserID = followerUserID;
	}
	public int getFollowingUserID() {
		return followingUserID;
	}
	public void setFollowingUserID(int followingUserID) {
		this.followingUserID = followingUserID;
	}
}
