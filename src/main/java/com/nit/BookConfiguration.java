package com.nit;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@PropertySource("classpath:com/nit/application.properties")
@ComponentScan(basePackages = "com.nit")
public class BookConfiguration {

    @Autowired
    Environment environment;

    @Bean
    public DataSource dataSource() {

        DriverManagerDataSource source =
                new DriverManagerDataSource();

        source.setDriverClassName(
                environment.getProperty("db.driverName"));

        source.setUrl(
                environment.getProperty("db.url"));

        source.setUsername(
                environment.getProperty("db.username"));

        source.setPassword(
                environment.getProperty("db.password"));

        return source;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {

        JdbcTemplate template =
                new JdbcTemplate(dataSource());

        return template;
    }
}