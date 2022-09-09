package com.hitema.goodotaku.repositories;

import com.hitema.goodotaku.entities.Manga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MangaRepository extends JpaRepository<Manga, Integer> {
    @Query("SELECT m FROM Manga m WHERE m.title LIKE %?1%")
    public List<Manga> search(String keyword);
}
