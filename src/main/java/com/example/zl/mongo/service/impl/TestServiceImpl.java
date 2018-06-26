package com.example.zl.mongo.service.impl;

import com.example.zl.mongo.model.TestBean;
import com.example.zl.mongo.service.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("testService")
public class TestServiceImpl implements ITestService{
    @Autowired
    MongoOperations mongoTemplate;
    public void saveUser(TestBean users) {
        mongoTemplate.save(users);
    }

    public TestBean findUserByName(String name) {
        return mongoTemplate.findOne(
                new Query(Criteria.where("name").is(name)), TestBean.class);
    }

    public void removeUser(String name) {
        mongoTemplate.remove(new Query(Criteria.where("name").is(name)),
                TestBean.class);
    }

    public void updateUser(String name, int age, String sex) {
        mongoTemplate.updateFirst(new Query(Criteria.where("name").is(name)),
                new Update().set("age",100).set("sex","twq"), TestBean.class);

    }

    public List<TestBean> listUser() {
        return mongoTemplate.findAll(TestBean.class);
    }
}
