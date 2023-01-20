package guru.bonacci.trino.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("start 123");
		
		// properties
		String url = "jdbc:trino://localhost:8080/mysql/heroes";
		Properties properties = new Properties();
		properties.setProperty("user", "test");
//		properties.setProperty("password", "secret");
//		properties.setProperty("SSL", "FALSE");

		try (Connection connection = DriverManager.getConnection(url, properties)) {
			Statement s = connection.createStatement();
			ResultSet rs = s.executeQuery("select count(*) from mysql.heroes.user_info");
			while (rs.next()) {
			  System.out.println(rs.getString(1));
			}
		}
	  catch (SQLException e) {
	  	e.printStackTrace();
	  }
//		connection.
//		// URL parameters
//		url = "jdbc:trino://example.net:8443/hive/sales?user=test&password=secret&SSL=true";
//		connection = DriverManager.getConnection(url);
	}

}
