package com.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages = "com")
@PropertySource("classpath:database.properties")
@EnableWebMvc
public class config {

	// way 1
	@Value("${spring.datasource.url}")
	private String dbURL;

	@Value("${spring.datasource.username}")
	private String username;

	@Value("${spring.datasource.password}")
	private String password;

	@Value("${spring.datasource.driverClassName}")
	private String driverClassName;

	// way 2
	@Autowired
	private Environment environment;

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(driverClassName);
		dataSource.setUrl(dbURL);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		return dataSource;
	}

	// To resolve ${} in @Value
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.setResultsMapCaseInsensitive(true);
		return jdbcTemplate;
	}

	@Bean
	public NamedParameterJdbcTemplate namedParameterJdbcTemplate(
			DataSource dataSource) {
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(
				dataSource);
		return namedParameterJdbcTemplate;
	}

	// dataSource for hibernate
	@Bean
	public DataSource dataSourceforHibernate() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(environment
				.getProperty("spring.datasource.driverClassName"));
		dataSource.setUrl(environment.getProperty("spring.datasource.url"));
		dataSource.setUsername(environment
				.getProperty("spring.datasource.username"));
		dataSource.setPassword(environment
				.getProperty("spring.datasource.password"));
		return dataSource;
	}

	private Properties hibernateProperties() {

		/*
		 * Properties is a subclass of Hashtable. It is used to maintain lists
		 * of values in which the key is a String and the value is also a
		 * String.
		 * 
		 * The Properties class is used by many other Java classes. For example,
		 * it is the type of object returned by System.getProperties( ) when
		 * obtaining environmental values.
		 */
		Properties properties = new Properties();
		properties.put("hibernate.dialect",
				environment.getRequiredProperty("spring.hibernate.dialect"));
		properties.put("hibernate.show_sql",
				environment.getRequiredProperty("spring.hibernate.show_sql"));
		properties.put("hibernate.format_sql",
				environment.getRequiredProperty("spring.hibernate.format_sql"));
		properties
				.put("hibernate.hbm2ddl.auto", environment
						.getRequiredProperty("spring.hibernate.createTable"));
		return properties;
	}

	/*
	 * SessionFactory is an interface, which is available in “org.hibernate”
	 * package. Session factory is long live multithreaded object. Usually one
	 * session factory should be created for one database. When you have
	 * multiple databases in your application you should create multiple
	 * SessionFactory object. Assume the scenario that you are using one
	 * database called mysql in your application then following is the way to
	 * create the SessionFactory object.
	 */
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSourceforHibernate());
		sessionFactory.setPackagesToScan(new String[] { "com.model" });
		sessionFactory.setHibernateProperties(hibernateProperties());
		return sessionFactory;
	}
}
