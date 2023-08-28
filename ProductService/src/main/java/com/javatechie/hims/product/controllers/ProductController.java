package com.javatechie.hims.product.controllers;


import com.javatechie.hims.product.entities.Product;
import com.javatechie.hims.product.services.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/products")
public class ProductController
{
    @Autowired
    private StockService stockService;


/*    @Autowired
    private ProductService productService;*/


    @PostMapping("/subscribe/product/{productId}/user/{userId}")
    public ResponseEntity<Product> subscribeForProductNotifications(@PathVariable String userId, @PathVariable String productId)
    {

        // notificationService.subscribeToProductNotifications(userId, productId);

        return new ResponseEntity<>(HttpStatus.OK);
    }


/*
    @GetMapping
    public ResponseEntity<ApiResponse> checkProductStockAvailability()
    {
        productService.checkProductStockAvailability();
        return new ResponseEntity(new ApiResponse("Product Stock Availability Checked Successfully", true), HttpStatus.OK);

    }*/

}
