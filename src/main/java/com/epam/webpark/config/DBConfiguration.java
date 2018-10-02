package com.epam.webpark.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "com.epam.web-park")
@PropertySource(value = {"classpath:application.properties"})
public class DBConfiguration {

    @Autowired
    private Environment environment;

    @Value("${spring.datasource.url}")
    private String jdbcURl;

    @Value("${spring.datasource.driver}")
    private String dbDriver;

    @Value("${spring.datasource.username}")
    private String dbUsername;

    @Value("${spring.datasource.password}")
    private String dbPassword;


    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getRequiredProperty(dbDriver));
        //dataSource.setDriverClassName(environment.getRequiredProperty("com.mysql.jdbc.Driver"));
        dataSource.setUrl(environment.getRequiredProperty(jdbcURl));
        dataSource.setUsername(environment.getRequiredProperty(dbUsername));
        dataSource.setPassword(environment.getRequiredProperty(dbPassword));
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.setResultsMapCaseInsensitive(true);
        return jdbcTemplate;
    }
}