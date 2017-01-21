package dao;

import java.util.List;

import bean.Group;

public interface GroupDao {
	public void addGroup(Group group);
	public Group findGroupByName(String groupName);
	public Group findGroupByID(int groupID);
	public List<Group> findAllGroup();
	public List<Group> findAllGroupOrderByUserNum();
	public List<Group> findAllGroupOrderByPostNum();
	public List<Group> findAllGroupByType(String groupType);
	public void addGroupUserNum(int groupID);
	public void addGroupPostNum(int groupID);
	public void subGroupUserNum(int groupID);
}
