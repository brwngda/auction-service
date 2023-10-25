package com.example.auctionservice.adapter;

import com.example.auctionservice.model.request.OfferRequest;
import com.example.auctionservice.model.Offer;

public final class OfferAdapter {
    private OfferAdapter() {
    }

    public static OfferRequest toDto(Offer offer) {
        return new OfferRequest(offer);
    }

    public static Offer toEntity(OfferRequest offerRequest) {
        return new Offer(offerRequest);
    }

    public static Offer toEntity(Long id, OfferRequest offerRequest){
        Offer entity = toEntity(offerRequest);
        entity.setOfferId(id);
        return entity;
    }
}
