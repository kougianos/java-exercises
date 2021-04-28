package com.javaexercices.kougianos.service;

import com.javaexercices.kougianos.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class MongoService {

    @Autowired
    @Qualifier("Test")
    private MongoTemplate mongoTemplateTest;

    @Autowired
    @Qualifier("Users")
    private MongoTemplate mongoTemplateUsers;

    public Set<String> getAllMongoCollections() {
        return CollectionUtils.mergeSets(this.mongoTemplateTest.getCollectionNames(),
                this.mongoTemplateUsers.getCollectionNames());
    }
}
