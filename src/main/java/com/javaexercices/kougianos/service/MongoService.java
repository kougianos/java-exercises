package com.javaexercices.kougianos.service;

import com.javaexercices.kougianos.dto.User;
import com.javaexercices.kougianos.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.Set;

@ConditionalOnProperty(
        value="mongo.enabled",
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
     * @return Set<String>
     */
    public Set<String> getAllMongoCollections() {
        return CollectionUtils.mergeSets(this.mongoTemplateTest.getCollectionNames(),
                this.mongoTemplateUsers.getCollectionNames());
    }

    //TODO
    public String createUser(User user) {
        return mongoTemplateUsers.insert(user).getId();
    }
}
