package com.hitema.goodotaku.services;


import com.hitema.goodotaku.entities.Genres;
import com.hitema.goodotaku.entities.Manga;

import java.util.List;

public interface MangaService {

    List<Manga> readAll(String keyword);

    List<Genres> listGenres();
    Manga create(Manga manga);
    Manga read(Integer id);
    Manga update(Manga manga);
    void delete(Integer id);
}

