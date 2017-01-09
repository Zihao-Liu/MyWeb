package factory;

import dao.FollowDao;
import daoImpl.FollowDaoImpl;

public class FollowDaoFactory {
	public static FollowDao getFollowDaoInstance(){
		return new FollowDaoImpl();
	}
}
