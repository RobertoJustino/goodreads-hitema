package com.hitema.goodotaku.services;

import com.hitema.goodotaku.entities.Animes;
import com.hitema.goodotaku.entities.Genres;

import java.util.List;

public interface AnimesService {

    List<Animes> listAll(String keyword);

    List<Genres> listGenres();

    Animes get(Long id);

    void save(Animes anime);

    void delete(Long id);
}
