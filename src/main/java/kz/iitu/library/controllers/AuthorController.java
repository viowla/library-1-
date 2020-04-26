package kz.iitu.library.controllers;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import kz.iitu.library.classes.Author;
import kz.iitu.library.classes.Book;
import kz.iitu.library.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    private AuthorRepository authorRepository;

    @GetMapping("")
    public List<Author> getAllBooks(){
        return authorRepository.findAll();
    }

    @GetMapping("/{id}")
    @ApiOperation(response = {
            @ApiResponse(code = 200, message = "book deteled"),
            @ApiResponse(code = 400, message = "Invalid book supplied"),
            @ApiResponse(code = 404, message = "book not found")})
    public Author getBookById(@PathVariable("id") Long id) {
        return authorRepository.findById(id).get();
    }

    @PostMapping("")
    @ApiOperation(response = {
            @ApiResponse(code = 200, message = "author deteled"),
            @ApiResponse(code = 400, message = "Invalid author supplied"),
            @ApiResponse(code = 404, message = "author not found")})
    public Author createAuthor(@RequestBody Author author) {
        return authorRepository.saveAndFlush(author);
    }

    @PutMapping("/{id}")
    @ApiOperation(response = {
            @ApiResponse(code = 200, message = "author deteled"),
            @ApiResponse(code = 400, message = "Invalid author supplied"),
            @ApiResponse(code = 404, message = "author not found")})
    public Author updateAuthor(@PathVariable Long id,
                             @RequestBody Author author) {
        author.setId(id);
        return authorRepository.saveAndFlush(author);
    }

    @GetMapping("/{books}")
    @ApiOperation(response = {
            @ApiResponse(code = 200, message = "author deteled"),
            @ApiResponse(code = 400, message = "Invalid author supplied"),
            @ApiResponse(code = 404, message = "author not found")})
    public List<Author> getAuthorByBooks(@PathVariable("books")List<Book> books){
        return authorRepository.findAuthorByBookList(books);
    }

    @GetMapping("/{name}")
    @ApiOperation(response = {
            @ApiResponse(code = 200, message = "author deteled"),
            @ApiResponse(code = 400, message = "Invalid author supplied"),
            @ApiResponse(code = 404, message = "author not found")})
    public List<Author> getAuthorByName(@RequestParam String name){
        return authorRepository.findAuthorByName(name);
    }
}
