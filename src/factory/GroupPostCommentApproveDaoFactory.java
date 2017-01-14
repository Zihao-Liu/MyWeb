package factory;

import dao.GroupPostCommentApproveDao;
import daoImpl.GroupPostCommentApproveDaoImpl;

public class GroupPostCommentApproveDaoFactory {
	public static GroupPostCommentApproveDao getGroupPostCommentApproveDaoInstance(){
		return new GroupPostCommentApproveDaoImpl();
	}
}
