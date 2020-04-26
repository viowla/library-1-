package kz.iitu.library.controllers;

import kz.iitu.library.classes.Author;
import kz.iitu.library.classes.Genre;
import kz.iitu.library.repositories.AuthorRepository;
import kz.iitu.library.repositories.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/genres")
public class GenreController {
    @Autowired
    private GenreRepository genreRepository;

    @GetMapping("")
    public List<Genre> getAllGenres(){
        return genreRepository.findAll();
    }

    @GetMapping("/{id}")
    public Genre getGenreById(@PathVariable("id") Long id) {
        return genreRepository.findById(id).get();
    }

    @DeleteMapping("")
    public void deleteAllGenres(){
        genreRepository.deleteAll();
    }

    @DeleteMapping("/{id}")
    public void deleteGenreById(@PathVariable("id") Long id){
        genreRepository.deleteById(id);
    }
}
