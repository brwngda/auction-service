package com.example.auctionservice.model.request;

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
public class OfferRequest implements Serializable {
    private long offerId;
    private Product product;
    private boolean isPurchaseNote;
    private Double price;
    private boolean isPromoted;
    private String location;
    private PaymentMethod paymentMethod;

    public OfferRequest(Offer offer) {
        this.offerId = offer.getOfferId();
        this.product = offer.getProduct();
        this.isPurchaseNote = offer.isPurchaseNote();
        this.price = offer.getPrice();
        this.isPromoted = offer.isPromoted();
        this.paymentMethod = offer.getPaymentMethod();
    }
}
