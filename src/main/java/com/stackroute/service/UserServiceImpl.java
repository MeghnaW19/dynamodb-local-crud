package com.stackroute.service;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperTableModel;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.document.DeleteItemOutcome;
import com.amazonaws.services.dynamodbv2.document.spec.DeleteItemSpec;
import com.amazonaws.services.dynamodbv2.document.utils.NameMap;
import com.amazonaws.services.dynamodbv2.document.utils.ValueMap;
import com.amazonaws.services.dynamodbv2.model.ReturnValue;
import com.stackroute.config.AWSDynamoDBUtil;
import com.stackroute.domain.UserDetails;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {
    public static List<UserDetails> userDetailsList = new ArrayList<>();

    @Override
    public List<UserDetails> addUserDetails() {
        UserDetails userDetails1 = new UserDetails("1", "John", "Male", "7412588888");
        UserDetails userDetails2 = new UserDetails("2", "Ravi", "Male", "8520258520");
        UserDetails userDetails3 = new UserDetails("3", "Priya", "Female", "9632587411");

        userDetailsList.add(userDetails1);
        userDetailsList.add(userDetails2);
        userDetailsList.add(userDetails3);
        List<DynamoDBMapper.FailedBatch> failedBatchList = AWSDynamoDBUtil.getMapper().batchSave(userDetailsList);
        System.out.println("***" + failedBatchList);
        return userDetailsList;
    }

//    @Override
//    public UserDetails addUserDetails(UserDetails user){
//        DynamoDBMapper dynamoDBMapper= AWSDynamoDBUtil.getMapper();
//        return dynamoDBMapper.load(UserDetails.class, user.getId());
//    }

    @Override
    public List<UserDetails> getAllUserDetails() {
        DynamoDBMapper dynamoDBMapper = AWSDynamoDBUtil.getMapper();

        DynamoDBScanExpression scanExpression = new DynamoDBScanExpression();
        List<UserDetails> userList = dynamoDBMapper.scan(UserDetails.class, scanExpression);
        return userList;
    }

    @Override
    public void deleteUserDetails() {
        DynamoDBMapper dynamoDBMapper = AWSDynamoDBUtil.getMapper();


        DeleteItemSpec deleteItemSpec = new DeleteItemSpec()
                .withPrimaryKey("id", 1);
//                dynamoDBMapper.delete(deleteItemSpec);



//        AWSDynamoDBUtil.getMapper().load(UserDetails.class, userDetails.getId());
//        AWSDynamoDBUtil.getMapper().delete(userDetails);
        DynamoDBScanExpression scanExpression = new DynamoDBScanExpression();
        List<UserDetails> userList = dynamoDBMapper.scan(UserDetails.class, scanExpression);

    }


    @Override
    public void updateUserDetails(String id) {
        UserDetails userDetails1 = new UserDetails("1", "Perk", "Male", "7412588888");

//        userDetailsList.add(userDetails1);
//        AWSDynamoDBUtil.getMapper().save(userDetailsList);
//        for (UserDetails userList1 : userDetailsList)
//            System.out.println("***" + userList1);
        AWSDynamoDBUtil.getMapper().load(UserDetails.class, id);
    }

    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        UserDetails userDetails1 = new UserDetails("1", "John", "Male", "7412588888");
        userService.addUserDetails();
        userService.getAllUserDetails();
//        userService.updateEmployee(userDetails1);
//        userService.deleteUserDetails(userDetails1);
//        userService.updateUserDetails(1);
        userService.deleteUserDetails();
    }
}
