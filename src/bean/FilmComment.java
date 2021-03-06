package bean;

import java.util.Date;

public class FilmComment {
	private int commentID;
	private String commentTitle;
	private String commentContent;
	private Date publishTime;
	private int userID;
	private int filmID;
	private int commentApprove;
	public int getCommentID() {
		return commentID;
	}
	public void setCommentID(int commentID) {
		this.commentID = commentID;
	}
	public String getCommentTitle() {
		return commentTitle;
	}
	public void setCommentTitle(String commentTitle) {
		this.commentTitle = commentTitle;
	}
	public String getCommentContent() {
		return commentContent;
	}
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
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
	public int getFilmID() {
		return filmID;
	}
	public void setFilmID(int filmID) {
		this.filmID = filmID;
	}
	public int getCommentApprove() {
		return commentApprove;
	}
	public void setCommentApprove(int commentApprove) {
		this.commentApprove = commentApprove;
	}
}
