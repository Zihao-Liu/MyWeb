package dao;

import java.util.List;

import bean.Film;



public interface FindWatchDao {
	public List<Film> findAllFilmWatch(int userID);//应该移到watchDao里
}
