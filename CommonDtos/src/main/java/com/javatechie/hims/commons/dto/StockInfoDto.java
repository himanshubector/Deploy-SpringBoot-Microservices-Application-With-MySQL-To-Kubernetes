package com.javatechie.hims.commons.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class StockInfoDto
{
    private int productId;
    private boolean isAvailable;
    private String productName;

}

