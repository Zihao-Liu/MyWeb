package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.Approve;
import dao.ApproveDao;
import util.DBConnection;

public class ApproveDaoImpl implements ApproveDao {

	@Override
	public void addApprove(int commentID, int userID,int action) {
		Connection conn = DBConnection.getConnection();
		String sql = "insert into tb_approve (commentId,userID,approveAction) values(?,?,?)";
		PreparedStatement pstmt = null;
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, commentID);
			pstmt.setInt(2, userID);
			if(action ==1)
				pstmt.setString(3, "ÔÞ³É");
			else
				pstmt.setString(3, "·´¶Ô");
			pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBConnection.close(pstmt);
			DBConnection.close(conn);
		}
	}

	@Override
	public Approve findApprove(int commentID, int userID) {
		Connection conn = DBConnection.getConnection();
		String sql = "select * from tb_approve where commentID=? and userID = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Approve approve = null;
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, commentID);
			pstmt.setInt(2, userID);
			rs = pstmt.executeQuery();
			while(rs.next()){
				approve = new Approve();
				approve.setApproveID(rs.getInt(1));
				approve.setCommentID(rs.getInt(2));
				approve.setUserID(rs.getInt(3));
				approve.setApproveAction(rs.getString(4));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBConnection.close(rs);
			DBConnection.close(pstmt);
			DBConnection.close(conn);
		}
		return approve;
	}

	@Override
	public void deleteApprove(int commentID, int userID) {
		Connection conn = DBConnection.getConnection();
		String sql = "delete from tb_approve where commentID=? and userID = ?";
		PreparedStatement pstmt = null;
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, commentID);
			pstmt.setInt(2, userID);
			pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBConnection.close(pstmt);
			DBConnection.close(conn);
		}
	}

}
