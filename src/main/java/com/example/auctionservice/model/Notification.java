package com.example.auctionservice.model;

import jakarta.persistence.*;
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
    private long auctionId;
    @Id
    private long messageId;
    @Id
    private long receiverId;
    @Id
    private long actorId;
    private boolean isSeen;
    @CreationTimestamp
    private LocalDateTime createdAt;
    @ManyToOne
    private UserEntity actor;
}
