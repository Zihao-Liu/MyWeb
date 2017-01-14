package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.User;
import dao.UserDao;
import util.DBConnection;

public class UserDaoImpl implements UserDao{
	
	@Override
	public User findUserByName(String userName){
		Connection conn = DBConnection.getConnection();
		String findBySQL = "select * from tb_user where userName = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		User user = null;
		try{
			pstmt = conn.prepareStatement(findBySQL);
			pstmt.setString(1, userName);
			rs = pstmt.executeQuery();
			if(rs.next()){
				user = new User();
				user.setUserID(rs.getInt(1));
				user.setUserName(rs.getString(2));
				user.setUserSex(rs.getString(3));
				user.setPassword(rs.getString(4));
				user.setUserApprove(rs.getInt(5));
				user.setUserRead(rs.getInt(6));
				user.setUserWatch(rs.getInt(7));
				user.setUserHide(rs.getInt(8));
				user.setUserFollower(rs.getInt(9));
				user.setUserFollowing(rs.getInt(10));
				user.setUserAttend(rs.getInt(11));
			}
		}catch(SQLException e){
				e.printStackTrace();
		}finally{
			DBConnection.close(rs);
			DBConnection.close(pstmt);
			DBConnection.close(conn);
		}
		return user;
	}
	@Override
	public void addUser(User user) {
		Connection conn = DBConnection.getConnection();
		String sql = "insert into tb_user(userName,userSex,password) values(?,?,?)";
		PreparedStatement pstmt = null;
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getUserName());
			pstmt.setString(2, user.getUserSex());
			pstmt.setString(3, user.getPassword());
			pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBConnection.close(pstmt);
			DBConnection.close(conn);
		}
	}
	
	@Override
	public void deleteUser(int userID) {
		
		
	}
	@Override
	public List<User> findAllUser() {
		Connection conn = DBConnection.getConnection();
		String findbysql  = "select * from tb_user";
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		List<User> users = new ArrayList<User>();
		try{
			pstmt = conn.prepareStatement(findbysql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				User user = new User();
				user.setUserID(rs.getInt(1));
				user.setUserName(rs.getString(2));
				user.setUserSex(rs.getString(3));
				user.setUserApprove(rs.getInt(5));
				user.setUserRead(rs.getInt(6));
				user.setUserWatch(rs.getInt(7));
				user.setUserHide(rs.getInt(8));
				user.setUserFollower(rs.getInt(9));
				user.setUserFollowing(rs.getInt(10));
				user.setUserAttend(rs.getInt(11));
				users.add(user);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBConnection.close(rs);
			DBConnection.close(pstmt);
			DBConnection.close(conn);
		}
		return users;
	}
	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public User findUserByID(int userID) {
		Connection conn = DBConnection.getConnection();
		String fingBySql = "select * from tb_user where userID = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		User user = new User();
		try{
			pstmt = conn.prepareStatement(fingBySql);
			pstmt.setInt(1, userID);
			rs = pstmt.executeQuery();
			while(rs.next()){
				user.setUserID(rs.getInt(1));
				user.setUserName(rs.getString(2));
				user.setUserSex(rs.getString(3));
				user.setPassword(rs.getString(4));
				user.setUserApprove(rs.getInt(5));
				user.setUserRead(rs.getInt(6));
				user.setUserWatch(rs.getInt(7));
				user.setUserHide(rs.getInt(8));
				user.setUserFollower(rs.getInt(9));
				user.setUserFollowing(rs.getInt(10));
				user.setUserAttend(rs.getInt(11));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBConnection.close(rs);
			DBConnection.close(pstmt);
			DBConnection.close(conn);
		}
		return user;
	}
	@Override
	public void modifyUserApprove(int userID, int action) {
		Connection conn = DBConnection.getConnection();
		String sql;
		if(action == 1)
			sql="update tb_user set userApprove = userApprove +1 where userID = ?";
		else
			sql="update tb_user set userApprove = userApprove -1 where userID = ?";
		PreparedStatement pstmt = null;
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userID);
			pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBConnection.close(pstmt);
			DBConnection.close(conn);
		}
	}
	@Override
	public List<User> findAllUserOrderByApprove() {
		Connection conn = DBConnection.getConnection();
		String findbysql  = "select * from tb_user order by userApprove Desc";
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		List<User> users = new ArrayList<User>();
		try{
			pstmt = conn.prepareStatement(findbysql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				User user = new User();
				user.setUserID(rs.getInt(1));
				user.setUserName(rs.getString(2));
				user.setUserSex(rs.getString(3));
				user.setUserApprove(rs.getInt(5));
				user.setUserRead(rs.getInt(6));
				user.setUserWatch(rs.getInt(7));
				user.setUserHide(rs.getInt(8));
				user.setUserFollower(rs.getInt(9));
				user.setUserFollowing(rs.getInt(10));
				user.setUserAttend(rs.getInt(11));
				users.add(user);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBConnection.close(rs);
			DBConnection.close(pstmt);
			DBConnection.close(conn);
		}
		return users;
	}
	@Override
	public List<User> findAlluserOrderByRead() {
		Connection conn = DBConnection.getConnection();
		String findbysql  = "select * from tb_user order by userRead Desc";
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		List<User> users = new ArrayList<User>();
		try{
			pstmt = conn.prepareStatement(findbysql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				User user = new User();
				user.setUserID(rs.getInt(1));
				user.setUserName(rs.getString(2));
				user.setUserSex(rs.getString(3));
				user.setUserApprove(rs.getInt(5));
				user.setUserRead(rs.getInt(6));
				user.setUserWatch(rs.getInt(7));
				user.setUserHide(rs.getInt(8));
				user.setUserFollower(rs.getInt(9));
				user.setUserFollowing(rs.getInt(10));
				user.setUserAttend(rs.getInt(11));
				users.add(user);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBConnection.close(rs);
			DBConnection.close(pstmt);
			DBConnection.close(conn);
		}
		return users;
	}
	@Override
	public void modifyUserRead(int userID) {
		Connection conn = DBConnection.getConnection();
		String sql="update tb_user set userRead= userRead +1 where userID = ?";
		PreparedStatement pstmt = null;
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userID);
			pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBConnection.close(pstmt);
			DBConnection.close(conn);
		}
		
	}
	@Override
	public void modifyUserWatch(int userID) {
		Connection conn = DBConnection.getConnection();
		String sql="update tb_user set userWatch= userWatch +1 where userID = ?";
		PreparedStatement pstmt = null;
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userID);
			pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBConnection.close(pstmt);
			DBConnection.close(conn);
		}
		
	}
	@Override
	public List<User> findAlluserOrderByWatch() {
		Connection conn = DBConnection.getConnection();
		String findbysql  = "select * from tb_user order by userWatch Desc";
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		List<User> users = new ArrayList<User>();
		try{
			pstmt = conn.prepareStatement(findbysql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				User user = new User();
				user.setUserID(rs.getInt(1));
				user.setUserName(rs.getString(2));
				user.setUserSex(rs.getString(3));
				user.setUserApprove(rs.getInt(5));
				user.setUserRead(rs.getInt(6));
				user.setUserWatch(rs.getInt(7));
				user.setUserHide(rs.getInt(8));
				user.setUserFollower(rs.getInt(9));
				user.setUserFollowing(rs.getInt(10));
				user.setUserAttend(rs.getInt(11));
				users.add(user);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBConnection.close(rs);
			DBConnection.close(pstmt);
			DBConnection.close(conn);
		}
		return users;
	}
	@Override
	public void modifyUserHide(int userID,int hide) {
		Connection conn = DBConnection.getConnection();
		String sql = null;
		if(hide ==1)
			sql="update tb_user set userHide= 1 where userID = ?";
		else 
			sql="update tb_user set userHide= 0 where userID = ?";
		PreparedStatement pstmt = null;
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userID);
			pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBConnection.close(pstmt);
			DBConnection.close(conn);
		}
	}
}
