package com.example.auctionservice.adapter;

import com.example.auctionservice.dto.OfferDTO;
import com.example.auctionservice.model.Offer;

public final class OfferAdapter {
    private OfferAdapter() {
    }

    public static OfferDTO toDto(Offer offer) {
        return new OfferDTO(offer);
    }

    public static Offer toEntity(OfferDTO offerDTO) {
        return new Offer(offerDTO);
    }

    public static Offer toEntity(Long id, OfferDTO offerDTO){
        Offer entity = toEntity(offerDTO);
        entity.setId(id);
        return entity;
    }
}
