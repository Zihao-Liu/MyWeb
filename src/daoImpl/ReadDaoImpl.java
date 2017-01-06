package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.Read;
import dao.ReadDao;
import util.DBConnection;

public class ReadDaoImpl implements ReadDao {

	@Override
	public void addRead(int bookID, int userID, float score) {
		Connection conn = DBConnection.getConnection();
		String sql = "insert into tb_read (bookID,userID,score) values(?,?,?)";
		PreparedStatement pstmt = null;
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bookID);
			pstmt.setInt(2, userID);
			pstmt.setFloat(3, score);
			pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBConnection.close(pstmt);
			DBConnection.close(conn);
		}
		
	}

	@Override
	public Read findRead(int bookID, int userID) {
		Connection conn = DBConnection.getConnection();
		String sql = "select * from tb_read where bookID=? and userID = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Read read = null;
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bookID);
			pstmt.setInt(2, userID);
			rs = pstmt.executeQuery();
			while(rs.next()){
				read = new Read();
				read.setReadID(rs.getInt(1));
				read.setBookID(rs.getInt(2));
				read.setUserID(rs.getInt(3));
				read.setScore(rs.getFloat(4));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBConnection.close(rs);
			DBConnection.close(pstmt);
			DBConnection.close(conn);
		}
		return read;
	}

	@Override
	public void deleteRead(int bookID, int userID,float bookScore) {
		Connection conn = DBConnection.getConnection();
		String sql = "delete from tb_read where bookID=? and userID=?";
		String sql2 = "update tb_book set bookRead = bookRead-1,bookScore = ((bookScore*(bookRead+1))- ? )/(bookRead+0.00001)  where bookID = ?";
		String sql3 = "update tb_user set userRead = userRead-1 where userID = ?";
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt2 = conn.prepareStatement(sql2);
			pstmt3 = conn.prepareStatement(sql3);
			pstmt.setInt(1, bookID);
			pstmt.setInt(2, userID);
			pstmt3.setInt(1, userID);
			pstmt2.setFloat(1, bookScore);
			pstmt2.setInt(2, bookID);
			
			pstmt.executeUpdate();
			pstmt3.executeUpdate();
			pstmt2.executeUpdate();
			
			}catch(SQLException e){
				e.printStackTrace();
			}finally{
				DBConnection.close(pstmt);
				DBConnection.close(pstmt2);
				DBConnection.close(pstmt3);
				DBConnection.close(conn);
		}
		
	}

}
