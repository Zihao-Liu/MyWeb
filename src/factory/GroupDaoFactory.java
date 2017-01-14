package factory;

import dao.GroupDao;
import daoImpl.GroupDaoImpl;

public class GroupDaoFactory {
	public static GroupDao getGroupDaoInstance(){
		return new GroupDaoImpl();
	}
}
