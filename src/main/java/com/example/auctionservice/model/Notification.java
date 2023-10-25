package com.example.auctionservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long notificationId;
    private String type;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long auctionId;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long messageId;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long receiverId;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long actorId;
    private boolean isSeen;
    @CreationTimestamp
    private LocalDateTime createdAt;
}
