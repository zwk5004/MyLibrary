package com.kdstudio.mylibrary.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import javax.sql.DataSource;
import java.sql.Driver;

@Configuration
public class DatabaseConfiguration {
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.liquibase")
    public DataSourceProperties liquibaseDatasourceProperties() {
        return new DataSourceProperties();
    }

    @Bean(name = "liquibaseDatasource")
    @LiquibaseDataSource
    public DataSource mainliquibaseDatasource() throws ClassNotFoundException {
        DataSourceProperties properties = liquibaseDatasourceProperties();
        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
        dataSource.setDriverClass((Class<? extends Driver>) Class.forName(properties.getDriverClassName()));
        dataSource.setUsername(properties.getUsername());
        dataSource.setPassword(properties.getPassword());
        dataSource.setUrl(properties.getUrl());

        return dataSource;
    }

    @Primary
    @Bean(name = "datasource")
    @ConfigurationProperties(prefix = "spring.datasource.primary")
    public DataSource gpsDataSource() {
        DataSource dataSource = DataSourceBuilder.create().build();
        ((HikariDataSource) dataSource).setPoolName("mylibrary");
        return dataSource;
    }
}

