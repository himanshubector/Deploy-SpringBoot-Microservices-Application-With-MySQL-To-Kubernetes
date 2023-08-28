package com.javatechie.hims.user.services.impl;


import com.javatechie.hims.user.entities.Notification;
import com.javatechie.hims.user.entities.User;
import com.javatechie.hims.user.repositories.NotificationRepository;
import com.javatechie.hims.user.services.NotificationService;
import com.javatechie.hims.user.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Service
public class NotificationServiceImpl implements NotificationService
{
    @Autowired
    private UserService userService;

    @Autowired
    private NotificationRepository notificationRepository;

    public void subscribeToProductNotifications(String userId, String productId)
    {

        Notification notification = new Notification();

        notification.setProductId(productId);

        User userDetail = userService.getUserById(userId);

        notification.setUser(userDetail);


        notificationRepository.save(notification);


    }


    public Set<String> getAllProductsWithNotificationSubscription(boolean isNotified)
    {

        List<Notification> userSubscribedNotifications = this.notificationRepository.findByIsNotifiedFalse();


        Set<String> userSubscribedProductIds = userSubscribedNotifications.stream().map(notification -> notification.getProductId()).collect(Collectors.toSet());


        return userSubscribedProductIds;

    }


}
