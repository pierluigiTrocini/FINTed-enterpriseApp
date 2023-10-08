package it.unical.demacs.pierluigi.fintedapp.data.services.Implementation;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import it.unical.demacs.pierluigi.fintedapp.data.dao.ReviewDao;
import it.unical.demacs.pierluigi.fintedapp.data.dao.UserDao;
import it.unical.demacs.pierluigi.fintedapp.data.entities.Review;
import it.unical.demacs.pierluigi.fintedapp.data.services.ReviewService;
import it.unical.demacs.pierluigi.fintedapp.dto.ReviewDto;
import it.unical.demacs.pierluigi.fintedapp.dto.ReviewPublishDto;
import it.unical.demacs.pierluigi.fintedapp.exception.ElementNotFoundException;
import it.unical.demacs.pierluigi.fintedapp.exception.NullFieldException;
import it.unical.demacs.pierluigi.fintedapp.utility.DateManager;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService{
    private final ReviewDao reviewDao;
    private final UserDao userDao;

    private final ModelMapper modelMapper;
    
    @Override
    public ReviewDto save(ReviewPublishDto review) throws ElementNotFoundException, NullFieldException {
        Review newReview = new Review();

        newReview.setAuthor( userDao.findById( review.getAuthor().getId() ).orElseThrow(() -> new ElementNotFoundException("User not found")) );
        newReview.setUser( userDao.findById( review.getUser().getId() ).orElseThrow(() -> new ElementNotFoundException("User not found")) );
        newReview.setContent( review.getContent().toString() );

        newReview.setPublishDate( DateManager.getInstance().currentDate() );

        return modelMapper.map(reviewDao.save(newReview), ReviewPublishDto.class);
    }

    @Override
    public void delete(Long id) throws NullFieldException, ElementNotFoundException {
        if( !reviewDao.existsById( Optional.ofNullable(id).orElseThrow(() -> new NullFieldException("no id as requet param"))))
            throw new ElementNotFoundException("Review not found");
        
        reviewDao.deleteById(id);
    }

    @Override
    public List<ReviewDto> getAll(Long userId) throws ElementNotFoundException {
        return reviewDao.findAllByUser(userDao.findById(userId).orElseThrow(() -> new ElementNotFoundException("User not found"))).stream()
            .map(review -> modelMapper.map(review, ReviewPublishDto.class))
            .collect(Collectors.toList());
    }
    
}
