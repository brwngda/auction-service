package com.example.auctionservice.model;


import java.time.LocalDateTime;

class Product {
    private Long id;
    private String name;
    private String description;
    private ProductCategory productCategory;
    private Double minPrice;
    private Double buyNow;
    private boolean promoted;
    private String location;

    private LocalDateTime createdAt;
    private LocalDateTime finishedAt;
}

class ProductCategory {
    String name;
}
