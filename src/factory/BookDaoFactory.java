package factory;

import dao.BookDao;
import daoImpl.BookDaoImpl;

public class BookDaoFactory {
	public static BookDao getBookDaoInstance(){
		return new BookDaoImpl();
	}
}
