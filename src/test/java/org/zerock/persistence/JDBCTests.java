package org.zerock.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.Test;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class JDBCTests {
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testConnection () {
		try {
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.111.104:1521:xe", "book_ex", "book_ex");
			log.info(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
