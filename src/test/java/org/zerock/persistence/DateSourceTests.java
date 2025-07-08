package org.zerock.persistence;

import static org.junit.Assert.fail;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j2
public class DateSourceTests {

	@Setter(onMethod_ = @Autowired)
	private DataSource dataSource;
	
	@Setter(onMethod_ = @Autowired)
	private SqlSessionFactory sessionFactory;
	
	
	@Test
	public void testConnection() {
		try (var connection = dataSource.getConnection()) {
			log.info(connection);
		} catch (SQLException e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testMyBatis() {
		
		var session = sessionFactory.openSession();
		
		try (var connection = session.getConnection()) {
			log.info(session);
			log.info(connection);
		} catch (SQLException e) {
			fail(e.getMessage());
		}
	}
}
