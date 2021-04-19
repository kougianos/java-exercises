package com.javaexercices.kougianos.config;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


/**
 * Configuration class for connection to a remote mongoDb, on 2 mongo databases.
 */
@Configuration
@EnableMongoRepositories
public class MongoConfig {

    private final String connectionStringUrl = getConnectionString();

    @Bean
    public MongoClient mongo() {
        ConnectionString connectionString = new ConnectionString(this.connectionStringUrl);
        MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .build();

        return MongoClients.create(mongoClientSettings);
    }

    @Bean(name = "Test")
    @Primary
    public MongoTemplate mongoTemplateTest() {
        return new MongoTemplate(mongo(), "testDb");
    }

    @Bean(name = "Users")
    public MongoTemplate mongoTemplateUsers() {
        return new MongoTemplate(mongo(), "usersDb");
    }

    private String getConnectionString() {

        try (
                FileReader fr = new FileReader("src/main/resources/credentials");
                BufferedReader br = new BufferedReader(fr)
        ) {
            return br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "";

    }
}
