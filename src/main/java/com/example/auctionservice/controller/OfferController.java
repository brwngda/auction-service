package com.example.auctionservice.controller;

import com.example.auctionservice.exception.NoOfferFoundException;
import com.example.auctionservice.model.PaymentMethod;
import com.example.auctionservice.model.SortType;
import com.example.auctionservice.model.request.OfferRequest;
import com.example.auctionservice.model.Offer;
import com.example.auctionservice.service.OfferService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.auctionservice.adapter.OfferAdapter.toDto;

@Slf4j
@RequestMapping("/offers")
@RestController
@RequiredArgsConstructor
public class OfferController {
    private final OfferService offerService;

    @GetMapping
    List<Offer> getOffers(@RequestParam(required = false) String productName,
                          @RequestParam(required = false) SortType sortType,
                          @RequestParam(required = false) Integer page,
                          @RequestParam(required = false) Integer size) {
        log.info("Client sent request to get offer list");
        return offerService.getOffers(productName, sortType, page, size);
    }

    @GetMapping("/category")
    List<Offer> getOfferByPaymentMethod(@RequestParam PaymentMethod paymentMethod,
                                        @RequestParam(required = false) SortType sortType,
                                        @RequestParam(required = false) Integer page,
                                        @RequestParam(required = false) Integer size) {
        return offerService.getOffersByPaymentMethod(paymentMethod, sortType, page, size);
    }

    @GetMapping("/{id}")
    Offer getOfferById(@PathVariable Long id) {
        log.info("Client sent request to get offer with id: {}", id);
        return offerService.getOfferById(id);
    }

    @PostMapping
    OfferRequest addOffer(@RequestBody OfferRequest offerRequest) {
        return toDto(offerService.createOffer(offerRequest));
    }

    @PatchMapping("/{id}")
    Offer updateOffer(@PathVariable Long id, @RequestBody OfferRequest offerRequest) {
        return offerService.updateOffer(id, offerRequest);
    }

    @DeleteMapping("/{id}")
    Offer deleteOffer(@PathVariable Long id) {
        log.info("Client sent request to delete offer with id: {}", id);
        return offerService.deleteOffer(id);
    }

    //TODO: cos tu nie gra z ta zakomentowana linijka.
    @ExceptionHandler(NoOfferFoundException.class)
    private ResponseEntity<Error> mapNoSuchElementException(NoOfferFoundException ex) {
        return new ResponseEntity<>(
//                new Error(HttpStatus.NOT_FOUND.value(), ex.getMessage()),
                HttpStatus.NOT_FOUND);
    }
}
