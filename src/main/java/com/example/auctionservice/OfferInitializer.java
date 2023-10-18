//package com.example.auctionservice;
//
//import com.example.auctionservice.model.*;
//import com.example.auctionservice.repository.OfferRepository;
//import jakarta.annotation.PostConstruct;
//import org.springframework.stereotype.Component;
//
//import java.time.LocalDateTime;
//import java.util.Arrays;
//
//@Component
//public class OfferInitializer {
//    private final OfferRepository offerRepository;
//
//    public OfferInitializer(OfferRepository offerRepository) {
//        this.offerRepository = offerRepository;
//    }
//
//    @PostConstruct
//    void init() {
//        offerRepository.saveAll(Arrays.asList(
//                new Offer(new Product("Telefon", "description", ProductCondition.USED, ProductCategory.ELECTRONICS),
//                        true, 200, true, "Gdansk", PaymentMethod.CASH),
//                new Offer(new Product("Laptop", "opis produktu", ProductCondition.DAMAGED, ProductCategory.ELECTRONICS),
//                        false, 200, true, "Gdynia", PaymentMethod.CASH),
//                new Offer(new Product("Materac", "opis produktu", ProductCondition.NEW, ProductCategory.HOME_AND_GARDEN),
//                        true, 100, false, "Dupa", PaymentMethod.TRANSFER),
//                new Offer(new Product("Kawa", "opis produktu", ProductCondition.NEW, ProductCategory.AUTOMOTIVE),
//                        true, 100, false, "Warszawa", PaymentMethod.TRANSFER),
//        new Offer(new Product("Kawa", "description", ProductCondition.NEW, ProductCategory.AUTOMOTIVE),
//                true, 200, true, "Gdansk", PaymentMethod.CASH),
//                new Offer(new Product("Dupa2", "description", ProductCondition.USED, ProductCategory.AUTOMOTIVE),
//                        false, 200, true, "Warszawa", PaymentMethod.CASH),
//                new Offer(new Product("Dupa", "opis produktu", ProductCondition.USED, ProductCategory.AUTOMOTIVE),
//                        true, 100, false, "Szczecin", PaymentMethod.TRANSFER),
//                new Offer(new Product("Dupa3", "description", ProductCondition.NEW, ProductCategory.AUTOMOTIVE),
//                        true, 100, false, "Elbląg", PaymentMethod.TRANSFER)
//        ));
//    }
//}
