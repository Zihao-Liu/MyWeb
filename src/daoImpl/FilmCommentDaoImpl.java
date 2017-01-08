package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import bean.FilmComment;
import dao.FilmCommentDao;
import util.DBConnection;

public class FilmCommentDaoImpl implements FilmCommentDao {
	@Override
	public void addComment(FilmComment comment){
		Connection conn = DBConnection.getConnection();
		String sql = "insert into tb_filmcomment (commentTitle, commentContent, publishTime, userID, filmID) values(?,?,?,?,?)";
		PreparedStatement pstmt = null;
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, comment.getCommentTitle());
			pstmt.setString(2, comment.getCommentContent());
			pstmt.setTimestamp(3, new Timestamp(comment.getPublishTime().getTime()));
			pstmt.setInt(4, comment.getUserID());
			pstmt.setInt(5, comment.getFilmID());
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
		String sql = "select commentApprove from tb_filmcomment where commentID = ?";
		String sql2 = "delete from tb_filmcomment where commentID=?";
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
	public List<FilmComment> findCommentByFilmName(String nookName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FilmComment> findCommentByFilmID(int filmID) {
		Connection conn = DBConnection.getConnection();
		String findbysql  = "select * from tb_filmcomment where filmID= ?";
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		List<FilmComment> comments = new ArrayList<FilmComment>();
		try{
			pstmt = conn.prepareStatement(findbysql);
			pstmt.setInt(1, filmID);
			rs = pstmt.executeQuery();
			while(rs.next()){
				FilmComment comment = new FilmComment();
				comment.setCommentID(rs.getInt(1));
				comment.setCommentTitle(rs.getString(2));
				comment.setCommentContent(rs.getString(3));
				comment.setPublishTime(rs.getDate(4));
				comment.setUserID(rs.getInt(5));
				comment.setFilmID(rs.getInt(6));
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
	public List<FilmComment> findCommentByUserName(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateComment(FilmComment comment) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifyCommentApprove(int commentID, int action) {
		Connection conn = DBConnection.getConnection();
		String sql;
		if(action == 1)
			sql = "update tb_filmcomment set commentApprove = commentApprove+1 where commentID = ?";
		else
			sql = "update tb_filmcomment set commentApprove = commentApprove-1 where commentID = ?";
		
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
	public FilmComment findCommentByCommentID(int commentID) {
		Connection conn = DBConnection.getConnection();
		String findbysql  = "select * from tb_filmcomment where commentID= ?";
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		FilmComment comment = new FilmComment();
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
				comment.setFilmID(rs.getInt(6));
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
	public List<FilmComment> findCommentOrderByApprove() {
		Connection conn = DBConnection.getConnection();
		String sql = "select * from tb_filmcomment order by commentApprove DESC";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<FilmComment> comments = new ArrayList<FilmComment>();
		try{
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				FilmComment comment = new FilmComment();
				comment.setCommentID(rs.getInt(1));
				comment.setCommentID(rs.getInt(1));
				comment.setCommentTitle(rs.getString(2));
				comment.setCommentContent(rs.getString(3));
				comment.setPublishTime(rs.getDate(4));
				comment.setUserID(rs.getInt(5));
				comment.setFilmID(rs.getInt(6));
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
	public List<FilmComment> findCommentByFilmIDOrderByApprove(int filmID) {
		Connection conn = DBConnection.getConnection();
		String findbysql  = "select * from tb_filmcomment where filmID= ? order by commentApprove DESC";
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		List<FilmComment> comments = new ArrayList<FilmComment>();
		try{
			pstmt = conn.prepareStatement(findbysql);
			pstmt.setInt(1, filmID);
			rs = pstmt.executeQuery();
			while(rs.next()){
				FilmComment comment = new FilmComment();
				comment.setCommentID(rs.getInt(1));
				comment.setCommentTitle(rs.getString(2));
				comment.setCommentContent(rs.getString(3));
				comment.setPublishTime(rs.getDate(4));
				comment.setUserID(rs.getInt(5));
				comment.setFilmID(rs.getInt(6));
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
	public List<FilmComment> findCommentByFilmIDOrderByPublishTime(int filmID) {
		Connection conn = DBConnection.getConnection();
		String findbysql  = "select * from tb_filmcomment where filmID= ? order by publishTime DESC";
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		List<FilmComment> comments = new ArrayList<FilmComment>();
		try{
			pstmt = conn.prepareStatement(findbysql);
			pstmt.setInt(1, filmID);
			rs = pstmt.executeQuery();
			while(rs.next()){
				FilmComment comment = new FilmComment();
				comment.setCommentID(rs.getInt(1));
				comment.setCommentTitle(rs.getString(2));
				comment.setCommentContent(rs.getString(3));
				comment.setPublishTime(rs.getDate(4));
				comment.setUserID(rs.getInt(5));
				comment.setFilmID(rs.getInt(6));
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
}
