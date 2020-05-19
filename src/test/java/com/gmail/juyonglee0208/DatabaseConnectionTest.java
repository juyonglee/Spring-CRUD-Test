package com.gmail.juyonglee0208;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class DatabaseConnectionTest {
	
	@Setter(onMethod_ = @Autowired)
	private DataSource dataSource;
	
	@Test
	public void databaseConnectionTest() {
		try (Connection connection =  DriverManager.getConnection("jdbc:log4jdbc:mariadb://localhost:3306/NSHC", "root", "1234")){
			log.info("====================================================");
			log.info("\t[Database Connection Test]");
			log.info("====================================================");
			log.info(connection);
			log.info("====================================================");
		} catch (SQLException e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void conncetionPoolTest() {
		try (Connection connection = dataSource.getConnection()) {
			log.info("====================================================");
			log.info("\t[ConnectionPool Connection Test]");
			log.info("====================================================");
			log.info(connection);
			log.info("====================================================");
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
}
