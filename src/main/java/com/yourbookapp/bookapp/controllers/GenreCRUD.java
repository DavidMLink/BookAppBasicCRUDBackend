package com.yourbookapp.bookapp.controllers;

import java.util.List;

import com.yourbookapp.bookapp.models.Genre;
import com.yourbookapp.bookapp.services.GenreService;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GenreCRUD {
    private final GenreService genreService;
    public GenreCRUD(GenreService genreService){
        this.genreService = genreService;
    }
    
    // CRUD

        // CREATE
            @RequestMapping(value="/api/genres", method=RequestMethod.POST)
            public Genre create(@RequestParam(value="genrecol") String genrecol) { 
                Genre genre = new Genre( genrecol ); 
                return genreService.createGenre(genre); 
            } 
        
        // READ 
            // Specific Table 
            @RequestMapping("/api/genres/{id}") 
            public Genre show(@PathVariable("id") Long id) { 
                Genre genre = genreService.findGenre(id); 
                return genre; 
            } 
            // All Tables 
            @RequestMapping("/api/genres") 
            public List<Genre> index() { 
                return genreService.allGenres(); 
            } 
        
        // UPDATE 
            @RequestMapping(value="/api/genres/{id}", method=RequestMethod.PUT) 
            public Genre update(@PathVariable("id") Long id, @RequestParam(value="genrecol") String genrecol) { 
                Genre genre = new Genre(id, genrecol ); 
                Genre genreUpdated = genreService.updateGenre(genre); 
                return genreUpdated; 
            } 
        // DELETE 
            @RequestMapping(value="/api/genres/{id}", method=RequestMethod.DELETE) 
            public void destroy(@PathVariable("id") Long id) { 
                genreService.deleteGenre(id); 
            } 
    // END OF CRUD 
} 
