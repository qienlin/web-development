/**
 * 
 */
package com.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Daniel
 * 
 */
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = -711373866551588448L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		String name = req.getParameter("name");
		String password = req.getParameter("password");
		System.out.println(name + " " + password);
		PrintWriter out = res.getWriter();
		for (int i = 0; i < 150000; i++) {
			System.out.println(i);
		}
		out.write("Hello " + name + " " + password);
	}
}
