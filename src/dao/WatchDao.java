package dao;

import bean.Watch;

public interface WatchDao {
	public void addWatch(int filmID, int userID, float score);
	public Watch findWatch(int filmID, int userID);
	public void deleteWatch(int filmID, int userID, float filmScore);//部分功能应该添加到filmDao里
}
