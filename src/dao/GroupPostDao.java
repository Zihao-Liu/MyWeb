package dao;


import java.util.List;

import bean.GroupPost;
import bean.GroupPostComment;

public interface GroupPostDao {
	public void addPost(GroupPost groupPost);
	public void deletePost(int groupPostID,int userID);
	public GroupPost findPostByPostID(int commentID);
	public List<GroupPost> findAllPostByUserID(int userID);
	public List<GroupPost> findAllPostByGroupID(int groupID);
	public List<GroupPost> findAllPostOrderByCommentNum();
	public List<GroupPost> findPostByGroupIDOrderByPublishTime(int groupID);
	public List<GroupPost> findPostByGroupIDOrderByRecentModifyTime(int groupID);
	public void updateRecentModifyTime(GroupPostComment groupPostComment);
	public void addCommentNum(int postID);
	public void subCommentNum(int postID);
}
