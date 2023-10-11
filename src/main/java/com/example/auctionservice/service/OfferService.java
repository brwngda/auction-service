package com.example.auctionservice.service;

import com.example.auctionservice.ExceptionHandler.NoOfferFoundException;
import com.example.auctionservice.dto.CreateOfferRequest;
import com.example.auctionservice.model.Offer;
import com.example.auctionservice.model.Product;
import com.example.auctionservice.repository.OfferRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfferService {
    private final OfferRepository offerRepository;

    public OfferService(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    // CZEKA NA KONRADA
//    public Offer createOffer(CreateOfferRequest request) {
//        Offer offer = new Offer(new Product())
//        return offerRepository.save(offer);
//    }

    public List<Offer> getOffers() {
        return offerRepository.findAll();
    }

    public Offer getOfferById(Long id) {
        return offerRepository.findById(id).orElseThrow(
                () -> new NoOfferFoundException(id));
    }

    public Offer updateOffer(Long id, Offer offer) {
        Offer offerToUpdate = getOfferById(id);
        String offerLocation = offer.getLocation();
        if (offerLocation != null && !offerLocation.equals(offerToUpdate.getLocation())) {
            offerToUpdate.setLocation(offerLocation);
        }
        return offerRepository.save(offerToUpdate);
    }
}
