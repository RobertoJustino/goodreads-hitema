package com.hitema.goodotaku.services;

import com.hitema.goodotaku.entities.ReviewsAnime;
import com.hitema.goodotaku.entities.User;

import java.util.List;

public interface ReviewAnimeService {

    List<ReviewsAnime> listAll();

    List<User> listUser();

    ReviewsAnime get(Long id);

    void save(ReviewsAnime reviewsAnime);


    void delete(Long id);
}
