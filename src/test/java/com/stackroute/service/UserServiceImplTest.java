package com.stackroute.service;

import com.stackroute.domain.UserDetails;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceImplTest {
    UserDetails userDetails1, userDetails2, userDetails3;
    private List<UserDetails> userList;
    private UserService userService;

    @BeforeEach
    void setUp() {

        userService = new UserServiceImpl();
        userDetails1 = new UserDetails("1", "John", "Male", "7412588888");
        userDetails2 = new UserDetails("2", "Ravi", "Male", "8520258520");
        userDetails3 = new UserDetails("3", "Priya", "Female", "9632587411");

        userList = new ArrayList<>();
        userList.add(userDetails1);
        userList.add(userDetails2);
        userList.add(userDetails3);
    }

    @AfterEach
    void tearDown() {
        userService = null;

    }

    @Test
    void addUserDetails() {
        List<UserDetails> savedUserList=userService.addUserDetails();
        assertEquals(3,savedUserList.size());

    }

    @Test
    void getAllUserDetails() {
        List<UserDetails> userDetailsList = userService.getAllUserDetails();
        assertNotNull(userDetailsList);
        assertEquals(3, userDetailsList.size());
    }

    @Test
    void deleteUserDetails() {
    }

    @Test
    void updateEmployee() {
    }
}