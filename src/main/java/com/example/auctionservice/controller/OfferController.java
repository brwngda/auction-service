package com.example.auctionservice.controller;

import com.example.auctionservice.dto.CreateOfferRequest;
import com.example.auctionservice.model.Offer;
import com.example.auctionservice.service.OfferService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequestMapping("/offers")
@RestController
public class OfferController {
    private final OfferService offerService;

    public OfferController(OfferService offerService) {
        this.offerService = offerService;
    }

    @GetMapping
    List<Offer> getOffers() {
        log.info("Client sent request for offer list");
        return offerService.getOffers();
    }

    @GetMapping("/{id}")
    Offer getOfferById(@PathVariable Long id) {
        log.info("Client sent request for offer with id: {}", id);
        return offerService.getOfferById(id);
    }
//    CZEKA NA KONRADA
//    @PostMapping
//    Offer addOffers(@RequestBody CreateOfferRequest offer) {
//        return offerService.createOffer(offer);
//    }

    @PatchMapping("/{id}")
    Offer updateOffer(@PathVariable Long id, @RequestBody Offer offer) {
        return offerService.updateOffer(id, offer);
    }
}
