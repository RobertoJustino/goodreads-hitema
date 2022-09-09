package com.hitema.goodotaku.services;

import com.hitema.goodotaku.entities.Genres;
import com.hitema.goodotaku.entities.Manga;
import com.hitema.goodotaku.repositories.GenresRepository;
import com.hitema.goodotaku.repositories.MangaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MangaServiceImpl implements MangaService{

    @Autowired
    private MangaRepository repository;

    @Autowired
    private GenresRepository genresRepository;


    @Override
    public List<Manga> readAll(String keyword) {
        if (keyword != null) {
            return repository.search(keyword);
        }
        return repository.findAll();
    }

    @Override
    public Manga create(Manga manga) {
        return repository.save(manga);
    }

    @Override
    public Manga read(Integer id) {
        return repository.findById(id).orElseGet(null);
    }

    public List<Genres> listGenres() {
        return genresRepository.findAll();
    }

    @Override
    public Manga update(Manga manga) {
        return repository.save(manga);
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

}
