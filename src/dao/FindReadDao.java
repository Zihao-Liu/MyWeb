package dao;

import java.util.List;

import bean.Book;

public interface FindReadDao {
	public List<Book> findAllBookRead(int userID);
}
