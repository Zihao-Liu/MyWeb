package factory;

import dao.GroupPostCommentDao;
import daoImpl.GroupPostCommentDaoImpl;

public class GroupPostCommentDaoFactory {
	public static GroupPostCommentDao getGroupPostCommentDaoInstance(){
		return new GroupPostCommentDaoImpl();
	}
}
