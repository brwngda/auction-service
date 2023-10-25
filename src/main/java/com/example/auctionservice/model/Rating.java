package com.example.auctionservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Rating {
    @Id
    private long fromId;
    @Id
    private long toId;
    @Id
    private long auctionId;
    private int rating;
    private boolean isSeller;
    @ManyToOne
    private User user;
}
