package com.example.auctionservice.model.response;


public enum Error {
    NOT_FOUND_OFFER(404, "is not found");

    private final int code;
    private final String message;

    Error(int code, String message) {
        this.code = code;
        this.message = message;
    }

}
