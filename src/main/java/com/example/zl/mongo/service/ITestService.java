package com.example.zl.mongo.service;

import com.example.zl.mongo.model.TestBean;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ITestService{

    public void saveUser(TestBean users);

    public TestBean findUserByName(String name);

    public void removeUser(String name);

    public void updateUser(String name, int age, String sex);

    public List<TestBean> listUser();
}
