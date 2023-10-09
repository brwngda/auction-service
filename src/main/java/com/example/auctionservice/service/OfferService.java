package com.example.auctionservice.service;

import com.example.auctionservice.model.Offer;
import com.example.auctionservice.repository.OfferRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfferService {
    private final OfferRepository offerRepository;

    public OfferService(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    public List<Offer> getOffers() {
        return offerRepository.findAll();
    }

    public Offer addOffer(Offer offer) {
        return offerRepository.save(offer);
    }
}
