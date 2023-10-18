package com.example.auctionservice.exception;

public class NoOfferFoundException extends RuntimeException {
    public NoOfferFoundException(Long id) {
        super(String.format("Offer with id %d has not been found", id));
    }
}
