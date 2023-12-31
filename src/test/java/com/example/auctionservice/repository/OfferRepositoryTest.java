package com.example.auctionservice.repository;

import com.example.auctionservice.model.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class OfferRepositoryTest {
    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private OfferRepository offerRepository;

    @Test
    void given_empty_offer_repo_when_access_offer_by_id_then_no_item_should_be_returned() {

        Optional<Offer> result = offerRepository.findById(1L);

        assertFalse(result.isPresent());
    }

    @Test
    void given_offer_repo_with_records_when_access_offer_by_id_then_item_with_provided_id_should_be_returned() {
        //given
        testEntityManager.persist(new Offer((new Product("Renault Megane", "Awesome car", ProductCondition.USED, ProductCategory.AUTOMOTIVE)),
                true, 10000D, true, "Gdansk", PaymentMethod.CASH));

        //when
        Optional<Offer> result = offerRepository.findById(7L);

        //then
        assertTrue(result.isPresent());
        assertEquals(7L, result.get().getOfferId());
        assertEquals("Renault Megane", result.get().getProduct().getName());
    }

}