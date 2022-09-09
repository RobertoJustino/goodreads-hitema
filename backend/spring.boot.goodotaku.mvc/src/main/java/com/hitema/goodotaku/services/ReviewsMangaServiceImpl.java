package com.hitema.goodotaku.services;

import com.hitema.goodotaku.entities.ReviewsManga;
import com.hitema.goodotaku.repositories.ReviewsMangaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewsMangaServiceImpl implements ReviewsMangaService {

    @Autowired
    private ReviewsMangaRepository repository;



    @Override
    public List<ReviewsManga> readAll() {
        return repository.findAll();
    }

    @Override
    public ReviewsManga create(ReviewsManga reviewsManga) {
        return repository.save(reviewsManga);
    }

    @Override
    public ReviewsManga read(Integer id) {
        return repository.findById(id).orElseGet(null);
    }

    @Override
    public ReviewsManga update(ReviewsManga reviewsManga) {
        return repository.save(reviewsManga);
    }

    @Override
    public Boolean delete(Integer id) {
        repository.deleteById(id);
        return (read(id) == null);
    }
}
