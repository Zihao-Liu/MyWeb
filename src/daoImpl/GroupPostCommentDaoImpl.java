package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import bean.GroupPostComment;
import dao.GroupPostCommentDao;
import util.DBConnection;

public class GroupPostCommentDaoImpl implements GroupPostCommentDao{

	@Override
	public void addComment(GroupPostComment groupPostComment) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteComment(int groupPostCommentID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public GroupPostComment findPostCommentByCommentID(int commentID) {
		// TODO Auto-generated method stub
		return null;
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
