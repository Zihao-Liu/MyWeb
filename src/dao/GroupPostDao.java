package dao;

import java.util.List;

import bean.GroupPost;

public interface GroupPostDao {
	public void addPost(GroupPost groupPost);
	public void deletePost(int groupPostID);
	public GroupPost findPostByPostID(int commentID);
	public List<GroupPost> findAllPostByUserID(int userID);
	public List<GroupPost> findAllPostByGroupID(int groupID);
}
