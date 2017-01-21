package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.GroupPostApprove;
import dao.GroupPostApproveDao;
import util.DBConnection;

public class GroupPostApproveDaoImpl implements GroupPostApproveDao{

	@Override
	public void addApprove(int postID, int userID, int action) {
		Connection conn = DBConnection.getConnection();
		String sql = "insert into tb_grouppostapprove (postID,userID,approveAction) values(?,?,?)";
		PreparedStatement pstmt = null;
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, postID);
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
	public GroupPostApprove findApprove(int postID, int userID) {
		Connection conn = DBConnection.getConnection();
		String sql = "select * from tb_grouppostapprove where postID=? and userID = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		GroupPostApprove approve = null;
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, postID);
			pstmt.setInt(2, userID);
			rs = pstmt.executeQuery();
			while(rs.next()){
				approve = new GroupPostApprove();
				approve.setApproveID(rs.getInt(1));
				approve.setPostID(rs.getInt(2));
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
	public void deleteApprove(int postID) {
		Connection conn = DBConnection.getConnection();
		String sql = "delete from tb_grouppostapprove where postID=?";
		PreparedStatement pstmt = null;
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, postID);
			pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBConnection.close(pstmt);
			DBConnection.close(conn);
		}
		
	}

	@Override
	public void modifyPostApprove(int postID, int action) {
		Connection conn = DBConnection.getConnection();
		String sql;
		if(action == 1)
			sql = "update tb_grouppost set postApprove = postApprove+1 where postID = ?";
		else
			sql = "update tb_grouppost set postApprove = postApprove-1 where postID = ?";
		
		PreparedStatement  pstmt = null;
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, postID);
			pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBConnection.close(pstmt);
			DBConnection.close(conn);
		}
		
	}

}
