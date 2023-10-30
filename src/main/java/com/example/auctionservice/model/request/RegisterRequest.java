package com.example.auctionservice.model.request;

import com.example.auctionservice.model.Notification;
import com.example.auctionservice.model.Offer;
import com.example.auctionservice.model.Rating;
import com.example.auctionservice.model.Role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    private long userId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phoneNumber;
    private String location;
    private boolean isApproved;
    private Set<Rating> rating;
    private Set<Notification> notifications;
    private Set<Offer> offers;
    private Role role;

}
