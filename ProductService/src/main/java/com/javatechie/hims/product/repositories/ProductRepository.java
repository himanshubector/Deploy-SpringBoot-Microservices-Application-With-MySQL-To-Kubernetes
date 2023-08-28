package com.javatechie.hims.product.repositories;


import com.javatechie.hims.product.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product, Integer>
{


}
