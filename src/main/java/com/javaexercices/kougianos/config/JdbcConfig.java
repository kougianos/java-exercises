package com.javaexercices.kougianos.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
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

@ConditionalOnProperty(
        value="sql.enabled",
        havingValue = "true",
        matchIfMissing = true)
@Configuration
@EnableJdbcRepositories()
public class JdbcConfig extends AbstractJdbcConfiguration {

    @Value("${gearhost.username}")
    private String username;
    @Value("${gearhost.password}")
    private String password;
    @Value("${gearhost.url}")
    private String url;
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
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    /**
     * Used for performing some initial test SQL queries on the database.
     */
    @PostConstruct
    void test() {

        String sql = "SELECT COUNT(*) FROM dogs";
        var x = operations().queryForObject(sql, new HashMap<>(), Integer.class);
        /*
        String sql1 = "DROP TABLE DOGS";
        x = operations().update(sql1, new HashMap<>());
        */
    }

}
