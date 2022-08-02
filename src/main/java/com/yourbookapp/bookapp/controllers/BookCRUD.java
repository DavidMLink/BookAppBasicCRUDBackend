package com.yourbookapp.bookapp.controllers;

import java.util.List;

import com.yourbookapp.bookapp.models.Book;
import com.yourbookapp.bookapp.services.BookService;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookCRUD {
    private final BookService bookService;
    public BookCRUD(BookService bookService){
        this.bookService = bookService;
    }
    
    // CRUD

        // CREATE
            @RequestMapping(value="/api/books", method=RequestMethod.POST)
            public Book create(@RequestParam(value="name") String name, @RequestParam(value="isbn") String isbn, @RequestParam(value="publisheddate") String publisheddate) { 
                Book book = new Book( name, isbn, publisheddate ); 
                return bookService.createBook(book); 
            } 
        
        // READ 
            // Specific Table 
            @RequestMapping("/api/books/{id}") 
            public Book show(@PathVariable("id") Long id) { 
                Book book = bookService.findBook(id); 
                return book; 
            } 
            // All Tables 
            @RequestMapping("/api/books") 
            public List<Book> index() { 
                return bookService.allBooks(); 
            } 
        
        // UPDATE 
            @RequestMapping(value="/api/books/{id}", method=RequestMethod.PUT) 
            public Book update(@PathVariable("id") Long id, @RequestParam(value="name") String name,  @RequestParam(value="isbn") String isbn,  @RequestParam(value="publisheddate") String publisheddate) { 
                Book book = new Book(id, name, isbn, publisheddate ); 
                Book bookUpdated = bookService.updateBook(book); 
                return bookUpdated; 
            } 
        // DELETE 
            @RequestMapping(value="/api/books/{id}", method=RequestMethod.DELETE) 
            public void destroy(@PathVariable("id") Long id) { 
                bookService.deleteBook(id); 
            } 
    // END OF CRUD 
} 
