package dao;

import java.util.List;

import bean.Book;

public interface BookDao {
	public void addBook(Book book);
	public void deleteBook(String bookName);
	public Book findBookByName(String bookName);
	public Book findBookByAuthor(String bookAuthor);
	public Book findBookByID(int bookID);
	public List<Book> findAllBook();
	public void updateBook(Book book);
}
