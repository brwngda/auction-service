package com.example.auctionservice.service;

import com.example.auctionservice.ExceptionHandler.NoOfferFoundException;
import com.example.auctionservice.SortType;
import com.example.auctionservice.dto.OfferDTO;
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

    public List<Offer> getOffers(SortType sortType, Integer page, Integer size) {
        Pageable pageable = providePageable(page, size, sortType);
        return offerRepository.findAll(pageable).toList();
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

    Pageable providePageable(Integer page, Integer size, SortType sortType) {
        Sort.Direction direction = SortType.DESC == sortType ? Sort.Direction.DESC : Sort.Direction.ASC;
        Sort sort = Sort.by(direction, "location");
        return PageRequest.of(
                page != null && size != null ? page : 0,
                page != null && size != null ? size : (int) offerRepository.count(), sort);

    }
}
