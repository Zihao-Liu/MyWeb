package dao;

import java.util.List;

import bean.Status;

public interface StatusDao {
	public void addStatus(Status status);
	public List<Status> findAllStatus();
	public List<Status> findStatusByUserID(int userID);
}
