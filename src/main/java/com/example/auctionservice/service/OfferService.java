package com.example.auctionservice.service;

import com.example.auctionservice.ExceptionHandler.NoOfferFoundException;
import com.example.auctionservice.dto.OfferDTO;
import com.example.auctionservice.model.Offer;
import com.example.auctionservice.repository.OfferRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public Offer getOfferById(Long id) {
        return offerRepository.findById(id).orElseThrow(
                () -> new NoOfferFoundException(id));
    }

    private OfferDTO transformOfferToOfferDTO(Offer offer) {
        OfferDTO offerDTO = new OfferDTO();
        offerDTO.setProduct(offer.getProduct());
        offerDTO.setPurchaseNotes(offer.isPurchaseNotes());
        offerDTO.setPrice(offer.getPrice());
        offerDTO.setPromoted(offer.isPromoted());
        offerDTO.setLocation(offer.getLocation());
        offerDTO.setPaymentMethod(offer.getPaymentMethod());
        return offerDTO;
    }

    private Offer transformOfferDtoToOffer(Offer offer, OfferDTO offerDTO) {
        offer.setProduct(offerDTO.getProduct());
        offer.setPurchaseNotes(offerDTO.getPurchaseNotes());
        offer.setPrice(offerDTO.getPrice());
        offer.setPromoted(offerDTO.getPromoted());
        offer.setLocation(offerDTO.getLocation());
        offer.setPaymentMethod(offerDTO.getPaymentMethod());
        return offer;
    }

    public Offer createOffer(OfferDTO offerDTO) {
        Offer offer = new Offer();
        Offer newOffer = transformOfferDtoToOffer(offer, offerDTO);
        return offerRepository.save(newOffer);
    }
    public Offer updateOffer(OfferDTO offerDTO) {
        Long offerId = offerDTO.getId();
        Offer offer = getOfferById(offerId);
        Offer updatedOffer = transformOfferDtoToOffer(offer, offerDTO);
        return offerRepository.save(updatedOffer);
    }
}
