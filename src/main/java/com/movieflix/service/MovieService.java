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
        movie.setCategories( findCategories(movie.getCategories()));
        movie.setStreamings(findStreaming(movie.getStreamings()));

        return movieRepository.save(movie);
    }

    public List<Movie> getAll() {
        return movieRepository.findAll();
    }

    public void delete(Long id) {
        movieRepository.deleteById(id);
    }

    public Movie update(Movie movie, Long id) {
        Movie entity = movieRepository.findById(id)
                .orElseThrow(RuntimeException::new);
        entity.setTitle(movie.getTitle());
        entity.setDescription(movie.getDescription());
        entity.setRating(movie.getRating());
        entity.setCategories(findCategories(movie.getCategories()));
        entity.setStreamings(findStreaming(movie.getStreamings()));
        return movieRepository.save(entity);
    }

    private List<Category> findCategories(List<Category> category) {
        List<Category> categories = new ArrayList<>();
        category.forEach(c-> categories.add(categoryService.findById(c.getId())));
        return categories;

    }

    private List<Streaming> findStreaming(List<Streaming> streamings) {
        List<Streaming> streaming = new ArrayList<>();
        streamings.forEach(s -> streaming.add(streamingService.getById(s.getId())));
        return streaming;
    }
}
