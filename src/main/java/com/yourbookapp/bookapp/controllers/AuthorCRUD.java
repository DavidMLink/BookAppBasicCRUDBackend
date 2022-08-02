package com.yourbookapp.bookapp.controllers;

import java.util.List;

import com.yourbookapp.bookapp.models.Author;
import com.yourbookapp.bookapp.services.AuthorService;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorCRUD {
    private final AuthorService authorService;
    public AuthorCRUD(AuthorService authorService){
        this.authorService = authorService;
    }
    
    // CRUD

        // CREATE
            @RequestMapping(value="/api/authors", method=RequestMethod.POST)
            public Author create(@RequestParam(value="name") String name) { 
                Author author = new Author( name ); 
                return authorService.createAuthor(author); 
            } 
        
        // READ 
            // Specific Table 
            @RequestMapping("/api/authors/{id}") 
            public Author show(@PathVariable("id") Long id) { 
                Author author = authorService.findAuthor(id); 
                return author; 
            } 
            // All Tables 
            @RequestMapping("/api/authors") 
            public List<Author> index() { 
                return authorService.allAuthors(); 
            } 
        
        // UPDATE 
            @RequestMapping(value="/api/authors/{id}", method=RequestMethod.PUT) 
            public Author update(@PathVariable("id") Long id, @RequestParam(value="name") String name) { 
                Author author = new Author(id, name ); 
                Author authorUpdated = authorService.updateAuthor(author); 
                return authorUpdated; 
            } 
        // DELETE 
            @RequestMapping(value="/api/authors/{id}", method=RequestMethod.DELETE) 
            public void destroy(@PathVariable("id") Long id) { 
                authorService.deleteAuthor(id); 
            } 
    // END OF CRUD 
} 
