package com.example.auctionservice.controller;

import com.example.auctionservice.SortType;
import com.example.auctionservice.dto.OfferDTO;
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
    List<Offer> getOffers(@RequestParam(required = false) SortType sortType,
                          @RequestParam(required = false) Integer page,
                          @RequestParam(required = false) Integer size) {
        log.info("Client sent request to get offer list");
        return offerService.getOffers(sortType, page, size);
    }

    @GetMapping("/{id}")
    Offer getOfferById(@PathVariable Long id) {
        log.info("Client sent request to get offer with id: {}", id);
        return offerService.getOfferById(id);
    }

    @PostMapping
    Offer addOffers(@RequestBody OfferDTO offerDTO) {
        return offerService.createOffer(offerDTO);
    }

    @PatchMapping("/{id}")
    Offer updateOffer(@PathVariable Long id, @RequestBody OfferDTO offerDTO) {
        return offerService.updateOffer(offerDTO);
    }

    @DeleteMapping("/{id}")
    Offer deleteOffer(@PathVariable Long id) {
        log.info("Client sent request to delete offer with id: {}", id);
        return offerService.deleteOffer(id);
    }
}
