package factory;

import dao.LetterDao;
import daoImpl.LetterDaoImpl;

public class LetterDaoFactory {
	public static LetterDao getLetterDaoInstance(){
		return new LetterDaoImpl();
	}
}
