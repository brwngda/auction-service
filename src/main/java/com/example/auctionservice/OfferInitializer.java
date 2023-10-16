package com.example.auctionservice;

import com.example.auctionservice.model.*;
import com.example.auctionservice.repository.OfferRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

@Component
public class OfferInitializer {
    private final OfferRepository offerRepository;

    public OfferInitializer(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    @PostConstruct
    void init() {
        offerRepository.saveAll(Arrays.asList(
                new Offer(new Product("Dupa1", "description", ProductCondition.NEW, ProductCategory.AUTOMOTIVE),
                        true, 200, true, "Gdansk", PaymentMethod.CASH),
                new Offer(new Product("Dupa2", "description", ProductCondition.NEW, ProductCategory.AUTOMOTIVE),
                        false, 200, true, "Gdynia", PaymentMethod.CASH),
                new Offer(new Product("Dupa", "description", ProductCondition.NEW, ProductCategory.AUTOMOTIVE),
                        true, 100, false, "Dupa", PaymentMethod.TRANSFER),
                new Offer(new Product("Dupa3", "description", ProductCondition.NEW, ProductCategory.AUTOMOTIVE),
                        true, 100, false, "Gdynia", PaymentMethod.TRANSFER)
        ));
    }
}
