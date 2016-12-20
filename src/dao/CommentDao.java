package dao;

import java.util.List;

import bean.Comment;


public interface CommentDao {
	public void addComment(Comment comment);
	public void deleteComment(Comment comment);
	public List<Comment> findCommentByBookName(String bookName);
	public List<Comment> findCommentByBookID(int bookID);
	public List<Comment> findCommentByUserName(String userName);
	public List<Comment> findCommentOrderByApprove();
	public List<Comment> findCommentByBookIDOrderByApprove(int bookID);
	public List<Comment> findCommentByBookIDOrderByPublishTime(int bookID);
	public Comment findCommentByCommentID(int commentID);
	public void updateComment(Comment comment);
	public void modifyCommentApprove(int commentID, int action);//actionΪ�޳ɻ򷴶ԣ�0Ϊ���ԣ�1Ϊ�޳�
}
