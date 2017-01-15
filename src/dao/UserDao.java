package dao;

import java.util.List;

import bean.User;

public interface UserDao {
	public void addUser(User user);
	public void deleteUser(int userID);
	public User findUserByName(String userName);
	public User findUserByID(int userID);
	public List<User> findAllUser();
	public List<User> findAllUserOrderByApprove();
	public List<User> findAlluserOrderByRead();
	public List<User> findAlluserOrderByWatch();
	public void updateUser(User user);
	public void modifyUserApprove(int userID,int action);
	public void modifyUserRead(int userID);
	public void modifyUserWatch(int userID);
	public void modifyUserHide(int userID,int hide);
	public void addUserAttend(int userID);
}
