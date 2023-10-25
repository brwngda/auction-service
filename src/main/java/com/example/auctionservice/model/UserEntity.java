package com.example.auctionservice.model;

import com.example.auctionservice.model.request.UserRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String location;
    private boolean isAdmin;
    private boolean isApproved;
    @CreationTimestamp
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "receiver")
    private Set<Rating> rating;
    @OneToMany(mappedBy = "actor")
    private Set<Notification> notifications;
    @OneToMany(mappedBy = "userEntity")
    private Set<Offer> offers;

    public UserEntity(UserRequest userRequest) {
        this.userId = userRequest.getUserId();
        this.username = userRequest.getUsername();
        this.firstName = userRequest.getFirstName();
        this.lastName = userRequest.getLastName();
        this.email = userRequest.getEmail();
        this.phoneNumber = userRequest.getPhoneNumber();
        this.location = userRequest.getLocation();
        this.isAdmin = userRequest.isAdmin();
        this.isApproved = userRequest.isApproved();
        this.rating = userRequest.getRating();
        this.notifications = userRequest.getNotifications();
        this.offers = userRequest.getOffers();
    }
}
