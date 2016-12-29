package factory;

import dao.StatusDao;
import daoImpl.StatusDaoImpl;

public class StatusDaoFactory {
	public static StatusDao getStatusDaoInstance(){
		return new StatusDaoImpl();
	}
}
