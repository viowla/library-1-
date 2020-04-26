package kz.iitu.library.controllers;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
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
    @ApiOperation(response = {
            @ApiResponse(code = 200, message = "genre deteled"),
            @ApiResponse(code = 400, message = "Invalid genre supplied"),
            @ApiResponse(code = 404, message = "genre not found")})
    public void deleteAllGenres(){
        genreRepository.deleteAll();
    }

    @DeleteMapping("/{id}")
    @ApiOperation(response = {
            @ApiResponse(code = 200, message = "genre deteled"),
            @ApiResponse(code = 400, message = "Invalid genre supplied"),
            @ApiResponse(code = 404, message = "genre not found")})
    public void deleteGenreById(@PathVariable("id") Long id){
        genreRepository.deleteById(id);
    }
}
