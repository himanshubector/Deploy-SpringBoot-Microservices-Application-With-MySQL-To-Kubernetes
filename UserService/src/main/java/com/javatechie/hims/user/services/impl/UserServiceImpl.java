package com.javatechie.hims.user.services.impl;


import com.javatechie.hims.user.entities.User;
import com.javatechie.hims.user.repositories.UserRepository;
import com.javatechie.hims.user.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;


@Service
@Slf4j
public class UserServiceImpl implements UserService
{

    @Autowired
    private UserRepository userRepository;


    // User subscription management logic



    public void subscribeToProductNotifications(String userId, String productId)
    {
        // Add productId to user's subscribed products
    }



   /* public void unsubscribeFromProductNotifications(String userId, String productId)
    {
        // Remove productId from user's subscribed products
    }*/


    public User getUserById(String userId)
    {
        User userDetail = userRepository.findById(Integer.valueOf(userId)).orElseThrow(() -> new RuntimeException("User not found"));

        return userDetail;


       /* Optional<User> userDetail = userRepository.findById(Integer.valueOf(userId));

        if(userDetail.isPresent())
        {
            return userDetail; // if you want to return Optional<User>
        }

        else
        {
            log.info(String.valueOf(UserImplConstant.USER_NOT_FOUND));
        }

        return Optional.empty();*/

    }

}
