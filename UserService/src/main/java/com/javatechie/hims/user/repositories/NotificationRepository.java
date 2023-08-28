package com.javatechie.hims.user.repositories;


import com.javatechie.hims.user.entities.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface NotificationRepository extends JpaRepository<Notification, Integer>
{

    // custom finder method

    List<Notification> findByIsNotifiedFalse();


    List<Notification> findByProductId(String productId);

}
