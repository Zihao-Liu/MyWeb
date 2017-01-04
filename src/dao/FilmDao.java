package dao;

import java.util.List;

import bean.Film;



public interface FilmDao {
	public void addFilm(Film film);
	public void deleteFilm(String filmName);
	public Film findFilmByName(String filmName);
	public Film findFilmByDirector(String filmDirector);
	public Film findFilmByID(int filmID);
	public List<Film> findAllFilm();
	public List<Film> findAllFilmOrderByTime();
	public List<Film> findAllFilmOrderByWatch();
	public List<Film> findAllFilmOrderByScore();
	public List<Film> findAllFilmByType(String filmType);
	public void updateFilm(Film film);
	public void modifyFilmWatch(int filmID,float filmScore);
}
