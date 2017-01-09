package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import bean.Follow;
import dao.FollowDao;
import util.DBConnection;

public class FollowDaoImpl implements FollowDao{

	@Override
	public void addFollow(int followerUserID, int followingUserID) {
		Connection conn = DBConnection.getConnection();
		String sql1 = "insert into tb_follow (followerUserID, followingUserID) values(?,?)";
		String sql2 = "update tb_user set userFollower = userFollower + 1 where userID = ?";
		String sql3 = "update tb_user set userFollowing = userFollowing +1 where userID = ?";
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;
		try{
			pstmt1 = conn.prepareStatement(sql1);
			pstmt2 = conn.prepareStatement(sql2);
			pstmt3 = conn.prepareStatement(sql3);
			pstmt1.setInt(1, followerUserID);
			pstmt1.setInt(2, followingUserID);
			pstmt2.setInt(1, followerUserID);
			pstmt3.setInt(1, followingUserID);
			pstmt1.executeUpdate();
			pstmt2.executeUpdate();
			pstmt3.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBConnection.close(pstmt1);
			DBConnection.close(pstmt2);
			DBConnection.close(pstmt3);
			DBConnection.close(conn);
		}
	}

	@Override
	public void deleteFollow(int followerUserID, int followingUserID) {
		Connection conn = DBConnection.getConnection();
		String sql1 = "delete from tb_follow where followerUserID = ? and followingUserID = ?";
		String sql2 = "update tb_user set userFollower = userFollower - 1 where userID = ?";
		String sql3 = "update tb_user set userFollowing = userFollowing - 1 where userID = ?";
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;
		try{
			pstmt1 = conn.prepareStatement(sql1);
			pstmt2 = conn.prepareStatement(sql2);
			pstmt3 = conn.prepareStatement(sql3);
			pstmt1.setInt(1, followerUserID);
			pstmt1.setInt(2, followingUserID);
			pstmt1.executeUpdate();
			pstmt2.setInt(1, followerUserID);
			pstmt2.executeUpdate();
			pstmt3.setInt(1, followingUserID);
			pstmt3.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBConnection.close(pstmt1);
			DBConnection.close(pstmt2);
			DBConnection.close(pstmt3);
			DBConnection.close(conn);
		}
		
	}

	@Override
	public List<Follow> findFollowerUser(int userID) {
		Connection conn = DBConnection.getConnection();
		String sql = "select * from tb_follow where followerUserID = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Follow> followers = new ArrayList<Follow>();
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userID);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Follow follow = new Follow();
				follow.setFollowID(rs.getInt(1));
				follow.setFollowerUserID(rs.getInt(2));
				follow.setFollowingUserID(rs.getInt(3));
				followers.add(follow);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBConnection.close(rs);
			DBConnection.close(pstmt);
			DBConnection.close(conn);
		}
		return followers;
	}

	@Override
	public List<Follow> findFollowingUser(int userID) {
		Connection conn = DBConnection.getConnection();
		String sql = "select * from tb_follow where followingUserID = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Follow> followings = new ArrayList<Follow>();
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userID);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Follow follow = new Follow();
				follow.setFollowID(rs.getInt(1));
				follow.setFollowerUserID(rs.getInt(2));
				follow.setFollowingUserID(rs.getInt(3));
				followings.add(follow);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBConnection.close(rs);
			DBConnection.close(pstmt);
			DBConnection.close(conn);
		}
		return followings;
	}

	@Override
	public Follow findFollow(int followerUserID, int followingUserID) {
		Connection conn = DBConnection.getConnection();
		String sql = "select * from tb_follow where followerUserID = ? and followingUserID = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Follow follow = null;
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, followerUserID);
			pstmt.setInt(2, followingUserID);
			rs = pstmt.executeQuery();
			while(rs.next()){
				follow = new Follow();
				follow.setFollowID(rs.getInt(1));
				follow.setFollowerUserID(rs.getInt(2));
				follow.setFollowingUserID(rs.getInt(3));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBConnection.close(rs);
			DBConnection.close(pstmt);
			DBConnection.close(conn);
		}
		return follow;
	}
	

}
