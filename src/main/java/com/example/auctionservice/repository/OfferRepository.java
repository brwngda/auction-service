package com.example.auctionservice.repository;

import com.example.auctionservice.model.Offer;
import com.example.auctionservice.model.PaymentMethod;
import com.example.auctionservice.model.ProductCondition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Long> {
}
