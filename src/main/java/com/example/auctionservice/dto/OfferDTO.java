package com.example.auctionservice.dto;

import com.example.auctionservice.model.PaymentMethod;
import com.example.auctionservice.model.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OfferDTO {
    private Long id;
    private Product product;
    private Boolean purchaseNotes;
    private Double price;
    private Boolean promoted;
    private String location;
    private PaymentMethod paymentMethod;
}
