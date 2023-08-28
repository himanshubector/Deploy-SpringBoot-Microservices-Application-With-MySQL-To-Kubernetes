package com.javatechie.hims.user.services;


import com.javatechie.hims.user.entities.User;


public interface UserService
{
    void subscribeToProductNotifications(String userId, String productId);


    User getUserById(String userId);

}
