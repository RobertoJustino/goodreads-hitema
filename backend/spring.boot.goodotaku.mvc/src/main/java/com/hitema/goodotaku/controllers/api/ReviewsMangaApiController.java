package com.hitema.goodotaku.controllers.api;

import com.hitema.goodotaku.entities.Manga;
import com.hitema.goodotaku.entities.ReviewsManga;
import com.hitema.goodotaku.entities.User;
import com.hitema.goodotaku.repositories.MangaRepository;
import com.hitema.goodotaku.repositories.ReviewsMangaRepository;
import com.hitema.goodotaku.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ReviewsMangaApiController {
    
    private Logger logger = LoggerFactory.getLogger(ReviewsMangaApiController.class);
    @Autowired
    private ReviewsMangaRepository repository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private MangaRepository mangaRepository;


    public ReviewsMangaApiController(ReviewsMangaRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/reviewsManga")
    public ResponseEntity<Object> getAllReviews(){
        try {
            Iterable<ReviewsManga> reviewsMangas = repository.findAll();
            return new ResponseEntity<Object>(reviewsMangas, HttpStatus.OK);
        } catch(Exception ex) {
            logger.error(ex.getMessage(), ex);
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/reviewsManga/{id}")
    public ResponseEntity<Object> getReviewById(@PathVariable("id") Integer id) {
        try {
            ReviewsManga reviewsManga = repository.findById(id).get();
            if(reviewsManga != null) {
                return new ResponseEntity<Object>(reviewsManga, HttpStatus.OK);
            } else {
                return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
            }
        } catch(Exception ex) {
            logger.error(ex.getMessage(), ex);
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/reviewManga/create/{idManga}/{idUser}")
    public ResponseEntity<Object> saveReviewInManga(@PathVariable("idManga") Integer idManga,@PathVariable("idUser") Long idUser, @RequestBody ReviewsManga reviewsManga){
        try {
            User u = userRepository.findById(idUser).get();
            Manga m = mangaRepository.findById(idManga).get();
            reviewsManga.setUser(u);
            reviewsManga.setManga(m);

            ReviewsManga rm = repository.save(reviewsManga);

            List<ReviewsManga> listReviewsManga = m.getReview();
            listReviewsManga.add(reviewsManga);

            m.setReview(listReviewsManga);

            Manga manga = mangaRepository.save(m);
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