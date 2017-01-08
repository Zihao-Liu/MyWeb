package dao;

import java.util.List;

import bean.BookComment;


public interface BookCommentDao {
	public void addComment(BookComment comment);
	public void deleteComment(int commentID,int userID);
	public List<BookComment> findCommentByBookName(String bookName);
	public List<BookComment> findCommentByBookID(int bookID);
	public List<BookComment> findCommentByUserName(String userName);
	public List<BookComment> findCommentOrderByApprove();
	public List<BookComment> findCommentByBookIDOrderByApprove(int bookID);
	public List<BookComment> findCommentByBookIDOrderByPublishTime(int bookID);
	public BookComment findCommentByCommentID(int commentID);
	public void updateComment(BookComment comment);
	public void modifyCommentApprove(int commentID, int action);//actionΪ�޳ɻ򷴶ԣ�0Ϊ���ԣ�1Ϊ�޳�
}
