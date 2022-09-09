package com.hitema.goodotaku.services;

import com.hitema.goodotaku.entities.ReviewsAnime;
import com.hitema.goodotaku.entities.User;
import com.hitema.goodotaku.repositories.ReviewAnimeRepository;
import com.hitema.goodotaku.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewAnimeServiceImpl implements ReviewAnimeService{

    @Autowired
    private ReviewAnimeRepository revAnimRepo;

    @Autowired
    UserRepository userRepo;

    public List<ReviewsAnime> listAll() {
        return revAnimRepo.findAll();
    }

    public ReviewsAnime get(Long id) {
        return revAnimRepo.findById(id).get();
    }

    public List<User> listUser() {
        return userRepo.findAll();
    }

    public void save(ReviewsAnime reviewsAnime) {
        revAnimRepo.save(reviewsAnime);
    }

    public void delete(Long id) {
        revAnimRepo.deleteById(id);
    }

}
