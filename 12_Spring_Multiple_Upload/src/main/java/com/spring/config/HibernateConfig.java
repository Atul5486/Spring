package com.spring.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariDataSource;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@ComponentScan("com.spring.entity")
@EnableTransactionManagement
public class HibernateConfig{
	
	@Bean
	public DataSource dataSource() {
		HikariDataSource hds=new HikariDataSource();
		hds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		hds.setUsername("root");
		hds.setPassword("Airtel@123");
		hds.setJdbcUrl("jdbc:mysql://localhost:3306/itep16");
		return hds;
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean(DataSource ds) {
	
		LocalContainerEntityManagerFactoryBean lcem=new LocalContainerEntityManagerFactoryBean();
		lcem.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		lcem.setDataSource(ds);
		lcem.setPackagesToScan("com.spring.entity");
		
		Properties properties=new Properties();
		properties.put("hibernate.dialect","org.hibernate.dialect.MySQL8Dialect");
		properties.put("hibernate.format_sql", true);
		properties.put("hibernate.show_sql", true);
		properties.put("hibernate.hbm2ddl.auto", "update");
		
		lcem.setJpaProperties(properties);
		return lcem;
			
	}
	
	@Bean
	public PlatformTransactionManager jpaTransactionManager(EntityManagerFactory emf) {
		return new JpaTransactionManager(emf);
	}
	
}