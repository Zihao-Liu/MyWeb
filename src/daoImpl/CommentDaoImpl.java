package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


import bean.Comment;
import dao.CommentDao;
import util.DBConnection;

public class CommentDaoImpl implements CommentDao{

	@Override
	public void addComment(Comment comment){
		Connection conn = DBConnection.getConnection();
		String sql = "insert into tb_comment (commentTitle, commentContent, publishTime, userID, bookID) values(?,?,?,?,?)";
		PreparedStatement pstmt = null;
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, comment.getCommentTitle());
			pstmt.setString(2, comment.getCommentContent());
			pstmt.setTimestamp(3, new Timestamp(comment.getPublishTime().getTime()));
			pstmt.setInt(4, comment.getUserID());
			pstmt.setInt(5, comment.getBookID());
			pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBConnection.close(pstmt);
			DBConnection.close(conn);
		}
		
	}

	@Override
	public void deleteComment(Comment comment) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Comment> findCommentByBookName(String nookName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Comment> findCommentByBookID(int bookID) {
		Connection conn = DBConnection.getConnection();
		String findbysql  = "select * from tb_comment where bookID= ?";
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		List<Comment> comments = new ArrayList<Comment>();
		try{
			pstmt = conn.prepareStatement(findbysql);
			pstmt.setInt(1, bookID);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Comment comment = new Comment();
				comment.setCommentID(rs.getInt(1));
				comment.setCommentTitle(rs.getString(2));
				comment.setCommentContent(rs.getString(3));
				comment.setPublishTime(rs.getDate(4));
				comment.setUserID(rs.getInt(5));
				comment.setBookID(rs.getInt(6));
				comment.setCommentApprove(rs.getInt(7));
				comments.add(comment);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBConnection.close(rs);
			DBConnection.close(pstmt);
			DBConnection.close(conn);
		}
		return comments;
	}

	@Override
	public List<Comment> findCommentByUserName(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateComment(Comment comment) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifyCommentApprove(int commentID, int action) {
		Connection conn = DBConnection.getConnection();
		String sql;
		if(action == 1)
			sql = "update tb_comment set commentApprove = commentApprove+1 where commentID = ?";
		else
			sql = "update tb_comment set commentApprove = commentApprove-1 where commentID = ?";
		
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

	@Override
	public Comment findCommentByCommentID(int commentID) {
		Connection conn = DBConnection.getConnection();
		String findbysql  = "select * from tb_comment where commentID= ?";
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		Comment comment = new Comment();
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
				comment.setBookID(rs.getInt(6));
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

}
