package com.stackroute.service;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.google.common.collect.Table;
import com.stackroute.config.AWSDynamoDBUtil;
import com.stackroute.domain.UserDetails;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {
    public static List<UserDetails> userDetailsList = new ArrayList<>();


    @Override
    public void addUserDetails() {
        UserDetails userDetails1 = new UserDetails(1, "John", "Male", "7412588888");
        UserDetails userDetails2 = new UserDetails(2, "Ravi", "Male", "8520258520");

        userDetailsList.add(userDetails1);
        userDetailsList.add(userDetails2);
        AWSDynamoDBUtil.getMapper().batchSave(userDetailsList);
    }

    @Override
    public List<UserDetails> getAllUserDetails() {
        DynamoDBMapper dynamoDBMapper = AWSDynamoDBUtil.getMapper();
        DynamoDBScanExpression scanExpression = new DynamoDBScanExpression();
        List<UserDetails> userList = dynamoDBMapper.scan(UserDetails.class, scanExpression);
        for (UserDetails userList1 : userList)
            System.out.println(userList1);
        return userList;
//        return null;
    }

    @Override
    public void deleteUserDetails(UserDetails userDetails) {
        System.out.println("delete**********" + userDetails);
//        AWSDynamoDBUtil.getMapper().batchDelete(userDetails);
//            AWSDynamoDBUtil.getMapper();

    }


    @Override
    public void updateUserDetails(int id) {
//        UserDetails userDetails1 = new UserDetails(1, "Perk", "Male", "7412588888");
//
//        userDetailsList.add(userDetails1);
//        AWSDynamoDBUtil.getMapper().save(userDetailsList);
//        for (UserDetails userList1 : userDetailsList)
//            System.out.println("***" + userList1);
        AWSDynamoDBUtil.getMapper().load(UserDetails.class, id);
    }

    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        UserDetails userDetails1 = new UserDetails(1, "John", "Male", "7412588888");
        userService.addUserDetails();
        userService.getAllUserDetails();
//        userService.updateEmployee(userDetails1);
//        userService.deleteUserDetails(userDetails1);
//        userService.updateUserDetails(1);
    }
}
