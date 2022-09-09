package com.hitema.goodotaku.controllers.api;

import com.hitema.goodotaku.entities.*;
import com.hitema.goodotaku.repositories.AnimesRepository;
import com.hitema.goodotaku.repositories.ReviewAnimeRepository;
import com.hitema.goodotaku.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "http://localhost:8082")
@RestController
@RequestMapping("/api")
public class ReviewsAnimeApiController {

    private Logger logger = LoggerFactory.getLogger(ReviewsAnimeApiController.class);

    @Autowired
    private ReviewAnimeRepository reviewAnimeRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AnimesRepository animeRepository;

    @GetMapping("/reviews-anime")
    public ResponseEntity<Object> getAllReviewsAnime(){
        try {
            Iterable<ReviewsAnime> reviewsAnime = reviewAnimeRepository.findAll();
            return new ResponseEntity<Object>(reviewsAnime, HttpStatus.OK);
        } catch(Exception ex) {
            logger.error(ex.getMessage(), ex);
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/reviews-anime/{id}")
    public ResponseEntity<Object> getReviewsAnimeById(@PathVariable("id") Long id) {
        try {
            ReviewsAnime reviewsAnime = reviewAnimeRepository.findById(id).get();
            if(reviewsAnime != null) {
                return new ResponseEntity<Object>(reviewsAnime, HttpStatus.OK);
            } else {
                return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
            }
        } catch(Exception ex) {
            logger.error(ex.getMessage(), ex);
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
        }
    }


    @PostMapping("/review-anime/create/{idAnime}/{idUser}")
    public ResponseEntity<Object> saveReviewInAnime(@PathVariable("idAnime") Long idAnime,@PathVariable("idUser") Long idUser, @RequestBody ReviewsAnime reviewsAnime){
        try {
            User u = userRepository.findById(idUser).get();
            Animes m = animeRepository.findById(idAnime).get();
            reviewsAnime.setUser(u);
            reviewsAnime.setAnime(m);

            ReviewsAnime rm = reviewAnimeRepository.save(reviewsAnime);

            List<ReviewsAnime> listReviewsAnime = m.getReview();
            listReviewsAnime.add(reviewsAnime);

            m.setReview(listReviewsAnime);

            Animes anime = animeRepository.save(m);
            if(rm != null) {
                return new ResponseEntity<Object>(rm, HttpStatus.OK);
            } else {
                return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
            }
        } catch(Exception ex) {
            logger.error(ex.getMessage(), ex);
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
        }
    }


}