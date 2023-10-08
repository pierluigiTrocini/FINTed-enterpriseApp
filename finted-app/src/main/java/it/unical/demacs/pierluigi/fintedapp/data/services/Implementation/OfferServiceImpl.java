package it.unical.demacs.pierluigi.fintedapp.data.services.Implementation;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import it.unical.demacs.pierluigi.fintedapp.data.dao.OfferDao;
import it.unical.demacs.pierluigi.fintedapp.data.dao.PostDao;
import it.unical.demacs.pierluigi.fintedapp.data.dao.UserDao;
import it.unical.demacs.pierluigi.fintedapp.data.entities.Offer;
import it.unical.demacs.pierluigi.fintedapp.data.services.OfferService;
import it.unical.demacs.pierluigi.fintedapp.dto.OfferDto;
import it.unical.demacs.pierluigi.fintedapp.dto.OfferPublishDto;
import it.unical.demacs.pierluigi.fintedapp.exception.ElementNotFoundException;
import it.unical.demacs.pierluigi.fintedapp.exception.NullFieldException;
import it.unical.demacs.pierluigi.fintedapp.utility.DateManager;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OfferServiceImpl implements OfferService {
    private final OfferDao offerDao;
    private final PostDao postDao;
    private final UserDao userDao;

    private final ModelMapper modelMapper;

    @Override
    public OfferDto save(OfferPublishDto offer) throws NullFieldException, ElementNotFoundException {
        Offer newOffer = new Offer();

        newOffer.setUser( userDao.findById(offer.getUser().getId()).orElseThrow(() -> new ElementNotFoundException("User not found")));
        newOffer.setPost( postDao.findById(offer.getPost().getId()).orElseThrow(() -> new ElementNotFoundException("Post not found")) );
        newOffer.setOffer( offer.getOffer() );
        newOffer.setPublishDate( DateManager.getInstance().currentDate() );

        return modelMapper.map(offerDao.save(newOffer), OfferPublishDto.class);
    }

    @Override
    public void delete(Long id) throws NullFieldException, ElementNotFoundException {
        if( !offerDao.existsById( Optional.ofNullable(id).orElseThrow(() -> new NullFieldException("no id as requet param"))))
            throw new ElementNotFoundException("Post not found");
        
        offerDao.deleteById(id);
    }

    @Override
    public List<OfferDto> getAll(Long id) {
        return offerDao.findAll().stream()
            .map(offer -> modelMapper.map(offer, OfferPublishDto.class))
            .collect(Collectors.toList());
    }
    
}
