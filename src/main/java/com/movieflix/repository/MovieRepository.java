package com.movieflix.repository;

import com.movieflix.entity.Category;
import com.movieflix.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    List<Movie> findByCategories_Id(Long categoryId);
    List<Movie> findTop5ByOrderByRatingDesc();
}
