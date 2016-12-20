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
	public Read findread(int bookID, int userID) {
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

}
