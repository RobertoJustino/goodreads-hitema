package com.hitema.goodotaku.repositories;

import com.hitema.goodotaku.entities.Animes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AnimesRepository extends JpaRepository<Animes, Long> {
    @Query("SELECT a FROM Animes a WHERE CONCAT(a.title, ' ', a.author, ' ', a.year) LIKE %?1%")
    public List<Animes> search(String keyword);
}
