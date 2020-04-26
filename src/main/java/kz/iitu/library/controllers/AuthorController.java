package kz.iitu.library.controllers;

import io.swagger.annotations.ApiResponses;
import kz.iitu.library.classes.Author;
import kz.iitu.library.classes.Book;
import kz.iitu.library.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
@ApiResponses(value = {
        @ApiResponses(code = 401, message = "Not authorized"),
        @ApiResponses(code = 404, message="NotFound")
})
public class AuthorController {

    @Autowired
    private AuthorRepository authorRepository;

    @GetMapping("")
    public List<Author> getAllBooks(){
        return authorRepository.findAll();
    }

    @GetMapping("/{id}")
    public Author getBookById(@PathVariable("id") Long id) {
        return authorRepository.findById(id).get();
    }

    @PostMapping("")
    public Author createAuthor(@RequestBody Author author) {
        return authorRepository.saveAndFlush(author);
    }

    @PutMapping("/{id}")
    public Author updateAuthor(@PathVariable Long id,
                             @RequestBody Author author) {
        author.setId(id);
        return authorRepository.saveAndFlush(author);
    }

    @GetMapping("/{books}")
    public List<Author> getAuthorByBooks(@PathVariable("books")List<Book> books){
        return authorRepository.findAuthorByBookList(books);
    }

    @GetMapping("/{name}")
    public List<Author> getAuthorByName(@RequestParam String name){
        return authorRepository.findAuthorByName(name);
    }
}
