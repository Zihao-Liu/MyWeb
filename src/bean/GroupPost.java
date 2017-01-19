package bean;

import java.util.Date;

public class GroupPost {
	private int postID;
	private String postTitle;
	private String postContent;
	private Date publishTime;
	private int userID;
	private int groupID;
	private int commentNum;
	private int postApprove;
	private Date recentModifyTime;
	public int getPostID() {
		return postID;
	}
	public void setPostID(int postID) {
		this.postID = postID;
	}
	public String getPostTitle() {
		return postTitle;
	}
	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}
	public String getPostContent() {
		return postContent;
	}
	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}
	public Date getPublishTime() {
		return publishTime;
	}
	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public int getGroupID() {
		return groupID;
	}
	public void setGroupID(int groupID) {
		this.groupID = groupID;
	}
	public int getCommentNum() {
		return commentNum;
	}
	public void setCommentNum(int commentNum) {
		this.commentNum = commentNum;
	}
	public int getPostApprove() {
		return postApprove;
	}
	public void setPostApprove(int postApprove) {
		this.postApprove = postApprove;
	}
	public Date getRecentModifyTime() {
		return recentModifyTime;
	}
	public void setRecentModifyTime(Date recentModifyTime) {
		this.recentModifyTime = recentModifyTime;
	}
}
