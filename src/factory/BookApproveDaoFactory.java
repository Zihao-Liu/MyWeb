package factory;

import dao.BookApproveDao;
import daoImpl.BookApproveDaoImpl;

public class BookApproveDaoFactory {
	public static BookApproveDao getApproveDaoInstance(){
		return new BookApproveDaoImpl();
	}
}
