package com.javatechie.hims.product.cronjob;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;




@Component
public class ProductStockChecker
{

   /* @Scheduled(cron = "0 0 * * * *") // Cron expression for running every hour
    public void checkProductAvailability()
    {
        // Replace 'productId' with the actual ID of the product you're checking
        Long productId = 123L;

        Product product = productService.getProductById(productId);



        if (product != null && product.isOutOfStock())
        {
            // Logic to handle back-in-stock event, e.g., sending notifications
            System.out.println("Product is back in stock: " + product.getName());
        }
    }*/




  /*  public void checkProductStockAvailability(String productId)
    {
        Stock stock = new Stock();

        Stock productStock = stockRepository.findById(Integer.valueOf(productId)).orElseThrow(() -> new RuntimeException("Stock not found"));

        int stockQuantity = productStock.getStockQuantity();

        String stockStatus = productStock.getStockStatus().name();


        if(stockQuantity != 0 && stockStatus.equals(StockStatus.IN_STOCK.name()))
        {
            // KafkaProducer.publishProductAvailability(productId, isAvailable);
        }

    }*/

}
