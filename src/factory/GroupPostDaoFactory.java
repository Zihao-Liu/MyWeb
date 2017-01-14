package factory;

import dao.GroupPostDao;
import daoImpl.GroupPostDaoImpl;

public class GroupPostDaoFactory {
	public static GroupPostDao GroupPostDaoInstance(){
		return new GroupPostDaoImpl();
	}
}
