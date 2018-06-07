package com.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.entity.Role;
import com.entity.User;

@Configuration
@PropertySource("classpath:db.properties")
@ComponentScan(basePackages = { "com" })
@EnableTransactionManagement

public class AppConfig {

	@Autowired
	private Environment env;

	@Bean
	public DataSource getDataSource() {
		BasicDataSource basicDataSource = new BasicDataSource();
		basicDataSource.setDriverClassName(env.getProperty("db.driver"));
		basicDataSource.setUrl(env.getProperty("db.url"));
		basicDataSource.setUsername(env.getProperty("db.user"));
		basicDataSource.setPassword(env.getProperty("db.password"));
		return basicDataSource;

	}

	// Session Factory Configuration
	@Bean
	public LocalSessionFactoryBean getLocalSessionFactoryBean() {
		LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
		localSessionFactoryBean.setDataSource(getDataSource());
		Properties properties = new Properties();
		properties.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
		properties.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
		localSessionFactoryBean.setHibernateProperties(properties);
		localSessionFactoryBean.setAnnotatedClasses(Role.class);
		localSessionFactoryBean.setAnnotatedClasses(User.class);
		return localSessionFactoryBean;

	}

	// transaction configuration
	@Bean
	public PlatformTransactionManager getTransactionManager() {
		HibernateTransactionManager tx = new HibernateTransactionManager();
		tx.setSessionFactory(getLocalSessionFactoryBean().getObject());
		return tx;
	}

}
