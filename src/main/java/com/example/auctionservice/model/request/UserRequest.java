package com.example.auctionservice.model.request;

import com.example.auctionservice.model.Notification;
import com.example.auctionservice.model.Offer;
import com.example.auctionservice.model.Rating;
import com.example.auctionservice.model.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Set;

//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
//public class UserRequest implements Serializable {
//    private long userId;
//    private String firstName;
//    private String lastName;
//    private String email;
//    private String phoneNumber;
//    private String location;
//    private boolean isAdmin;
//    private boolean isApproved;
//    private Set<Rating> rating;
//    private Set<Notification> notifications;
//    private Set<Offer> offers;
//
//    public UserRequest(UserEntity userEntity) {
//        this.userId = userEntity.getUserId();
//        this.firstName = userEntity.getFirstName();
//        this.lastName = userEntity.getLastName();
//        this.email = userEntity.getEmail();
//        this.phoneNumber = userEntity.getPhoneNumber();
//        this.location = userEntity.getLocation();
//        this.isAdmin = userEntity.isAdmin();
//        this.isApproved = userEntity.isApproved();
//        this.rating = userEntity.getRating();
//        this.notifications = userEntity.getNotifications();
//        this.offers = userEntity.getOffers();
//    }
//}
