package kz.iitu.library.controllers;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import kz.iitu.library.classes.Book;
import kz.iitu.library.classes.BookStatus;
import kz.iitu.library.classes.Genre;
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
    @ApiOperation(response = {
            @ApiResponse(code = 200, message = "book deteled"),
            @ApiResponse(code = 400, message = "Invalid book supplied"),
            @ApiResponse(code = 404, message = "book not found")})
    public Book getBookById(@PathVariable("id") Long id) {
        return bookRepository.findById(id).get();
    }

    @PostMapping("")
    @ApiOperation(response = {
            @ApiResponse(code = 200, message = "book deteled"),
            @ApiResponse(code = 400, message = "Invalid book supplied"),
            @ApiResponse(code = 404, message = "book not found")})
    public Book createUser(@RequestBody Book book) {
        return bookRepository.saveAndFlush(book);
    }

    @PutMapping("/{id}")
    @ApiOperation(response = {
            @ApiResponse(code = 200, message = "book deteled"),
            @ApiResponse(code = 400, message = "Invalid book supplied"),
            @ApiResponse(code = 404, message = "book not found")})
    public Book updateBook(@PathVariable Long id,
                           @RequestBody Book book) {
        book.setId(id);
        return bookRepository.saveAndFlush(book);
    }


    @DeleteMapping("/{id}")
    @ApiOperation(response = {
                    @ApiResponse(code = 200, message = "book deteled"),
                    @ApiResponse(code = 400, message = "Invalid book supplied"),
                    @ApiResponse(code = 404, message = "book not found")})
    public void deleteBookById(@PathVariable("id") Long id){
        bookRepository.deleteById(id);
    }

    @GetMapping("/genre")
    @ApiOperation(response = {
            @ApiResponse(code = 200, message = "book deteled"),
            @ApiResponse(code = 400, message = "Invalid book supplied"),
            @ApiResponse(code = 404, message = "book not found")})
    public List<Book> findBookByGenre(@PathVariable List<Genre> genre){
        return bookRepository.findAllByGenre(genre);
    }

    @GetMapping("/status")
    @ApiOperation(response = {
            @ApiResponse(code = 200, message = "book deteled"),
            @ApiResponse(code = 400, message = "Invalid book supplied"),
            @ApiResponse(code = 404, message = "book not found")})
    public List<Book> findBookByStatus(@PathVariable BookStatus bookStatus){
        return bookRepository.findBookByBookStatus(bookStatus);
    }
}
