 /**
 * 
 */
package com.book.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.book.dao.IBookDao;
import com.book.dao.impl.BookDaoJdbcImpl;
import com.book.model.Book;
import com.library.util.JdbcHelper;

/**
 * @author Daniel
 * 
 */
public class BookService {

	private static final String COUNT_PER_PAGE = "3";

	public String booksToXml(String page) throws SQLException {
		IBookDao bookDao = new BookDaoJdbcImpl();
		ResultSet rs = JdbcHelper.execute("SELECT * FROM book");
		int totalPage = 0;
		while (rs.next()) {
			totalPage++;
		}
		int pages = totalPage % Integer.valueOf(COUNT_PER_PAGE) == 0 ? totalPage
				/ Integer.valueOf(COUNT_PER_PAGE)
				: totalPage / Integer.valueOf(COUNT_PER_PAGE) + 1;
		StringBuilder sb = new StringBuilder(
				"<?xml version='1.0' encoding='UTF-8'?>");
		sb.append("<books>").append("<page>").append(page).append("</page>")
				.append("<totalPages>").append(pages).append("</totalPages>");
		for (Book book : bookDao.getbooks(page, COUNT_PER_PAGE)) {
			sb.append("<book>");
			sb.append("<id>").append(book.getId()).append("</id>");
			sb.append("<name>").append(book.getName()).append("</name>");
			sb.append("<price>").append(book.getPrice()).append("</price>");
			sb.append("<isbn>").append(book.getIsbn()).append("</isbn>");
			sb.append("</book>");
		}
		sb.append("</books>");
		return sb.toString();
	}
}
