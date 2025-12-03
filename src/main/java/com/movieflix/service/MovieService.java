package com.movieflix.service;

import com.movieflix.entity.Movie;
import com.movieflix.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;

    public Movie save(Movie movie) {
        return movieRepository.save(movie);
    }

    public @Nullable List<Movie> getAll() {
        return movieRepository.findAll();
    }
}
