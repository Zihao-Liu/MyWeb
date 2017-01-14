package factory;

import dao.AttendGroupDao;
import daoImpl.AttendGroupDaoImpl;

public class AttendGroupDaoFactory {
	public static AttendGroupDao getAttendGroupDaoInstance(){
		return new AttendGroupDaoImpl();
	}
}
