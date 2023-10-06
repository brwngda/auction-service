package com.example.auctionservice.model;

import java.time.LocalDateTime;

class UserAccount {
    private Long id;
    private String username;
    private String login;
    private String password;
    private String location;
    private Status status;
    private Type type;
    private LocalDateTime createdAt;
}

enum Status {
    NONACTIVE,
    ACTIVE,
    BLOCKED;
}

enum Type {
    STANDARD,
    PREMIUM;
}
