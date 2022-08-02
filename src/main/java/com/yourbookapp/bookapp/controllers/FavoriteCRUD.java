package com.yourbookapp.bookapp.controllers;

import java.util.List;

import com.yourbookapp.bookapp.models.Favorite;
import com.yourbookapp.bookapp.services.FavoriteService;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FavoriteCRUD {
    private final FavoriteService favoriteService;
    public FavoriteCRUD(FavoriteService favoriteService){
        this.favoriteService = favoriteService;
    }
    
    // CRUD

        // CREATE
            @RequestMapping(value="/api/favorites", method=RequestMethod.POST)
            public Favorite create(@RequestParam(value="status") String status) { 
                Favorite favorite = new Favorite( status ); 
                return favoriteService.createFavorite(favorite); 
            } 
        
        // READ 
            // Specific Table 
            @RequestMapping("/api/favorites/{id}") 
            public Favorite show(@PathVariable("id") Long id) { 
                Favorite favorite = favoriteService.findFavorite(id); 
                return favorite; 
            } 
            // All Tables 
            @RequestMapping("/api/favorites") 
            public List<Favorite> index() { 
                return favoriteService.allFavorites(); 
            } 
        
        // UPDATE 
            @RequestMapping(value="/api/favorites/{id}", method=RequestMethod.PUT) 
            public Favorite update(@PathVariable("id") Long id, @RequestParam(value="status") String status) { 
                Favorite favorite = new Favorite(id, status ); 
                Favorite favoriteUpdated = favoriteService.updateFavorite(favorite); 
                return favoriteUpdated; 
            } 
        // DELETE 
            @RequestMapping(value="/api/favorites/{id}", method=RequestMethod.DELETE) 
            public void destroy(@PathVariable("id") Long id) { 
                favoriteService.deleteFavorite(id); 
            } 
    // END OF CRUD 
} 
