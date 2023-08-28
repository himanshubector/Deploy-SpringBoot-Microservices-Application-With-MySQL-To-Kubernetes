package com.javatechie.hims.product.repositories;


import com.javatechie.hims.product.entities.Stock;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StockRepository extends JpaRepository<Stock, Integer>
{

    // custom finder method

    Stock findByProductProductId(int productId);

    // Method name findByProductProductId
    // This will match product.productId since Product is the nested associated entity

    // So, Spring Data JPA in Spring Boot 3 simplifies creating custom queries by method name.
    // In Spring Data JPA, the method name itself can be used to define custom queries.






/*    @Query("SELECT s FROM Stock s WHERE s.product.productId = :productId")
    Stock findByProductId(@Param("productId") int productId);*/


   /* Create a method starting with findBy
    Use the name of the field you want to query on, in this case ProductId
    Since product is a nested object, use s.product.productId in the JPQL query
    Annotate with @Query to specify custom JPQL query
    Use @Param to bind the method parameter*/


   /* So this allows fetching a Stock entity by passing the product id, even though product is a nested associated object.*/
}
