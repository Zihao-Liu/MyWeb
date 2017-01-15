package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import bean.AttendGroup;
import bean.Group;
import dao.AttendGroupDao;
import dao.GroupDao;
import factory.GroupDaoFactory;
import util.DBConnection;

public class AttendGroupDaoImpl implements AttendGroupDao {

	@Override
	public void attend(int userID, int groupID) {
		Connection conn = DBConnection.getConnection();
		String sql = "insert into tb_attendgroup (groupID,userID) values(?,?)";
		PreparedStatement pstmt = null;
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, groupID);
			pstmt.setInt(2, userID);
			pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBConnection.close(pstmt);
			DBConnection.close(conn);
		}
		
	}

	@Override
	public void delete(int userID, int groupID) {
		Connection conn = DBConnection.getConnection();
		String sql = "delete from tb_attendgroup where groupID = ? and userID = ?";
		PreparedStatement pstmt = null;
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, groupID);
			pstmt.setInt(2, userID);
			pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBConnection.close(pstmt);
			DBConnection.close(conn);
		}
	}

	@Override
	public AttendGroup findAttendGroup(int userID, int groupID) {
		Connection conn = DBConnection.getConnection();
		String sql = "select * from tb_attendgroup where groupID = ? and userID = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		AttendGroup attendGroup = null;
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, groupID);
			pstmt.setInt(2, userID);
			rs = pstmt.executeQuery();
			while(rs.next()){
				attendGroup = new AttendGroup();
				attendGroup.setAttendID(rs.getInt(1));
				attendGroup.setGroupID(rs.getInt(2));
				attendGroup.setUserID(rs.getInt(3));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBConnection.close(rs);
			DBConnection.close(pstmt);
			DBConnection.close(conn);
		}
		return attendGroup;
	}

	@Override
	public List<Group> findAllAttendGroup(int userID) {
		Connection conn = DBConnection.getConnection();
		String sql = "select * from tb_attendgroup where userID = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Group> groups = new ArrayList<Group>();
		try{
			GroupDao groupDao = GroupDaoFactory.getGroupDaoInstance();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userID);
			rs = pstmt.executeQuery();
			while(rs.next()){
				groups.add(groupDao.findGroupByID(rs.getInt(2)));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBConnection.close(rs);
			DBConnection.close(pstmt);
			DBConnection.close(conn);
		}
		return groups;
	}
	
}
