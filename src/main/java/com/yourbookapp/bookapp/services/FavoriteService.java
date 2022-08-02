package com.yourbookapp.bookapp.services;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import com.yourbookapp.bookapp.models.Favorite;
import com.yourbookapp.bookapp.repositories.FavoriteRepository;

@Service
public class FavoriteService {
    // adding the Favorite repository as a dependency
    private final FavoriteRepository favoriteRepository;
    
    public FavoriteService(FavoriteRepository favoriteRepository) {
        this.favoriteRepository = favoriteRepository;
    }

    // CRUD METHODS
    
        // CREATE
        public Favorite createFavorite(Favorite b) {
            return favoriteRepository.save(b);
        }
        // END OF CREATE

        // READ
        public List<Favorite> allFavorites() {
            return favoriteRepository.findAll();
        }

        public Favorite findFavorite(Long id) {
            Optional<Favorite> optionalFavorite = favoriteRepository.findById(id);
            if(optionalFavorite.isPresent()) {
                return optionalFavorite.get();
            } else {
                return null;
            }
        }
        // END OF READ

        // UPDATE
        public Favorite updateFavorite(Favorite b){
            return favoriteRepository.save(b);
        }
        // END OF UPDATE

        // DELETE
        public void deleteFavorite(Long id){
            favoriteRepository.deleteById(id);
        }
        // END OF DELETE
        
    // END OF CRUD METHODS
}