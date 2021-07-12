package com.javaexercices.kougianos.service;

import com.javaexercices.kougianos.dto.User;
import com.javaexercices.kougianos.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@ConditionalOnProperty(
        value = "mongo.enabled",
        havingValue = "true",
        matchIfMissing = true)
@Service
public class MongoService {

    @Autowired
    @Qualifier("Test")
    private MongoTemplate mongoTemplateTest;

    @Autowired
    @Qualifier("Users")
    private MongoTemplate mongoTemplateUsers;

    /**
     * Return all mongo collections for both mongo templates.
     *
     * @return Set<String>
     */
    public Set<String> getAllMongoCollections() {
        return CollectionUtils.mergeSets(this.mongoTemplateTest.getCollectionNames(),
                this.mongoTemplateUsers.getCollectionNames());
    }

    /**
     * Insert a single user into Users collection.
     *
     * @param user User to insert
     * @return Id of created user
     */
    public String createUser(User user) {
        user.setDateInserted(LocalDateTime.now(ZoneId.of("Europe/Athens")));
        return mongoTemplateUsers.insert(user).getId();
    }

    /**
     * Perform find query based on params and return list of users that match query criteria.
     *
     * @param params HashMap of parameters
     * @return List of users
     */
    public List<User> getUsers(Map<String, String> params) {
        //TODO
        return new ArrayList<>();
    }

}
