package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.Watch;
import dao.WatchDao;
import util.DBConnection;

public class WatchDaoImpl implements WatchDao{
	@Override
	public void addWatch(int filmID, int userID, float score) {
		Connection conn = DBConnection.getConnection();
		String sql = "insert into tb_watch (filmID,userID,score) values(?,?,?)";
		PreparedStatement pstmt = null;
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, filmID);
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
	public Watch findWatch(int filmID, int userID) {
		Connection conn = DBConnection.getConnection();
		String sql = "select * from tb_watch where filmID=? and userID = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Watch watch = null;
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, filmID);
			pstmt.setInt(2, userID);
			rs = pstmt.executeQuery();
			while(rs.next()){
				watch = new Watch();
				watch.setWatchID(rs.getInt(1));
				watch.setFilmID(rs.getInt(2));
				watch.setUserID(rs.getInt(3));
				watch.setScore(rs.getFloat(4));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBConnection.close(rs);
			DBConnection.close(pstmt);
			DBConnection.close(conn);
		}
		return watch;
	}
}
