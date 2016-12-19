package dao;

import java.util.List;

import bean.Comment;


public interface CommentDao {
	public void addComment(Comment comment);
	public void deleteComment(Comment comment);
	public List<Comment> findCommentByBookName(String nookName);
	public List<Comment> findCommentByBookID(int bookID);
	public List<Comment> findCommentByUserName(String userName);
	public List<Comment> findCommentOrderByApprove();
	public Comment findCommentByCommentID(int commentID);
	public void updateComment(Comment comment);
	public void modifyCommentApprove(int commentID, int action);//action为赞成或反对，0为反对，1为赞成
}
