package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Film;
import dao.FilmDao;
import dao.FindWatchDao;
import factory.FilmDaoFactory;
import util.DBConnection;

public class FindWatchDaoImpl implements FindWatchDao {
	public List<Film> findAllFilmWatch(int userID) {
		Connection conn = DBConnection.getConnection();
		String sql = "select filmID from tb_watch where userID=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List <Film> films = new ArrayList<Film>();
		try{
			FilmDao filmDao = FilmDaoFactory.getFilmDaoInstance();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userID);
			rs = pstmt.executeQuery();
			while(rs.next()){
				films.add(filmDao.findFilmByID(rs.getInt(1)));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBConnection.close(rs);
			DBConnection.close(pstmt);
			DBConnection.close(conn);
		}
		return films;
	}
}
