package com.hitema.goodotaku.services;


import com.hitema.goodotaku.entities.ReviewsManga;

import java.util.List;

public interface ReviewsMangaService {


    List<ReviewsManga> readAll();
    ReviewsManga create(ReviewsManga reviewsManga);
    ReviewsManga read(Integer id);
    ReviewsManga update(ReviewsManga reviewsManga);
    Boolean delete(Integer id);

}
