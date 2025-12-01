package com.movieflix.repository;

import com.movieflix.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
