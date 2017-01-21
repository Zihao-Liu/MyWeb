package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.GroupPostCommentApprove;
import dao.GroupPostCommentApproveDao;
import util.DBConnection;

public class GroupPostCommentApproveDaoImpl implements GroupPostCommentApproveDao {

	@Override
	public void addApprove(int commentID, int userID, int action) {
		Connection conn = DBConnection.getConnection();
		String sql = "insert into tb_groupcommentapprove (commentID,userID,approveAction) values(?,?,?)";
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
	public GroupPostCommentApprove findApprove(int commentID, int userID) {
		Connection conn = DBConnection.getConnection();
		String sql = "select * from tb_groupcommentapprove where commentID=? and userID = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		GroupPostCommentApprove approve = null;
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, commentID);
			pstmt.setInt(2, userID);
			rs = pstmt.executeQuery();
			while(rs.next()){
				approve = new GroupPostCommentApprove();
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
	public void deleteApprove(int commentID) {
		Connection conn = DBConnection.getConnection();
		String sql = "delete from tb_groupcommentapprove where commentID=?";
		PreparedStatement pstmt = null;
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, commentID);
			pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBConnection.close(pstmt);
			DBConnection.close(conn);
		}
	}

	@Override
	public void modifyCommentApprove(int commentID, int action) {
		Connection conn = DBConnection.getConnection();
		String sql;
		if(action == 1)
			sql = "update tb_groupcomment set commentApprove = commentApprove+1 where commentID = ?";
		else
			sql = "update tb_groupcomment set commentApprove = commentApprove-1 where commentID = ?";
		
		PreparedStatement  pstmt = null;
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, commentID);
			pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBConnection.close(pstmt);
			DBConnection.close(conn);
		}
		
	}

}
