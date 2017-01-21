package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import bean.GroupPostComment;
import dao.GroupPostCommentDao;
import util.DBConnection;

public class GroupPostCommentDaoImpl implements GroupPostCommentDao{

	@Override
	public void addComment(GroupPostComment groupPostComment) {
		Connection conn = DBConnection.getConnection();
		String sql = "insert into tb_groupcomment (commentTitle, commentContent, publishTime, userID, postID) values(?,?,?,?,?)";
		PreparedStatement pstmt = null;
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, groupPostComment.getCommentTitle());
			pstmt.setString(2, groupPostComment.getCommentContent());
			pstmt.setTimestamp(3, new Timestamp(groupPostComment.getPublishTime().getTime()));
			pstmt.setInt(4, groupPostComment.getUserID());
			pstmt.setInt(5, groupPostComment.getPostID());
			pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBConnection.close(pstmt);
			DBConnection.close(conn);
		}
		
	}

	@Override
	public void deleteComment(int commentID,int userID) {
		Connection conn = DBConnection.getConnection();
		String sql = "select commentApprove from tb_groupcomment where commentID = ?";
		String sql2 = "delete from tb_groupcomment where commentID=?";
		String sql3 = "update tb_user set userApprove = userApprove -? where userID =?";
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;
		ResultSet rs = null;
		try{
			pstmt1 = conn.prepareStatement(sql);
			pstmt1.setInt(1, commentID);
			rs = pstmt1.executeQuery();
			int i =0;
			while(rs.next()){
				i = rs.getInt(1);
			}
			pstmt2 = conn.prepareStatement(sql2);
			pstmt2.setInt(1, commentID);
			pstmt3 = conn.prepareStatement(sql3);
			pstmt3.setInt(1, i);
			pstmt3.setInt(2, userID);
			pstmt2.executeUpdate();
			pstmt3.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBConnection.close(rs);
			DBConnection.close(pstmt1);
			DBConnection.close(pstmt2);
			DBConnection.close(pstmt2);
			DBConnection.close(conn);
		}
		
	}

	@Override
	public GroupPostComment findPostCommentByCommentID(int commentID) {
		Connection conn = DBConnection.getConnection();
		String findbysql  = "select * from tb_groupcomment where commentID= ?";
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		GroupPostComment comment = new GroupPostComment();
		try{
			pstmt = conn.prepareStatement(findbysql);
			pstmt.setInt(1, commentID);
			rs = pstmt.executeQuery();
			while(rs.next()){
				comment.setCommentID(rs.getInt(1));
				comment.setCommentTitle(rs.getString(2));
				comment.setCommentContent(rs.getString(3));
				comment.setPublishTime(rs.getDate(4));
				comment.setUserID(rs.getInt(5));
				comment.setPostID(rs.getInt(6));
				comment.setCommentApprove(rs.getInt(7));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBConnection.close(rs);
			DBConnection.close(pstmt);
			DBConnection.close(conn);
		}
		return comment;
	}

	@Override
	public List<GroupPostComment> findAllCommentByUserID(int userID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GroupPostComment> findAllCommentByPostID(int postID) {
		Connection conn = DBConnection.getConnection();
		String findbysql  = "select * from tb_groupcomment where postID= ? order by publishTime Desc";
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		List<GroupPostComment> groupPostComments = new ArrayList<GroupPostComment>();
		try{
			pstmt = conn.prepareStatement(findbysql);
			pstmt.setInt(1, postID);
			rs = pstmt.executeQuery();
			while(rs.next()){
				GroupPostComment groupPostComment = new GroupPostComment();
				groupPostComment.setCommentID(rs.getInt(1));
				groupPostComment.setCommentTitle(rs.getString(2));
				groupPostComment.setCommentContent(rs.getString(3));
				groupPostComment.setPublishTime(rs.getDate(4));
				groupPostComment.setUserID(rs.getInt(5));
				groupPostComment.setPostID(rs.getInt(6));
				groupPostComment.setCommentApprove(rs.getInt(7));
				groupPostComments.add(groupPostComment);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBConnection.close(rs);
			DBConnection.close(pstmt);
			DBConnection.close(conn);
		}
		return groupPostComments;
	}

}
