package dao;

import java.util.List;

import bean.AttendGroup;

public interface AttendGroupDao {
	public void attend(int userID, int groupID);
	public void delete(int userID, int groupID);
	public AttendGroup findAttendGroup(int userID,int groupID);
	public List<AttendGroup> findAllAttendGroup(int userID);
}
