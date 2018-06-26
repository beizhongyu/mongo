package com.example.zl.mongo.controller;

import com.example.zl.mongo.model.TestBean;
import com.twodfire.share.result.Result;
import com.twodfire.share.result.ResultSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.zl.mongo.service.ITestService;

@RestController
@RequestMapping(value = "/test")
public class TestController {
    @Autowired
    private ITestService testService;
    @RequestMapping(value = "/helle" ,method = RequestMethod.GET)
    public Result<String> get(){
        Result<String> reult = new ResultSupport<>();
        reult.setSuccess(true);
        reult.setModel("hello word!");
        return reult;
    }
    @RequestMapping(value = "/mongo" ,method = RequestMethod.GET)
    public Result<String> dealMongoTest(){
        Result<String> reult = new ResultSupport<>();
        testService.saveUser(new TestBean("Alice",22, "Smith"));
        testService.saveUser(new TestBean("Bob",33, "Smith"));

        // fetch all customers
        System.out.println("Customers found with findAll():");
        System.out.println("-------------------------------");
        for (TestBean testBean : testService.listUser()) {
            System.out.println(testBean);
        }
        System.out.println();

        // fetch an individual customer
        System.out.println("Customer found with findByFirstName('Alice'):");
        System.out.println("--------------------------------");
        System.out.println(testService.findUserByName("Alice"));
        testService.updateUser("Bob-update",44, "Smith");
        System.out.println("Customers found with findByLastName('Smith'):");
        System.out.println("--------------------------------");
        for (TestBean testBean : testService.listUser()) {
            System.out.println(testBean);
        }
        reult.setSuccess(true);
        reult.setModel("hello word!");
        return reult;
    }

}
