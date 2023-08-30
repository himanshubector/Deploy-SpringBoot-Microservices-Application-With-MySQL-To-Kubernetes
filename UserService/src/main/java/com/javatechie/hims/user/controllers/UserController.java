package com.javatechie.hims.user.controllers;


import com.javatechie.hims.user.entities.User;
import com.javatechie.hims.user.services.NotificationService;
import com.javatechie.hims.user.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/users")
public class UserController
{
    @Autowired
    private UserService userService;

    @Autowired
    private NotificationService notificationService;


    @PostMapping("/subscribe/product/{productId}/user/{userId}")
    public ResponseEntity<User> subscribeForProductNotifications(@PathVariable String userId, @PathVariable String productId)
    {

        notificationService.subscribeToProductNotifications(userId, productId);

        return new ResponseEntity<>(HttpStatus.OK);
    }



    @GetMapping("/subscribed/notifications/products")
    public ResponseEntity<Set<String>> getAllProductsWithNotificationSubscription()
    {
        boolean isNotified = false;

        Set<String> allProductsWithNotificationSubscription = notificationService.getAllProductsWithNotificationSubscription(isNotified);


        return new ResponseEntity<Set<String>>(allProductsWithNotificationSubscription, HttpStatus.OK);

      //  return ResponseEntity.ok(allProductsWithNotificationSubscription);


      // Both above 'return' statements return the same results in postman GET request


    }


}
