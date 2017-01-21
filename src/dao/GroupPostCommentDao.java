package dao;

import java.util.List;


import bean.GroupPostComment;

public interface GroupPostCommentDao  {
	public void addComment(GroupPostComment groupPostComment);
	public void deleteComment(int commentID,int userID);
	public GroupPostComment findPostCommentByCommentID(int commentID);
	public List<GroupPostComment> findAllCommentByUserID(int userID);
	public List<GroupPostComment> findAllCommentByPostID(int postID);
}
