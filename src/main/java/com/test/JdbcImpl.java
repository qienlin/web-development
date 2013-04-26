/**
 * 
 */
package com.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.derby.jdbc.EmbeddedDriver;

/**
 * @author Daniel
 * 
 */
public class JdbcImpl {

	/**
	 * @param args
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static void main(String[] args) throws ClassNotFoundException,
			SQLException {
		Class.forName(EmbeddedDriver.class.getName());
		Connection conn = DriverManager.getConnection(
				"jdbc:derby:library;create=true", "root", "root");
		// String sql =
		// "create table book(id integer,name varchar(50),age varchar(3))";
		// String sql = "insert into book values(2,'Elim','20')";
		String sql = "INSERT INTO book VALUES(7,'Lucene in Action','42','234324234')";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.execute();
		ResultSet rs = stmt.getResultSet();
		if (rs != null) {
			while (rs.next()) {
				System.out
						.println(rs.getInt("id") + " " + rs.getString("name"));
			}
		}
	}
}
