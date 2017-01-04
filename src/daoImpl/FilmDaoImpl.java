package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import bean.Film;
import dao.FilmDao;
import util.DBConnection;

public class FilmDaoImpl implements FilmDao{
	@Override
	public void addFilm(Film film) {
		Connection conn = DBConnection.getConnection();
		String sql = "insert into tb_film (filmName,filmDirector,filmType,filmInfo,filmAddTime) values(?,?,?,?,?)";
		PreparedStatement pstmt = null;
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, film.getFilmName());
			pstmt.setString(2, film.getFilmDirector());
			pstmt.setString(3, film.getFilmType());
			pstmt.setString(4, film.getFilmInfo());
			pstmt.setTimestamp(5, new Timestamp(film.getFilmAddTime().getTime()));
			pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBConnection.close(pstmt);
			DBConnection.close(conn);
		}
	}

	@Override
	public void deleteFilm(String filmName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Film findFilmByName(String filmName) {
		Connection conn = DBConnection.getConnection();
		String findbysql = "select * from tb_film where filmName = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Film film = null;
		try{
			pstmt = conn.prepareStatement(findbysql);
			pstmt.setString(1, filmName);
			rs = pstmt.executeQuery();
			while(rs.next()){
				film = new Film();
				film.setFilmID(rs.getInt(1));
				film.setFilmName(rs.getString(2));
				film.setFilmDirector(rs.getString(3));
				film.setFilmType(rs.getString(4));
				film.setFilmInfo(rs.getString(5));
				film.setFilmAddTime(rs.getDate(6));
				film.setFilmCoverPath(rs.getString(7));
				film.setFilmWatch(rs.getInt(8));
				film.setFilmScore(rs.getFloat(9));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBConnection.close(rs);
			DBConnection.close(pstmt);
			DBConnection.close(conn);
		}
		return film;
	}

	@Override
	public Film findFilmByDirector(String filmDirector) {
		Connection conn = DBConnection.getConnection();
		String findbysql = "select * from tb_film where filmDirector = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Film film = null;
		try{
			pstmt = conn.prepareStatement(findbysql);
			pstmt.setString(1, filmDirector);
			rs = pstmt.executeQuery();
			while(rs.next()){
				film = new Film();
				film.setFilmID(rs.getInt(1));
				film.setFilmName(rs.getString(2));
				film.setFilmDirector(rs.getString(3));
				film.setFilmType(rs.getString(4));
				film.setFilmInfo(rs.getString(5));
				film.setFilmAddTime(rs.getDate(6));
				film.setFilmCoverPath(rs.getString(7));
				film.setFilmWatch(rs.getInt(8));
				film.setFilmScore(rs.getFloat(9));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBConnection.close(rs);
			DBConnection.close(pstmt);
			DBConnection.close(conn);
		}
		return film;
	}
	
	
	@Override
	public Film findFilmByID(int filmID) {
		Connection conn = DBConnection.getConnection();
		String fingBySql = "select * from tb_film where filmID = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Film film = new Film();
		try{
			pstmt = conn.prepareStatement(fingBySql);
			pstmt.setInt(1, filmID);
			rs = pstmt.executeQuery();
			while(rs.next()){
				film.setFilmID(rs.getInt(1));
				film.setFilmName(rs.getString(2));
				film.setFilmDirector(rs.getString(3));
				film.setFilmType(rs.getString(4));
				film.setFilmInfo(rs.getString(5));
				film.setFilmAddTime(rs.getDate(6));
				film.setFilmCoverPath(rs.getString(7));
				film.setFilmWatch(rs.getInt(8));
				film.setFilmScore(rs.getFloat(9));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBConnection.close(rs);
			DBConnection.close(pstmt);
			DBConnection.close(conn);
		}
		return film;
	}

	
	@Override
	public List<Film> findAllFilm() {
		Connection conn = DBConnection.getConnection();
		String findbysql = "select * from tb_film";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Film> films = new ArrayList<Film>();
		try{
			pstmt = conn.prepareStatement(findbysql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Film film = new Film();
				film.setFilmID(rs.getInt(1));
				film.setFilmName(rs.getString(2));
				film.setFilmDirector(rs.getString(3));
				film.setFilmType(rs.getString(4));
				film.setFilmInfo(rs.getString(5));
				film.setFilmAddTime(rs.getDate(6));
				film.setFilmCoverPath(rs.getString(7));
				film.setFilmWatch(rs.getInt(8));
				film.setFilmScore(rs.getFloat(9));
				films.add(film);
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

	@Override
	public void updateFilm(Film film) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Film> findAllFilmOrderByTime() {
		Connection conn = DBConnection.getConnection();
		String findbysql = "select * from tb_film order by filmAddTime Desc";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Film> films = new ArrayList<Film>();
		try{
			pstmt = conn.prepareStatement(findbysql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Film film = new Film();
				film.setFilmID(rs.getInt(1));
				film.setFilmName(rs.getString(2));
				film.setFilmDirector(rs.getString(3));
				film.setFilmType(rs.getString(4));
				film.setFilmInfo(rs.getString(5));
				film.setFilmAddTime(rs.getDate(6));
				film.setFilmCoverPath(rs.getString(7));
				film.setFilmWatch(rs.getInt(8));
				film.setFilmScore(rs.getFloat(9));
				films.add(film);
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

	@Override
	public List<Film> findAllFilmOrderByWatch() {
		Connection conn = DBConnection.getConnection();
		String findbysql = "select * from tb_film order by filmWatch Desc";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Film> films = new ArrayList<Film>();
		try{
			pstmt = conn.prepareStatement(findbysql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Film film = new Film();
				film.setFilmID(rs.getInt(1));
				film.setFilmName(rs.getString(2));
				film.setFilmDirector(rs.getString(3));
				film.setFilmType(rs.getString(4));
				film.setFilmInfo(rs.getString(5));
				film.setFilmAddTime(rs.getDate(6));
				film.setFilmCoverPath(rs.getString(7));
				film.setFilmWatch(rs.getInt(8));
				film.setFilmScore(rs.getFloat(9));
				films.add(film);
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

	@Override
	public List<Film> findAllFilmOrderByScore() {
		Connection conn = DBConnection.getConnection();
		String findbysql = "select * from tb_film order by filmScore Desc";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Film> films = new ArrayList<Film>();
		try{
			pstmt = conn.prepareStatement(findbysql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Film film = new Film();
				film.setFilmID(rs.getInt(1));
				film.setFilmName(rs.getString(2));
				film.setFilmDirector(rs.getString(3));
				film.setFilmType(rs.getString(4));
				film.setFilmInfo(rs.getString(5));
				film.setFilmAddTime(rs.getDate(6));
				film.setFilmCoverPath(rs.getString(7));
				film.setFilmWatch(rs.getInt(8));
				film.setFilmScore(rs.getFloat(9));
				films.add(film);
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

	@Override
	public void modifyFilmWatch(int filmID,float filmScore) {
		Connection conn = DBConnection.getConnection();
		String sql="update tb_film set filmWatch = filmWatch+1,filmScore = ((filmScore*(filmWatch-1))+?)/filmWatch  where filmID = ?";
		PreparedStatement  pstmt = null;
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setFloat(1,filmScore);
			pstmt.setInt(2, filmID);
			pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBConnection.close(pstmt);
			DBConnection.close(conn);
		}
		
	}

	@Override
	public List<Film> findAllFilmByType(String filmType) {
		Connection conn = DBConnection.getConnection();
		String sql="select * from tb_film where filmType = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Film> films = new ArrayList<Film>();
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, filmType);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Film film = new Film();
				film.setFilmID(rs.getInt(1));
				film.setFilmName(rs.getString(2));
				film.setFilmDirector(rs.getString(3));
				film.setFilmType(rs.getString(4));
				film.setFilmInfo(rs.getString(5));
				film.setFilmAddTime(rs.getDate(6));
				film.setFilmCoverPath(rs.getString(7));
				film.setFilmWatch(rs.getInt(8));
				film.setFilmScore(rs.getFloat(9));
				films.add(film);
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
