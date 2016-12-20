package dao;

import bean.Read;

public interface ReadDao {
	public void addRead(int bookID, int userID, float score);
	public Read findread(int bookID, int userID);
}
