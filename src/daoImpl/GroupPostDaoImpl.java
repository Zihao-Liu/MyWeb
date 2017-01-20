package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import bean.GroupPost;
import bean.GroupPostComment;
import dao.GroupPostDao;
import util.DBConnection;

public class GroupPostDaoImpl implements GroupPostDao {

	@Override
	public void addPost(GroupPost groupPost) {
		Connection conn = DBConnection.getConnection();
		String sql = "insert into tb_grouppost (postTitle, postContent, publishTime, groupID,userID,recentModifyTime) values(?,?,?,?,?,?)";
		PreparedStatement pstmt = null;
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, groupPost.getPostTitle());
			pstmt.setString(2, groupPost.getPostContent());
			pstmt.setTimestamp(3, new Timestamp(groupPost.getPublishTime().getTime()));
			pstmt.setInt(4, groupPost.getGroupID());
			pstmt.setInt(5, groupPost.getUserID());
			pstmt.setTimestamp(6, new Timestamp(groupPost.getRecentModifyTime().getTime()));
			pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBConnection.close(pstmt);
			DBConnection.close(conn);
		}
		
	}

	@Override
	public void deletePost(int groupPostID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public GroupPost findPostByPostID(int postID) {
		Connection conn = DBConnection.getConnection();
		String findbysql  = "select * from tb_grouppost where postID= ?";
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		GroupPost groupPost = new GroupPost();
		try{
			pstmt = conn.prepareStatement(findbysql);
			pstmt.setInt(1, postID);
			rs = pstmt.executeQuery();
			while(rs.next()){
				groupPost.setPostID(rs.getInt(1));
				groupPost.setPostTitle(rs.getString(2));
				groupPost.setPostContent(rs.getString(3));
				groupPost.setPublishTime(rs.getDate(4));
				groupPost.setGroupID(rs.getInt(5));
				groupPost.setUserID(rs.getInt(6));
				groupPost.setCommentNum(rs.getInt(7));
				groupPost.setPostApprove(rs.getInt(8));
				groupPost.setRecentModifyTime(rs.getDate(9));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBConnection.close(rs);
			DBConnection.close(pstmt);
			DBConnection.close(conn);
		}
		return groupPost;
	}

	@Override
	public List<GroupPost> findAllPostByUserID(int userID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GroupPost> findAllPostByGroupID(int groupID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GroupPost> findAllPostOrderByCommentNum() {
		// TODO Auto-generated method stub
				return null;
	}

	@Override
	public List<GroupPost> findPostByGroupIDOrderByPublishTime(int groupID) {
		Connection conn = DBConnection.getConnection();
		String findbysql  = "select * from tb_grouppost where groupID= ? order by publishTime Desc";
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		List<GroupPost> groupPosts = new ArrayList<GroupPost>();
		try{
			pstmt = conn.prepareStatement(findbysql);
			pstmt.setInt(1, groupID);
			rs = pstmt.executeQuery();
			while(rs.next()){
				GroupPost groupPost = new GroupPost();
				groupPost.setPostID(rs.getInt(1));
				groupPost.setPostTitle(rs.getString(2));
				groupPost.setPostContent(rs.getString(3));
				groupPost.setPublishTime(rs.getDate(4));
				groupPost.setGroupID(rs.getInt(5));
				groupPost.setUserID(rs.getInt(6));
				groupPost.setCommentNum(rs.getInt(7));
				groupPost.setPostApprove(rs.getInt(8));
				groupPost.setRecentModifyTime(rs.getDate(9));
				groupPosts.add(groupPost);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBConnection.close(rs);
			DBConnection.close(pstmt);
			DBConnection.close(conn);
		}
		return groupPosts;
	}

	@Override
	public List<GroupPost> findPostByGroupIDOrderByRecentModifyTime(int groupID) {
		Connection conn = DBConnection.getConnection();
		String findbysql  = "select * from tb_grouppost where groupID= ? order by recentModifyTime Desc";
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		List<GroupPost> groupPosts = new ArrayList<GroupPost>();
		try{
			pstmt = conn.prepareStatement(findbysql);
			pstmt.setInt(1, groupID);
			rs = pstmt.executeQuery();
			while(rs.next()){
				GroupPost groupPost = new GroupPost();
				groupPost.setPostID(rs.getInt(1));
				groupPost.setPostTitle(rs.getString(2));
				groupPost.setPostContent(rs.getString(3));
				groupPost.setPublishTime(rs.getDate(4));
				groupPost.setGroupID(rs.getInt(5));
				groupPost.setUserID(rs.getInt(6));
				groupPost.setCommentNum(rs.getInt(7));
				groupPost.setPostApprove(rs.getInt(8));
				groupPost.setRecentModifyTime(rs.getDate(9));
				groupPosts.add(groupPost);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBConnection.close(rs);
			DBConnection.close(pstmt);
			DBConnection.close(conn);
		}
		return groupPosts;
	}

	@Override
	public void updateRecentModifyTime(GroupPostComment groupPostComment) {
		Connection conn = DBConnection.getConnection();
		String sql = "update tb_grouppost set recentModifyTime = ? where postID = ?";
		PreparedStatement pstmt = null;
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setTimestamp(1, (new Timestamp(groupPostComment.getPublishTime().getTime())));
			pstmt.setInt(2, groupPostComment.getPostID());
			pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBConnection.close(pstmt);
			DBConnection.close(conn);
		}
	}

	@Override
	public void addCommentNum(int postID) {
		Connection conn = DBConnection.getConnection();
		String sql="update tb_grouppost set commentNum = commentNum+1 where postID = ?";
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
