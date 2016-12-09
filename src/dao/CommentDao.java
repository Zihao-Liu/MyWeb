package dao;

import java.util.List;

import bean.Comment;


public interface CommentDao {
	public void addComment(Comment comment);
	public void deleteComment(Comment comment);
	public List<Comment> findCommentByBookName(String nookName);
	public List<Comment> findCommentByBookID(int bookID);
	public List<Comment> findCommentByUserName(String userName);
	public void updateComment(Comment comment);
}
