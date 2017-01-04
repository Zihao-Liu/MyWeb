package dao;

import bean.Read;

public interface ReadDao {
	public void addRead(int bookID, int userID, float score);
	public Read findRead(int bookID, int userID);
}
