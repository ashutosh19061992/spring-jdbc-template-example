package com.spring.jdbc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;


@Configuration
@ComponentScan(basePackages = {"com.spring.jdbc.dao"})
public class JdbcConfig {

	@Bean(name={"ds"})
	public DriverManagerDataSource getDataSource() {
		DriverManagerDataSource dataSource = new  DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUsername("root");
		dataSource.setUrl("jdbc:mysql://localhost:3306/springjdbc");
		dataSource.setPassword("12345678");
		return dataSource;
	}
	
	@Bean(name={"jdbcTemplate"})
	public JdbcTemplate getJdbcTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate;
	}
	
//	@Bean(name={"studentDao"})
//	public StudentDao getStudentDao() {
//		StudentDaoImpl dao = new StudentDaoImpl();
//		dao.setJdbcTemplate(getJdbcTemplate());
//		return dao;
//	}	
}
