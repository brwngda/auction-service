package com.example.auctionservice.exception;

public class NoUserFoundException extends RuntimeException {
    public NoUserFoundException(Long id) {
        super(String.format("User with id %d has not been found", id));
    }
}
