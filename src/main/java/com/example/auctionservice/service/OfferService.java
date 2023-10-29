package com.example.auctionservice.service;

import com.example.auctionservice.exception.NoOfferFoundException;
import com.example.auctionservice.model.PaymentMethod;
import com.example.auctionservice.model.ProductCategory;
import com.example.auctionservice.model.SortType;
import com.example.auctionservice.model.request.OfferRequest;
import com.example.auctionservice.model.Offer;
import com.example.auctionservice.repository.OfferRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.auctionservice.adapter.OfferAdapter.toEntity;

@Service
@RequiredArgsConstructor
public class OfferService {
    private final OfferRepository offerRepository;

    public List<Offer> getOffers(String productName, SortType sortType, Integer page, Integer size) {
        Pageable pageable = providePageable(page, size, sortType);
        if (productName != null) {
            return offerRepository.findAllByProductName(productName);
        }
        return offerRepository.findAll(pageable).toList();
    }

    public List<Offer> getOffersByPaymentMethod(PaymentMethod paymentMethod, SortType sortType, Integer page, Integer size) {
        Pageable pageable = providePageable(page, size, sortType);
        if (paymentMethod != null) {
            return offerRepository.findAllByPaymentMethod(paymentMethod, pageable);
        }
        return offerRepository.findAll(pageable).toList();
    }

    public Offer getOfferById(Long id) {
        return offerRepository.findById(id).orElseThrow(() -> new NoOfferFoundException(id));
    }

    public Offer createOffer(OfferRequest offerRequest) {
        Offer entity = toEntity(offerRequest);
        return offerRepository.save(entity);
    }

    public Offer updateOffer(Long id, OfferRequest offerRequest) {
        Offer offerToUpdate = offerRepository.findById(id)
                .orElseThrow(() -> new NoOfferFoundException(id));
        Offer updatedOffer = toEntity(id, offerRequest);
        return offerRepository.save(updatedOffer);
    }

    public Offer deleteOffer(Long id) {
        Offer offerFromDb = offerRepository.findById(id)
                .orElseThrow(() -> new NoOfferFoundException(id));
        offerRepository.delete(offerFromDb);
        return offerFromDb;
    }

    Pageable providePageable(Integer page, Integer size, SortType sortType) {
        Sort.Direction direction = SortType.DESC == sortType ? Sort.Direction.DESC : Sort.Direction.ASC;
        Sort sort = Sort.by(direction, "location");
        return PageRequest.of(
                page != null && size != null ? page : 0,
                page != null && size != null ? size : (int) offerRepository.count(), sort);

    }
}
