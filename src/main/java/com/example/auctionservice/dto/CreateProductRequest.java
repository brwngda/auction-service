package com.example.auctionservice.dto;

import com.example.auctionservice.model.ProductCategory;
import com.example.auctionservice.model.ProductCondition;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateProductRequest {
    private String title;
    private String description;
    private ProductCondition productCondition;
    private ProductCategory productCategory;
}
