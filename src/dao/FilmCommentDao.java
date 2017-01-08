package dao;

import java.util.List;

import bean.FilmComment;


public interface FilmCommentDao {
	public void addComment(FilmComment comment);
	public void deleteComment(int commentID,int userID);
	public List<FilmComment> findCommentByFilmName(String filmName);
	public List<FilmComment> findCommentByFilmID(int filmID);
	public List<FilmComment> findCommentByUserName(String userName);
	public List<FilmComment> findCommentOrderByApprove();
	public List<FilmComment> findCommentByFilmIDOrderByApprove(int filmID);
	public List<FilmComment> findCommentByFilmIDOrderByPublishTime(int filmID);
	public FilmComment findCommentByCommentID(int commentID);
	public void updateComment(FilmComment comment);
	public void modifyCommentApprove(int commentID, int action);//actionΪ�޳ɻ򷴶ԣ�0Ϊ���ԣ�1Ϊ�޳�
}
