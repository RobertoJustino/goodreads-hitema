package com.hitema.goodotaku.services;

import com.hitema.goodotaku.entities.Animes;
import com.hitema.goodotaku.entities.Genres;
import com.hitema.goodotaku.repositories.AnimesRepository;
import com.hitema.goodotaku.repositories.GenresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimesServiceImpl implements AnimesService {

    @Autowired
    private AnimesRepository animeRepo;

    @Autowired
    GenresRepository genreRepo;

    public List<Animes> listAll(String keyword) {
        if (keyword != null) {
            return animeRepo.search(keyword);
        }
        return animeRepo.findAll();
    }

    public Animes get(Long id) {
        return animeRepo.findById(id).get();
    }

    public List<Genres> listGenres() {
        return genreRepo.findAll();
    }

    public void save(Animes anime) {
        animeRepo.save(anime);
    }

    public void delete(Long id) {
        animeRepo.deleteById(id);
    }
}
