package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import bean.AttendGroup;
import dao.AttendGroupDao;
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
	public List<AttendGroup> findAllAttendGroup(int userID) {
		Connection conn = DBConnection.getConnection();
		String sql = "select * from tb_attendgroup where userID = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<AttendGroup> attendGroups = new ArrayList<AttendGroup>();
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userID);
			rs = pstmt.executeQuery();
			while(rs.next()){
				AttendGroup attendGroup = new AttendGroup();
				attendGroup.setAttendID(rs.getInt(1));
				attendGroup.setGroupID(rs.getInt(2));
				attendGroup.setUserID(rs.getInt(3));
				attendGroups.add(attendGroup);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBConnection.close(rs);
			DBConnection.close(pstmt);
			DBConnection.close(conn);
		}
		return attendGroups;
	}
	
}
