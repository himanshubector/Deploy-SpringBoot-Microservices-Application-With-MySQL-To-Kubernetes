package com.javatechie.hims.user.repositories;


import com.javatechie.hims.user.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Integer>
{

    // if we want to implement any custom method or query


}
