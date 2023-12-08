package it.unical.demacs.pierluigi.fintedapp.data.services;

import java.util.List;

import it.unical.demacs.pierluigi.fintedapp.dto.OfferDto;

public interface OfferService {
    OfferDto save(OfferDto offer);

    void delete(Long id);

    List<OfferDto> getPostOffers(Long postId);

    List<OfferDto> getUserOffers(Long userId);
}
