package dao;


import bean.Read;

public interface ReadDao {
	public void addRead(int bookID, int userID, float score);
	public Read findRead(int bookID, int userID);
	public void deleteRead(int bookID, int userID,float score);//部分功能应该调整到bookDao里
}
