package com.example.auctionservice.model;

import com.example.auctionservice.model.request.OfferRequest;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long offerId;
    @OneToOne(cascade = CascadeType.ALL)
    private Product product;
    private boolean isPurchaseNote;

    private double price;
    private boolean isPromoted;
    @NotNull
    @NotBlank
    private String location;
    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    @CreationTimestamp
    private LocalDateTime createdAt;
    private LocalDateTime finishedAt;
    @ManyToOne
    private UserEntity userEntity;

    public Offer(OfferRequest offerRequest) {
        this.offerId = offerRequest.getOfferId();
        this.product = offerRequest.getProduct();
        this.isPurchaseNote = offerRequest.isPurchaseNote();
        this.price = offerRequest.getPrice();
        this.isPromoted = offerRequest.isPromoted();
        this.location = offerRequest.getLocation();
        this.paymentMethod = offerRequest.getPaymentMethod();
    }
//TODO  TEN KONSTRUKTOR ISTNIEJE WYŁĄCZNIE NA POTRZEBĘ TESTU???????????????????
    public Offer(Product product, boolean isPurchaseNote, double price, boolean isPromoted, String location, PaymentMethod paymentMethod) {
        this.product = product;
        this.isPurchaseNote = isPurchaseNote;
        this.price = price;
        this.isPromoted = isPromoted;
        this.location = location;
        this.paymentMethod = paymentMethod;

    }
}

