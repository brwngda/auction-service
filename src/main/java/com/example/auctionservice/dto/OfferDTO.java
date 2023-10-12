package com.example.auctionservice.dto;

import com.example.auctionservice.model.Offer;
import com.example.auctionservice.model.PaymentMethod;
import com.example.auctionservice.model.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OfferDTO implements Serializable {
    private Long id;
    private Product product;
    private boolean purchaseNotes;
    private Double price;
    private boolean promoted;
    private String location;
    private PaymentMethod paymentMethod;

    public OfferDTO(Offer offer) {
        this.id = offer.getId();
        this.product = offer.getProduct();
        this.purchaseNotes = offer.isPurchaseNotes();
        this.price = offer.getPrice();
        this.promoted = offer.isPromoted();
        this.location = offer.getLocation();
        this.paymentMethod = offer.getPaymentMethod();
    }
}
