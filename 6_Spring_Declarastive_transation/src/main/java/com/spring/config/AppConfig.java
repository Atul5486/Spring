package com.spring.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@ComponentScan("com.spring")
@EnableTransactionManagement
public class AppConfig{
	
	@Bean
	public DataSource dataSource() {
		
		HikariDataSource hds=new HikariDataSource();
		hds.setJdbcUrl("jdbc:mysql://localhost:3306/itep16");
		hds.setUsername("root");
		hds.setPassword("Airtel@123");
		hds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		return hds;
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate(DataSource hds) {
		return new JdbcTemplate(hds);
	}
	
	@Bean 
	public DataSourceTransactionManager dataSourceTransactionManager(DataSource hds) {
		return new DataSourceTransactionManager(hds);
	}
}