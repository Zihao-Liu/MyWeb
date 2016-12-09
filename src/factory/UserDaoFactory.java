package factory;

import dao.UserDao;
import daoImpl.UserDaoImpl;

public class UserDaoFactory {
	public static UserDao getUserDaoInstance(){
		return new UserDaoImpl();
	}
}
