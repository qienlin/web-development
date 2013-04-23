/**
 * 
 */
package com.book.service;

import com.book.dao.IBookDao;
import com.book.dao.impl.BookDaoJdbcImpl;
import com.book.model.Book;

/**
 * @author Daniel
 * 
 */
public class BookService {

	public String booksToXml() {
		IBookDao bookDao = new BookDaoJdbcImpl();
		StringBuilder sb = new StringBuilder(
				"<?xml version='1.0' encoding='UTF-8'?>");
		sb.append("<books>");
		for (Book book : bookDao.getbooks()) {
			sb.append("<book>");
			sb.append("<name>").append(book.getName()).append("</name>");
			sb.append("<age>").append(book.getAge()).append("</age>");
			sb.append("</book>");
		}
		sb.append("</books>");
		return sb.toString();
	}
}
