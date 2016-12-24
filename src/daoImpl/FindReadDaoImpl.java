package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import bean.Book;
import dao.BookDao;
import dao.FindReadDao;
import factory.BookDaoFactory;
import util.DBConnection;

public class FindReadDaoImpl implements FindReadDao {

	public List<Book> findAllBookRead(int userID) {
		Connection conn = DBConnection.getConnection();
		String sql = "select bookID from tb_read where userID=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List <Book> books = new ArrayList<Book>();
		try{
			BookDao bookDao = BookDaoFactory.getBookDaoInstance();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userID);
			rs = pstmt.executeQuery();
			while(rs.next()){
				books.add(bookDao.findBookByID(rs.getInt(1)));
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
