package com.example.auctionservice.model;

import com.example.auctionservice.dto.OfferDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Offer {
    @Id
    @GeneratedValue
    private Long id;
    @OneToOne(cascade = CascadeType.ALL)
    private Product product;
    private boolean purchaseNotes;

    private double price;
    private boolean promoted;
    @NotNull
    @NotBlank
    private String location;
    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    @CreationTimestamp
    private LocalDateTime createdAt;
    private LocalDateTime finishedAt;

    public Offer(OfferDTO offerDTO) {
        this.id = offerDTO.getId();
        this.product = offerDTO.getProduct();
        this.purchaseNotes = offerDTO.isPurchaseNotes();
        this.price = offerDTO.getPrice();
        this.promoted = offerDTO.isPromoted();
        this.location = offerDTO.getLocation();
        this.paymentMethod = offerDTO.getPaymentMethod();
    }

    // przerobić na buildera
    public Offer(Product product, boolean purchaseNotes, double price, boolean promoted, String location, PaymentMethod paymentMethod) {
        this.product = product;
        this.purchaseNotes = purchaseNotes;
        this.price = price;
        this.promoted = promoted;
        this.location = location;
        this.paymentMethod = paymentMethod;

    }
}

