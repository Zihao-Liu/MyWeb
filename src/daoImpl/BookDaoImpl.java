package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


import bean.Book;
import dao.BookDao;
import util.DBConnection;

public class BookDaoImpl implements BookDao {

	@Override
	public void addBook(Book book) {
		Connection conn = DBConnection.getConnection();
		String sql = "insert into tb_book (bookName,bookAuthor,bookType,bookInfo,bookAddTime) values(?,?,?,?,?)";
		PreparedStatement pstmt = null;
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, book.getBookName());
			pstmt.setString(2, book.getBookAurthor());
			pstmt.setString(3, book.getBookType());
			pstmt.setString(4, book.getBookInfo());
			pstmt.setTimestamp(5, new Timestamp(book.getBookAddTime().getTime()));
			pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBConnection.close(pstmt);
			DBConnection.close(conn);
		}
	}

	@Override
	public void deleteBook(String bookName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Book findBookByName(String bookName) {
		Connection conn = DBConnection.getConnection();
		String findbysql = "select * from tb_book where bookName = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Book book = null;
		try{
			pstmt = conn.prepareStatement(findbysql);
			pstmt.setString(1, bookName);
			rs = pstmt.executeQuery();
			while(rs.next()){
				book = new Book();
				book.setBookID(rs.getInt(1));
				book.setBookName(rs.getString(2));
				book.setBookAurthor(rs.getString(3));
				book.setBookType(rs.getString(4));
				book.setBookInfo(rs.getString(5));
				book.setBookAddTime(rs.getDate(6));
				book.setBookCoverPath(rs.getString(7));
				book.setBookRead(rs.getInt(8));
				book.setBookScore(rs.getFloat(9));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBConnection.close(rs);
			DBConnection.close(pstmt);
			DBConnection.close(conn);
		}
		return book;
	}

	@Override
	public Book findBookByAuthor(String bookAuthor) {
		Connection conn = DBConnection.getConnection();
		String findbysql = "select * from tb_book where bookAuthor = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Book book = null;
		try{
			pstmt = conn.prepareStatement(findbysql);
			pstmt.setString(1, bookAuthor);
			rs = pstmt.executeQuery();
			while(rs.next()){
				book = new Book();
				book.setBookID(rs.getInt(1));
				book.setBookName(rs.getString(2));
				book.setBookAurthor(rs.getString(3));
				book.setBookType(rs.getString(4));
				book.setBookInfo(rs.getString(5));
				book.setBookAddTime(rs.getDate(6));
				book.setBookCoverPath(rs.getString(7));
				book.setBookRead(rs.getInt(8));
				book.setBookScore(rs.getFloat(9));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBConnection.close(rs);
			DBConnection.close(pstmt);
			DBConnection.close(conn);
		}
		return book;
	}
	
	
	@Override
	public Book findBookByID(int bookID) {
		Connection conn = DBConnection.getConnection();
		String fingBySql = "select * from tb_book where bookID = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Book book = new Book();
		try{
			pstmt = conn.prepareStatement(fingBySql);
			pstmt.setInt(1, bookID);
			rs = pstmt.executeQuery();
			while(rs.next()){
				book.setBookID(rs.getInt(1));
				book.setBookName(rs.getString(2));
				book.setBookAurthor(rs.getString(3));
				book.setBookType(rs.getString(4));
				book.setBookInfo(rs.getString(5));
				book.setBookAddTime(rs.getDate(6));
				book.setBookCoverPath(rs.getString(7));
				book.setBookRead(rs.getInt(8));
				book.setBookScore(rs.getFloat(9));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBConnection.close(rs);
			DBConnection.close(pstmt);
			DBConnection.close(conn);
		}
		return book;
	}

	
	@Override
	public List<Book> findAllBook() {
		Connection conn = DBConnection.getConnection();
		String findbysql = "select * from tb_book";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Book> books = new ArrayList<Book>();
		try{
			pstmt = conn.prepareStatement(findbysql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Book book = new Book();
				book.setBookID(rs.getInt(1));
				book.setBookName(rs.getString(2));
				book.setBookAurthor(rs.getString(3));
				book.setBookType(rs.getString(4));
				book.setBookInfo(rs.getString(5));
				book.setBookAddTime(rs.getDate(6));
				book.setBookCoverPath(rs.getString(7));
				book.setBookRead(rs.getInt(8));
				book.setBookScore(rs.getFloat(9));
				books.add(book);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBConnection.close(rs);
			DBConnection.close(pstmt);
			DBConnection.close(conn);
		}
		return books;
	}

	@Override
	public void updateBook(Book book) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Book> findAllBookOrderByTime() {
		Connection conn = DBConnection.getConnection();
		String findbysql = "select * from tb_book order by bookAddTime Desc";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Book> books = new ArrayList<Book>();
		try{
			pstmt = conn.prepareStatement(findbysql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Book book = new Book();
				book.setBookID(rs.getInt(1));
				book.setBookName(rs.getString(2));
				book.setBookAurthor(rs.getString(3));
				book.setBookType(rs.getString(4));
				book.setBookInfo(rs.getString(5));
				book.setBookAddTime(rs.getDate(6));
				book.setBookCoverPath(rs.getString(7));
				book.setBookRead(rs.getInt(8));
				book.setBookScore(rs.getFloat(9));
				books.add(book);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBConnection.close(rs);
			DBConnection.close(pstmt);
			DBConnection.close(conn);
		}
		return books;
	}

	@Override
	public List<Book> findAllBookOrderByRead() {
		Connection conn = DBConnection.getConnection();
		String findbysql = "select * from tb_book order by bookRead Desc";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Book> books = new ArrayList<Book>();
		try{
			pstmt = conn.prepareStatement(findbysql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Book book = new Book();
				book.setBookID(rs.getInt(1));
				book.setBookName(rs.getString(2));
				book.setBookAurthor(rs.getString(3));
				book.setBookType(rs.getString(4));
				book.setBookInfo(rs.getString(5));
				book.setBookAddTime(rs.getDate(6));
				book.setBookCoverPath(rs.getString(7));
				book.setBookRead(rs.getInt(8));
				book.setBookScore(rs.getFloat(9));
				books.add(book);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBConnection.close(rs);
			DBConnection.close(pstmt);
			DBConnection.close(conn);
		}
		return books;
	}

	@Override
	public List<Book> findAllBookOrderByScore() {
		Connection conn = DBConnection.getConnection();
		String findbysql = "select * from tb_book order by bookScore Desc";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Book> books = new ArrayList<Book>();
		try{
			pstmt = conn.prepareStatement(findbysql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Book book = new Book();
				book.setBookID(rs.getInt(1));
				book.setBookName(rs.getString(2));
				book.setBookAurthor(rs.getString(3));
				book.setBookType(rs.getString(4));
				book.setBookInfo(rs.getString(5));
				book.setBookAddTime(rs.getDate(6));
				book.setBookCoverPath(rs.getString(7));
				book.setBookRead(rs.getInt(8));
				book.setBookScore(rs.getFloat(9));
				books.add(book);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBConnection.close(rs);
			DBConnection.close(pstmt);
			DBConnection.close(conn);
		}
		return books;
	}

	@Override
	public void modifyBookRead(int bookID,float bookScore) {
		Connection conn = DBConnection.getConnection();
		String sql="update tb_book set bookRead = bookRead+1,bookScore = ((bookScore*(bookRead-1))+?)/bookRead  where bookID = ?";
		PreparedStatement  pstmt = null;
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setFloat(1,bookScore);
			pstmt.setInt(2, bookID);
			pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBConnection.close(pstmt);
			DBConnection.close(conn);
		}
		
	}

	@Override
	public List<Book> findAllBookByType(String bookType) {
		Connection conn = DBConnection.getConnection();
		String sql="select * from tb_book where bookType = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Book> books = new ArrayList<Book>();
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bookType);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Book book = new Book();
				book.setBookID(rs.getInt(1));
				book.setBookName(rs.getString(2));
				book.setBookAurthor(rs.getString(3));
				book.setBookType(rs.getString(4));
				book.setBookInfo(rs.getString(5));
				book.setBookAddTime(rs.getDate(6));
				book.setBookCoverPath(rs.getString(7));
				book.setBookRead(rs.getInt(8));
				book.setBookScore(rs.getFloat(9));
				books.add(book);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBConnection.close(rs);
			DBConnection.close(pstmt);
			DBConnection.close(conn);
		}
		return books;
	}

	

}
