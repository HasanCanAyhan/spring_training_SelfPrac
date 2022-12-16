package com.cydeo.service.impl;

import com.cydeo.entity.User;
import com.cydeo.mapper.UserMapper;
import com.cydeo.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock//di we are injectinh mock objectnot real
    UserRepository userRepository;

    @Mock
    UserMapper userMapper;

    @InjectMocks // inject userRepository and userMapper
    UserServiceImpl userService; // we do not use userService Interface

    @Test
    void findByUserName_Test(){

        // i m calling the real method inside the main, which is the method I want to test
        userService.findByUserName("harold@manager.com");

        //I m checking if this method is ran or not
        verify(userRepository).findByUserNameAndIsDeleted("harold@manager.com",false);

        verify(userRepository,times(1)).findByUserNameAndIsDeleted("harold@manager.com",false);
        //how many times this method called

        verify(userRepository,atLeastOnce()).findByUserNameAndIsDeleted("harold@manager.com",false);

        verify(userRepository, atLeast(1)).findByUserNameAndIsDeleted("harold@manager.com", false);

        verify(userRepository, atMostOnce()).findByUserNameAndIsDeleted("harold@manager.com", false);

        verify(userRepository, atMost(10)).findByUserNameAndIsDeleted("harold@manager.com", false);

        InOrder inOrder = inOrder(userRepository,userMapper);

        //inOrder.verify(userMapper).convertToDto(null);
        //inOrder.verify(userRepository).findByUserNameAndIsDeleted("harold@manager.com",false);


        inOrder.verify(userRepository).findByUserNameAndIsDeleted("harold@manager.com",false);
        inOrder.verify(userMapper).convertToDto(null);


    }



}