package dao;

import java.util.List;

import bean.Letter;

public interface LetterDao {
	public void addLetter(Letter letter);
	public Letter findLetter(int letterID);
	public List<Letter> findAllLetter(int receiveUserID);
	public List<Letter> findAllLetterNotRead(int receiveUserID);
	public void modifyLetterToRead(int letterID);
}
