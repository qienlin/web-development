/**
 * 
 */
package com.book.dao;

import java.sql.SQLException;
import java.util.List;

import com.book.model.Book;

/**
 * @author Daniel
 * 
 */
public interface IBookDao {
	public List<Book> getbooks(String page, String countPerPage)
			throws SQLException;
}
