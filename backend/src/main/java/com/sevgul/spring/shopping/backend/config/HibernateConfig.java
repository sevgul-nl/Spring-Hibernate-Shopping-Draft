package com.sevgul.spring.shopping.backend.config;

import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.h2.tools.Server;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = { "com.sevgul.spring.shopping.backend" })
@EnableTransactionManagement
public class HibernateConfig {
	// private final static String DATABASE_URL =
	// "jdbc:h2:tcp://localhost/~/boncuk"; jdbc:h2:[file:][<path>]
	// jdbc:h2:tcp://<server>[:<port>]/[<path(/Users/bakimac/)>]<databaseName>
	// doker jdbc:h2:tcp://my-h2/my-db-name
	//private final static String DATABASE_URL ="jdbc:h2:/Users/bakimac/Documents/deve-works/wsSAShopping/SAShopping/h2-data/myh2;MODE=LEGACY";
	//private final static String DATABASE_URL ="jdbc:h2:tcp://localhost//Users/bakimac/Documents/deve-works/wsSAShopping/SAShopping/h2-data/myh2;MODE=LEGACY";
	//private final static String DATABASE_URL = "jdbc:h2:tcp://localhost//home/pi/h2-data/myh2;MODE=LEGACY";
	private final static String DATABASE_URL = "jdbc:h2:tcp://localhost//h2-data/myh2;MODE=LEGACY";
	//private final static String DATABASE_URL = "jdbc:h2:/home/pi/h2-data/myh2;MODE=LEGACY";

	// private final static String DATABASE_URL =
	// "jdbc:h2:file:/Users/bakimac/Documents/deve-works/wsSAShopping/SAShopping/backend/src/main/resources/db/shopping";
	// private final static String DATABASE_URL =
	// "jdbc:h2:tcp://localhost//Users/bakimac/Documents/deve-works/wsSAShopping/SAShopping/backend/src/main/resources/db/shopping";

	private final static String DATABASE_DRIVER = "org.h2.Driver";
	private final static String DATABASE_DIALECT = "org.hibernate.dialect.H2Dialect";
	private final static String DATABASE_USER = "sa";
	private final static String DATABASE_PASSWORD = "";

	@Bean
	public DataSource getDataSource() {
		BasicDataSource ds = null;
		try {
			h2Server();
			ds = new BasicDataSource();
			ds.setDriverClassName(DATABASE_DRIVER);
			ds.setUrl(DATABASE_URL);
			ds.setUsername(DATABASE_USER);
			ds.setPassword(DATABASE_PASSWORD);
		} catch (Exception e) {
			throw new RuntimeException("Failed to create H2 server: ", e);
		}
		return ds;
	}
	
	@Bean(initMethod = "start", destroyMethod = "stop")
	public Server h2Server() throws SQLException {
		Server h2Server = null;

		try {
			h2Server = Server.createTcpServer("-tcp", "-tcpAllowOthers", "-tcpPort", "9092");
			System.out.print("server started " + h2Server.getURL());
		} catch (SQLException e) {
			throw new RuntimeException("Failed to create H2 server: ", e);
		}
		return h2Server;
	}
	
	@Bean
	public SessionFactory getSessionFactory(DataSource ds) {
		LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(ds);
		builder.addProperties(getHibernateProperties());
		builder.scanPackages("com.sevgul.spring.shopping.backend");

		return builder.buildSessionFactory();
	}

	private Properties getHibernateProperties() {
		Properties prop = new Properties();
		prop.put("hibernate.dialect", DATABASE_DIALECT);
		prop.put("hibernate.show_sql", true);
		prop.put("hibernate.format_sql", true);
		//prop.put("hibernate.check_nullability", true);
		// prop.put("hibernate.hbm2ddl.auto", "update");
		return prop;
	}

	@Bean
	public HibernateTransactionManager getTransactionManager(SessionFactory sf) {
		HibernateTransactionManager tm = new HibernateTransactionManager(sf);

		return tm;
	}

}
