package com.example.auctionservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


import java.time.Duration;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Offer {
    @Id
    @GeneratedValue
    private Long id;
    private Product product;
    private boolean purchaseNotes;
    private double price;
    private Duration duration;
    private boolean promoted;
    private String location;
    private PaymentMethod paymentMethod;

    private LocalDateTime createdAt;
    private LocalDateTime finishedAt;

}
