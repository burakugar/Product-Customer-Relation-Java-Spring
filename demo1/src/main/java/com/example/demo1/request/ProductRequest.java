package com.example.demo1.request;

import lombok.Data;

@Data
public class ProductRequest {
    private Long id;
    private String productName;
    private Integer qty;
    private Integer price;
}
