package com.videos.domain.restcontroller;

import com.videos.domain.Entity.Movie;
import com.videos.domain.dao.MovieDAO;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movies")
@AllArgsConstructor
public class MovieRestController {
    MovieDAO movieDAO;

    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies(){
        List<Movie> movies = movieDAO.findAll();
        return ResponseEntity.ok(movies);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Movie>> getMovieById(@PathVariable int id){
        Optional<Movie> movie = movieDAO.findById(id);
        return ResponseEntity.ok(movie);
    }

    @PostMapping
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie){
        Movie savedMovie = movieDAO.save(movie);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedMovie);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMovie(@PathVariable int id){
        movieDAO.deleteById(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Movie Deleted");
    }
    @PutMapping
    public ResponseEntity<Movie> editMovie(@RequestBody Movie movie){
        Movie updatedMovie = movieDAO.save(movie);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(updatedMovie);
    }
}
