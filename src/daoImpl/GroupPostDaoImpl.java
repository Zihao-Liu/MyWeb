package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import bean.GroupPost;
import dao.GroupPostDao;
import util.DBConnection;

public class GroupPostDaoImpl implements GroupPostDao {

	@Override
	public void addPost(GroupPost groupPost) {
		Connection conn = DBConnection.getConnection();
		String sql = "insert into tb_grouppost (postTitle, postContent, publishTime, groupID,userID,) values(?,?,?,?,?)";
		PreparedStatement pstmt = null;
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, groupPost.getPostTitle());
			pstmt.setString(2, groupPost.getPostContent());
			pstmt.setTimestamp(3, new Timestamp(groupPost.getPublishTime().getTime()));
			pstmt.setInt(4, groupPost.getGroupID());
			pstmt.setInt(5, groupPost.getUserID());
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

}