package bean;

import java.util.Date;

public class Film {
	private int filmID;
	private String filmName;
	private String filmDirector;
	private String filmType;
	private String filmInfo;
	private String filmCoverPath;
	private Date filmAddTime;
	private int filmWatch;
	private float filmScore;
	public int getFilmID() {
		return filmID;
	}
	public void setFilmID(int filmID) {
		this.filmID = filmID;
	}
	public String getFilmName() {
		return filmName;
	}
	public void setFilmName(String filmName) {
		this.filmName = filmName;
	}
	public String getFilmDirector() {
		return filmDirector;
	}
	public void setFilmDirector(String filmDirector) {
		this.filmDirector = filmDirector;
	}
	public String getFilmType() {
		return filmType;
	}
	public void setFilmType(String filmType) {
		this.filmType = filmType;
	}
	public String getFilmInfo() {
		return filmInfo;
	}
	public void setFilmInfo(String filmInfo) {
		this.filmInfo = filmInfo;
	}
	public String getFilmCoverPath() {
		return filmCoverPath;
	}
	public void setFilmCoverPath(String filmCoverPath) {
		this.filmCoverPath = filmCoverPath;
	}
	public Date getFilmAddTime() {
		return filmAddTime;
	}
	public void setFilmAddTime(Date filmAddTime) {
		this.filmAddTime = filmAddTime;
	}
	public int getFilmWatch() {
		return filmWatch;
	}
	public void setFilmWatch(int filmWatch) {
		this.filmWatch = filmWatch;
	}
	public float getFilmScore() {
		return filmScore;
	}
	public void setFilmScore(float filmScore) {
		this.filmScore = filmScore;
	}
}
