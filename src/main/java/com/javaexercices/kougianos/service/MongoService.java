package com.javaexercices.kougianos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Iterator;
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
        Set<String> set = new HashSet<>();
        var testCollectionNames = this.mongoTemplateTest.getCollectionNames();
        var usersCollectionNames = this.mongoTemplateUsers.getCollectionNames();
        Iterator<String> iter1 = testCollectionNames.iterator();
        Iterator<String> iter2 = usersCollectionNames.iterator();
        while (iter1.hasNext()) {
            set.add(iter1.next());
        }
        while (iter2.hasNext()) {
            set.add(iter2.next());
        }
        return set;
    }
}
