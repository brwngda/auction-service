package com.example.auctionservice.repository;

import com.example.auctionservice.model.Offer;
import com.example.auctionservice.model.PaymentMethod;
import com.example.auctionservice.model.ProductCategory;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Long> {
    List<Offer> findAllByProductName(String productName);

    List<Offer> findAllByPaymentMethod(PaymentMethod paymentMethod, Pageable pageable);

}
