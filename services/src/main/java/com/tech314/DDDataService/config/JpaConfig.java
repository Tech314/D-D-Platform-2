package com.tech314.DDDataService.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@EnableJpaRepositories(basePackages = "com.tech314.DDDataService.Repository")
public class JpaConfig {

	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setUrl(System.getenv("D_D_URL"));
		ds.setUsername(System.getenv("D_D_USERNAME"));
		ds.setPassword(System.getenv("D_D_PASSWORD"));
		ds.setDriverClassName("org.postgresql.Driver");
		return ds;
	}
}
