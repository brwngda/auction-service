package com.example.auctionservice.service;

import com.example.auctionservice.ExceptionHandler.NoOfferFoundException;
import com.example.auctionservice.dto.OfferDTO;
import com.example.auctionservice.model.Offer;
import com.example.auctionservice.repository.OfferRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.auctionservice.adapter.OfferAdapter.toEntity;

@Service
@RequiredArgsConstructor
public class OfferService {
    private final OfferRepository offerRepository;

    public List<Offer> getOffers() {
        return offerRepository.findAll();
    }

    public Offer getOfferById(Long id) {
        return offerRepository.findById(id).orElseThrow(() -> new NoOfferFoundException(id));
    }

    public Offer createOffer(OfferDTO offerDTO) {
        Offer entity = toEntity(offerDTO);
        return offerRepository.save(entity);
    }

    public Offer updateOffer(OfferDTO offerDTO) {
        Long offerId = offerDTO.getId();
        Offer updatedOffer = toEntity(offerId, offerDTO);
        return offerRepository.save(updatedOffer);
    }

    public Offer deleteOffer(Long id) {
        Offer offerFromDb = getOfferById(id);
        offerRepository.delete(offerFromDb);
        return offerFromDb;
    }
}
