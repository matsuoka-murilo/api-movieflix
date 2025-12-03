package com.movieflix.service;

import com.movieflix.entity.Category;
import com.movieflix.entity.Movie;
import com.movieflix.entity.Streaming;
import com.movieflix.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;
    private final CategoryService categoryService;
    private final StreamingService streamingService;

    public Movie save(Movie movie) {
        List<Category> categories = movie.getCategories()
                .stream()
                .map(category -> categoryService.findById(category.getId())).toList();
        movie.setCategories(categories);

        List<Streaming> streamings = movie.getStreamings()
                .stream()
                .map(streaming -> streamingService.getById(streaming.getId())).toList();
        movie.setStreamings(streamings);

        return movieRepository.save(movie);
    }

    public List<Movie> getAll() {
        return movieRepository.findAll();
    }

}
