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

	@Override
	public void deleteWatch(int filmID, int userID, float filmScore) {
		Connection conn = DBConnection.getConnection();
		String sql = "delete from tb_watch where filmID=? and userID=?";
		//下面两项应该调整到filmDao
		String sql2 = "update tb_film set filmWatch = filmWatch-1,filmScore = ((filmScore*(filmWatch+1))- ? )/(filmWatch+0.00001)  where filmID = ?";
		String sql3 = "update tb_user set userWatch = userWatch-1 where userID = ?";
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt2 = conn.prepareStatement(sql2);
			pstmt3 = conn.prepareStatement(sql3);
			pstmt.setInt(1, filmID);
			pstmt.setInt(2, userID);
			pstmt3.setInt(1, userID);
			pstmt2.setFloat(1, filmScore);
			pstmt2.setInt(2, filmID);
			
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
