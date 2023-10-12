package com.example.auctionservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Set;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String description;
    @Enumerated(EnumType.STRING)
    private ProductCondition productCondition;
    @Enumerated(EnumType.STRING)
    private ProductCategory productCategory;

    public Product(String title, String description, ProductCondition productCondition, ProductCategory productCategory) {
        this.title = title;
        this.description = description;
        this.productCondition = productCondition;
        this.productCategory = productCategory;
    }
}
