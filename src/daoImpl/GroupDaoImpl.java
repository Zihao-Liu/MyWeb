package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Group;
import dao.GroupDao;
import util.DBConnection;

public class GroupDaoImpl implements GroupDao {

	@Override
	public void addGroup(Group group) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Group findGroupByName(String groupName) {
		Connection conn = DBConnection.getConnection();
		String findbysql = "select * from tb_group where groupName = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Group group = null;
		try{
			pstmt = conn.prepareStatement(findbysql);
			pstmt.setString(1, groupName);
			rs = pstmt.executeQuery();
			while(rs.next()){
				group= new Group();
				group.setGroupID(rs.getInt(1));
				group.setGroupName(rs.getString(2));
				group.setGroupType(rs.getString(3));
				group.setGroupInfo(rs.getString(4));
				group.setGroupUserNum(rs.getInt(5));
				group.setGroupPostNum(rs.getInt(6));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBConnection.close(rs);
			DBConnection.close(pstmt);
			DBConnection.close(conn);
		}
		return group;
	}

	@Override
	public Group findGroupByID(int groupID) {
		Connection conn = DBConnection.getConnection();
		String fingBySql = "select * from tb_group where groupID = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Group group = new Group();
		try{
			pstmt = conn.prepareStatement(fingBySql);
			pstmt.setInt(1, groupID);
			rs = pstmt.executeQuery();
			while(rs.next()){
				group.setGroupID(rs.getInt(1));
				group.setGroupName(rs.getString(2));
				group.setGroupType(rs.getString(3));
				group.setGroupInfo(rs.getString(4));
				group.setGroupUserNum(rs.getInt(5));
				group.setGroupPostNum(rs.getInt(6));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBConnection.close(rs);
			DBConnection.close(pstmt);
			DBConnection.close(conn);
		}
		return group;
	}

	@Override
	public List<Group> findAllGroup() {
		Connection conn = DBConnection.getConnection();
		String findbysql = "select * from tb_group";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Group> groups = new ArrayList<Group>();
		try{
			pstmt = conn.prepareStatement(findbysql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Group group = new Group();
				group.setGroupID(rs.getInt(1));
				group.setGroupName(rs.getString(2));
				group.setGroupType(rs.getString(3));
				group.setGroupInfo(rs.getString(4));
				group.setGroupUserNum(rs.getInt(5));
				group.setGroupPostNum(rs.getInt(6));
				groups.add(group);
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

	@Override
	public List<Group> findAllGroupOrderByUserNum() {
		Connection conn = DBConnection.getConnection();
		String findbysql = "select * from tb_group order by groupUserNum Desc";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Group> groups = new ArrayList<Group>();
		try{
			pstmt = conn.prepareStatement(findbysql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Group group = new Group();
				group.setGroupID(rs.getInt(1));
				group.setGroupName(rs.getString(2));
				group.setGroupType(rs.getString(3));
				group.setGroupInfo(rs.getString(4));
				group.setGroupUserNum(rs.getInt(5));
				group.setGroupPostNum(rs.getInt(6));
				groups.add(group);
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

	@Override
	public List<Group> findGroupByType(String groupType) {
		Connection conn = DBConnection.getConnection();
		String sql="select * from tb_group where groupType = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Group> groups = new ArrayList<Group>();
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, groupType);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Group group = new Group();
				group.setGroupID(rs.getInt(1));
				group.setGroupName(rs.getString(2));
				group.setGroupType(rs.getString(3));
				group.setGroupInfo(rs.getString(4));
				group.setGroupUserNum(rs.getInt(5));
				group.setGroupPostNum(rs.getInt(6));
				groups.add(group);
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

	@Override
	public void addGroupUserNum(int groupID) {
		Connection conn = DBConnection.getConnection();
		String sql="update tb_group set groupUserNum = groupUserNum+1 where groupID = ?";
		PreparedStatement  pstmt = null;
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, groupID);
			pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBConnection.close(pstmt);
			DBConnection.close(conn);
		}
		
	}

	@Override
	public void addGroupPostNum(int groupID) {
		Connection conn = DBConnection.getConnection();
		String sql="update tb_group set groupPostNum = groupPostNum+1 where groupID = ?";
		PreparedStatement  pstmt = null;
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, groupID);
			pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBConnection.close(pstmt);
			DBConnection.close(conn);
		}
		
	}

}
