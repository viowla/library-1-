package kz.iitu.library.controllers;

import kz.iitu.library.classes.Book;
import kz.iitu.library.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookRepository bookRepository;

    @GetMapping("")
    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    @GetMapping("/{id}")
    public Book getUserById(@PathVariable("id") Long id) {
        return bookRepository.findById(id).get();
    }

    @PostMapping("")
    public Book createUser(@RequestBody Book book) {
        return bookRepository.saveAndFlush(book);
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id,
                           @RequestBody Book book) {
        book.setId(id);
        return bookRepository.saveAndFlush(book);
    }
}
