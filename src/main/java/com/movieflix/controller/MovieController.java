package com.movieflix.controller;

import com.movieflix.controller.request.MovieRequest;
import com.movieflix.controller.response.MovieResponse;
import com.movieflix.entity.Movie;
import com.movieflix.mapper.MovieMapper;
import com.movieflix.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movieflix/movie")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @PostMapping
    public ResponseEntity<MovieResponse> save(@RequestBody MovieRequest movie) {
        Movie saved = movieService.save(MovieMapper.toMovie(movie));
        return ResponseEntity.status(HttpStatus.CREATED).body(MovieMapper.toMovieResponse(saved));
    }

    @GetMapping
    public ResponseEntity<List<MovieResponse>> findAll() {
        List<Movie> movies = movieService.getAll();
        return ResponseEntity.ok(movies.stream()
                .map(MovieMapper::toMovieResponse)
                .toList());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        movieService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }

    @PutMapping("/{id}")
    public ResponseEntity<MovieResponse> update( @PathVariable Long id, @RequestBody MovieRequest movie) {
        Movie movie1 = MovieMapper.toMovie(movie);
       Movie saved = movieService.update(movie1, id);
        return ResponseEntity.ok(MovieMapper.toMovieResponse(saved));
    }


}
