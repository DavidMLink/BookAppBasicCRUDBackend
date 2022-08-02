package com.yourbookapp.bookapp.services;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import com.yourbookapp.bookapp.models.Genre;
import com.yourbookapp.bookapp.repositories.GenreRepository;

@Service
public class GenreService {
    // adding the Genre repository as a dependency
    private final GenreRepository genreRepository;
    
    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    // CRUD METHODS
    
        // CREATE
        public Genre createGenre(Genre b) {
            return genreRepository.save(b);
        }
        // END OF CREATE

        // READ
        public List<Genre> allGenres() {
            return genreRepository.findAll();
        }

        public Genre findGenre(Long id) {
            Optional<Genre> optionalGenre = genreRepository.findById(id);
            if(optionalGenre.isPresent()) {
                return optionalGenre.get();
            } else {
                return null;
            }
        }
        // END OF READ

        // UPDATE
        public Genre updateGenre(Genre b){
            return genreRepository.save(b);
        }
        // END OF UPDATE

        // DELETE
        public void deleteGenre(Long id){
            genreRepository.deleteById(id);
        }
        // END OF DELETE
        
    // END OF CRUD METHODS
}