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

import javax.net.ssl.SSLContext;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;


/**
 * Configuration class for connection to a remote mongoDB cluster, on 2 mongo databases.
 */
@Configuration
@EnableMongoRepositories
public class MongoConfig {

    private static final String CONNECTION_STRING_URL = getConnectionString();
    private static final String TEST_DB = "testDb";
    private static final String USERS_DB = "usersDb";

    @Bean
    public MongoClient mongo() throws NoSuchAlgorithmException, KeyManagementException {
        ConnectionString connectionString = new ConnectionString(CONNECTION_STRING_URL);
        // Java 11 TLSv1.3 Bug with MongoDB Atlas
        // https://developer.mongodb.com/community/forums/t/sslhandshakeexception-should-not-be-presented-in-certificate-request/12493
        SSLContext sslContext = SSLContext.getInstance("TLSv1.2");
        sslContext.init(null, null, null);
        MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .applyToSslSettings(builder -> {
                    builder.enabled(true);
                    builder.context(sslContext);
                })
                .build();

        return MongoClients.create(mongoClientSettings);
    }

    @Bean(name = "Test")
    @Primary
    public MongoTemplate mongoTemplateTest() throws NoSuchAlgorithmException, KeyManagementException {
        return new MongoTemplate(mongo(), TEST_DB);
    }

    @Bean(name = "Users")
    public MongoTemplate mongoTemplateUsers() throws NoSuchAlgorithmException, KeyManagementException {
        return new MongoTemplate(mongo(), USERS_DB);
    }

    /**
     * Returns connection string for mongoDB.
     *
     * @return String connectionString
     */
    private static String getConnectionString() {
        try (
                FileReader fr = new FileReader("src/main/resources/credentials");
                BufferedReader br = new BufferedReader(fr)
        ) {
            return br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}
