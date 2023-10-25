package com.example.auctionservice.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String description;
    @Enumerated(EnumType.STRING)
    private ProductCondition productCondition;
    @Enumerated(EnumType.STRING)
    private ProductCategory productCategory;

    public Product(String name, String description, ProductCondition productCondition, ProductCategory productCategory) {
        this.name = name;
        this.description = description;
        this.productCondition = productCondition;
        this.productCategory = productCategory;
    }

}
