/**
 * 
 */
package com.book.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.book.service.BookService;

/**
 * @author Daniel
 * 
 */
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 6106814938137504300L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		BookService bookService = new BookService();
		PrintWriter out = res.getWriter();
		out.write(bookService.booksToXml());
	}
}
