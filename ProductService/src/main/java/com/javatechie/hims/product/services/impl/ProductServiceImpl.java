package com.javatechie.hims.product.services.impl;


import com.javatechie.hims.commons.dto.StockInfoDto;
import com.javatechie.hims.product.entities.Stock;
import com.javatechie.hims.product.entities.StockStatus;
import com.javatechie.hims.product.repositories.StockRepository;
import com.javatechie.hims.product.services.ProductService;
import com.javatechie.hims.product.services.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;



@Service
public class ProductServiceImpl implements ProductService
{
    // This service manages product data and availability,
    // and it should publish availability updates to Kafka when a product's status changes.

    @Autowired
    private StockService stockService;

    @Autowired
    private StockRepository stockRepository;

    @Autowired
    private RestTemplate restTemplate;


    @Autowired
    private KafkaTemplate<String, StockInfoDto> kafkaTemplate;


    // Product availability management logic


    @Override
    @Scheduled(cron = "0 * * * * *") // Cron expression for running every minute
    public boolean checkProductStockAvailability()
    {

        System.out.println("Inside checkProductStockAvailability Cron job method !!!!!!!");

        ResponseEntity<String[]> response = restTemplate.getForEntity("http://HARNEET-USER-SERVICE/users/subscribed/notifications/products", String[].class);

        // List<String> productIdList = Arrays.asList(response.getBody());

        String[] arr = response.getBody();

        Set<String> productIdSet = new HashSet<>(Arrays.asList(arr));


        // Set<String> productIdSet = Arrays.stream(response.getBody()).collect(Collectors.toSet());


        productIdSet.stream().forEach(productId -> {
            Stock stock = stockRepository.findByProductProductId(Integer.valueOf(productId));
            publishProductAvailability(stock);
        });


        return true;

    }



    public void publishProductAvailability(Stock stock)
    {

        System.out.println("stock qty************** :" + stock.getStockQuantity());

        System.out.println("stock status************** :" + stock.getStockStatus() + stock.getStockStatus().name() + stock.getStockStatus().toString());

        System.out.println(stock.getStockStatus() == StockStatus.IN_STOCK); // prints true



        if (stock.getStockQuantity() > 0 && stock.getStockStatus() == StockStatus.IN_STOCK)
        {
             kafkaTemplate.send("stock-topic", new StockInfoDto(stock.getProduct().getProductId(), true, stock.getProduct().getProductName()));
             System.out.println("Message published to Kafka topic successfully!!!!");
        }

        else
        {
             System.out.println("Message Not Published to Kafka topic..........");
        }

    }





/*
    @Service
    public class NotificationConsumer
    {

        @KafkaListener(topics = "events")
        public void handleEvent(ProductEvent event)
        {
            if(event.type == "backInStock")
            {
                // send notification for product
            }
        }

    }*/

// This architecture allows loose coupling between services using Kafka events.
// Additional services can also subscribe to events.





   /* public void publishProductAvailability(String productId, String stockStatus)
    {
        // Update product availability and publish availability change to Kafka

        // KafkaProducer.publishProductAvailability(productId, isAvailable);
    }*/


    // To store 3 values - product id, boolean stock availability, and stock status enum in the Kafka message, you can create a custom class:


   /* class StockCheck
    {

        private Long productId;
        private StockStatus status;
        private boolean isAvailable;

        // Constructor and getters
    }
*/


    // StockCheck msg = new StockCheck(id, stock.getStatus(), stock.getQuantity() > 0);

    // kafkaTemplate.send("topic", msg);


}
