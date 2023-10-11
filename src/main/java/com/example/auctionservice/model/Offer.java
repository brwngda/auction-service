package com.example.auctionservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;


import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Offer {
    @Id
    @GeneratedValue
    private Long id;
    @OneToOne(cascade = CascadeType.ALL)
    private Product product;
    private boolean purchaseNotes;
    private double price;
    private boolean promoted;
    private String location;
    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    @CreationTimestamp
    private LocalDateTime createdAt;
    private LocalDateTime finishedAt;

    public Offer(Product product, boolean purchaseNotes, double price, boolean promoted, String location, PaymentMethod paymentMethod) {
        this.product = product;
        this.purchaseNotes = purchaseNotes;
        this.price = price;
        this.promoted = promoted;
        this.location = location;
        this.paymentMethod = paymentMethod;
    }
}
