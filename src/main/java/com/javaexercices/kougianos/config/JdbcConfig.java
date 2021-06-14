package com.javaexercices.kougianos.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jdbc.repository.config.AbstractJdbcConfiguration;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableJdbcRepositories()
public class JdbcConfig extends AbstractJdbcConfiguration {
    // NamedParameterJdbcOperations is used internally to submit SQL statements to the database
    @Bean
    public NamedParameterJdbcOperations operations() {
        return new NamedParameterJdbcTemplate(dataSource());
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://den1.mysql5.gear.host/ghtestdb");
        dataSource.setUsername("ghtestdb");
        dataSource.setPassword("Bn0k2Q8!DtU?");
        return dataSource;
    }

    @PostConstruct
    void test() {
        String sql = "SELECT COUNT(*) FROM dogs";
        var x = operations().queryForObject(sql, new HashMap<>(), Integer.class);
        String sql1 = "DROP TABLE DOGS";

        x = operations().update(sql1, new HashMap<>());

    }

}
