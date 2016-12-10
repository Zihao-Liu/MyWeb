package factory;

import dao.ApproveDao;
import daoImpl.ApproveDaoImpl;

public class ApproveDaoFactory {
	public static ApproveDao getApproveDaoInstance(){
		return new ApproveDaoImpl();
	}
}
