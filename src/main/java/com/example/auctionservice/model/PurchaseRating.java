package com.example.auctionservice.model;

class PurchaseRating {
    private Long id;
    private Purchase purchase;
    private String comment;

    private boolean recommendation;
    private overallRating overallRating;
}

enum overallRating {
    EXCELLENT,
    GOOD,
    AVERAGE,
    FAIR,
    POOR;

}
