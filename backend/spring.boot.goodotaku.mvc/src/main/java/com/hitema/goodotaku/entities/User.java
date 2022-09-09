package com.hitema.goodotaku.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "users", schema = "goodreads", catalog = "")
public class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @Basic
    @Column(name = "username", nullable = true, length = 255)
    private String username;
    @Basic
    @Column(name = "password", nullable = true, length = 255)
    private String password;
    @Basic
    @Column(name = "email", nullable = true, length = 255)
    private String email;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();

    @OneToMany
    @JoinColumn(name = "user_id")
    private List<ReviewsManga> reviewsMangas;

    @OneToMany
    @JoinColumn(name = "user_id")
    private List<ReviewsAnime> reviewsAnimes;

    @OneToMany
    @JoinColumn(name = "user_id")
    @JsonManagedReference
    private List<ReviewsAnime> reviewsManga;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public void addRole(Role role) {
        this.roles.add(role);
    }

    public List<ReviewsManga> getReviewsMangas() {
        return reviewsMangas;
    }

    public void setReviewsMangas(List<ReviewsManga> reviewsMangas) {
        this.reviewsMangas = reviewsMangas;
    }

    public List<ReviewsAnime> getReviewsAnimes() {
        return reviewsAnimes;
    }

    public void setReviewsAnimes(List<ReviewsAnime> reviewsAnimes) {
        this.reviewsAnimes = reviewsAnimes;
    }

    public List<ReviewsAnime> getReviewsManga() {
        return reviewsManga;
    }

    public void setReviewsManga(List<ReviewsAnime> reviewsManga) {
        this.reviewsManga = reviewsManga;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User that = (User) o;
        return id == that.id && Objects.equals(username, that.username) && Objects.equals(password, that.password) && Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, email);
    }
}
