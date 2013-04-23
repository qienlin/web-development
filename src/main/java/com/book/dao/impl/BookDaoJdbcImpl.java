/**
 * 
 */
package com.book.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.book.dao.IBookDao;
import com.book.model.Book;

/**
 * @author Daniel
 * 
 */
public class BookDaoJdbcImpl implements IBookDao {

	@Override
	public List<Book> getbooks() {
		List<Book> bookList = new ArrayList<Book>();
		Book b1 = new Book();
		b1.setName("Daniel");
		b1.setAge("23");
		bookList.add(b1);
		b1 = new Book();
		b1.setName("Elim");
		b1.setAge("20");
		bookList.add(b1);
		return bookList;
	}
}
