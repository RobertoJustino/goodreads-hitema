package com.hitema.goodotaku.repositories;

import com.hitema.goodotaku.entities.Genres;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenresRepository extends JpaRepository<Genres, Long> {
}
