/**
 * 
 */
package com.book.dao.impl;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.book.dao.IBookDao;
import com.book.model.Book;
import com.library.util.JdbcHelper;

/**
 * @author Daniel
 * 
 */
public class BookDaoJdbcImpl implements IBookDao {

	private static final String PAGING_SQL = "SELECT * FROM book ORDER BY id OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";

	@Override
	public List<Book> getbooks(String page, String countPerPage)
			throws SQLException {
		List<Book> bookList = new ArrayList<Book>();
		ResultSet rs = JdbcHelper.execute(
				PAGING_SQL,
				new BigDecimal(page).subtract(new BigDecimal(1))
						.multiply(new BigDecimal(countPerPage)).toString(),
				countPerPage);
		if (null != rs) {
			while (rs.next()) {
				Book book = new Book();
				book.setId(rs.getInt(1));
				book.setName(rs.getString(2));
				book.setPrice(rs.getString(3));
				book.setIsbn(rs.getString(4));
				bookList.add(book);
			}
		}
		return bookList;
	}
}
