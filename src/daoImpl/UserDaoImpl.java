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
	public User findUser(String userName){
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
		String fingBySql = "select * from tb_user whereuserID = ?";
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
				user.setUserSex(rs.getString(4));
				user.setPassword(rs.getString(5));
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
}
