package com.javatechie.hims.product.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Table(name = "stocks")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Stock
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int stockId;


    private int stockQuantity;


    @Enumerated(EnumType.STRING)
    private StockStatus stockStatus;



    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id", referencedColumnName = "productId") // @JoinColumn on the inverse side (Stock) refers to the product_id FK
    private Product product;



}
