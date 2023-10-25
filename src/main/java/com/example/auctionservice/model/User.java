package com.example.auctionservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
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
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "user")
    private Set<Rating> rating;
    @OneToMany(mappedBy = "user")
    private Set<Notification> notifications;
    @OneToMany(mappedBy = "user")
    private Set<Offer> offers;


}
