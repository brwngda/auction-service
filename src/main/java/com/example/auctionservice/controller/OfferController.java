package com.example.auctionservice.controller;

import com.example.auctionservice.model.Offer;
import com.example.auctionservice.service.OfferService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/offers")
@RestController
public class OfferController {
    private final OfferService offerService;

    public OfferController(OfferService offerService) {
        this.offerService = offerService;
    }

    @GetMapping
    List<Offer> getOffers() {
        return offerService.getOffers();
    }
    @PostMapping
    Offer addOffers(@RequestBody Offer offer) {
        return offerService.addOffer(offer);
    }
}
