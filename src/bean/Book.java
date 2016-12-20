package bean;

import java.util.Date;

public class Book {
	private int bookID;
	private String bookName;
	private String bookAurthor;
	private String bookType;
	private String bookInfo;
	private String bookCoverPath;
	private Date bookAddTime;
	private int bookRead;
	private float bookScore;
	public int getBookID() {
		return bookID;
	}
	public void setBookID(int bookID) {
		this.bookID = bookID;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookAurthor() {
		return bookAurthor;
	}
	public void setBookAurthor(String bookAurthor) {
		this.bookAurthor = bookAurthor;
	}
	public String getBookType() {
		return bookType;
	}
	public void setBookType(String bookType) {
		this.bookType = bookType;
	}
	public String getBookInfo() {
		return bookInfo;
	}
	public void setBookInfo(String bookInfo) {
		this.bookInfo = bookInfo;
	}
	public String getBookCoverPath() {
		return bookCoverPath;
	}
	public void setBookCoverPath(String bookCoverPath) {
		this.bookCoverPath = bookCoverPath;
	}
	public Date getBookAddTime() {
		return bookAddTime;
	}
	public void setBookAddTime(Date bookAddTime) {
		this.bookAddTime = bookAddTime;
	}
	public int getBookRead() {
		return bookRead;
	}
	public void setBookRead(int bookRead) {
		this.bookRead = bookRead;
	}
	public float getBookScore() {
		return bookScore;
	}
	public void setBookScore(float bookScore) {
		this.bookScore = bookScore;
	}
}
