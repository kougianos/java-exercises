package com.javaexercices.kougianos.config;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import javax.net.ssl.SSLContext;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;


/**
 * Configuration class for connection to a remote mongoDB cluster, on 2 mongo databases.
 */
@Configuration
@EnableMongoRepositories
public class MongoConfig {

    @Value("${mongo.uri}")
    private String connectionStringUrl;
    private static final String TEST_DB = "testDb";
    private static final String USERS_DB = "usersDb";

    /**
     * MongoClient bean that uses connection string taken from file, and SSL Context TLSv1.2 to avoid bug of
     * Java 11 with MongoDB Atlas integration (SSL Handshake exception). For more information see
     * https://developer.mongodb.com/community/forums/t/sslhandshakeexception-should-not-be-presented-in-certificate-request/12493
     *
     * @return MongoClient
     * @throws NoSuchAlgorithmException Exception
     * @throws KeyManagementException   Exception
     */
    @Bean
    public MongoClient mongo() throws NoSuchAlgorithmException, KeyManagementException {
        ConnectionString connectionString = new ConnectionString(connectionStringUrl);
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

    /**
     * Bean mongoTemplate that connects to "Test" database of MongoDB Atlas.
     *
     * @return MongoTemplate
     * @throws NoSuchAlgorithmException Exception
     * @throws KeyManagementException   Exception
     */
    @Bean(name = "Test")
    @Primary
    public MongoTemplate mongoTemplateTest() throws NoSuchAlgorithmException, KeyManagementException {
        return new MongoTemplate(mongo(), TEST_DB);
    }

    /**
     * Bean mongoTemplate that connects to "Users" database of MongoDB Atlas.
     *
     * @return MongoTemplate
     * @throws NoSuchAlgorithmException Exception
     * @throws KeyManagementException   Exception
     */
    @Bean(name = "Users")
    public MongoTemplate mongoTemplateUsers() throws NoSuchAlgorithmException, KeyManagementException {
        return new MongoTemplate(mongo(), USERS_DB);
    }

}
