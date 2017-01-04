package dao;

import java.util.List;

import bean.Film;



public interface FindWatchDao {
	public List<Film> findAllFilmWatch(int userID);
}
