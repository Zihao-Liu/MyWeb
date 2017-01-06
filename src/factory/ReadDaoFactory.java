package factory;

import dao.ReadDao;
import daoImpl.ReadDaoImpl;

public class ReadDaoFactory {
	public static ReadDao getReadDaoInstance(){
		return new ReadDaoImpl();
	}
}
