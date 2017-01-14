package factory;

import dao.GroupPostApproveDao;
import daoImpl.GroupPostApproveDaoImpl;

public class GroupPostApproveDaoFactory {
	public static GroupPostApproveDao getGroupPostApproveDaoInstance(){
		return new GroupPostApproveDaoImpl();
	}
}
