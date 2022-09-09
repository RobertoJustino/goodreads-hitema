package com.hitema.goodotaku.repositories;

import com.hitema.goodotaku.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE u.email = ?1")
    public User findByEmail(String email);

    @Query("SELECT u FROM User u WHERE CONCAT(u.email, ' ', u.username) LIKE %?1%")
    public List<User> search(String keyword);



}