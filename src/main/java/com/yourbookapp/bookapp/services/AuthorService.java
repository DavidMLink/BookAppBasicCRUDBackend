package com.yourbookapp.bookapp.services;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import com.yourbookapp.bookapp.models.Author;
import com.yourbookapp.bookapp.repositories.AuthorRepository;

@Service
public class AuthorService {
    // adding the Author repository as a dependency
    private final AuthorRepository authorRepository;
    
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    // CRUD METHODS
    
        // CREATE
        public Author createAuthor(Author b) {
            return authorRepository.save(b);
        }
        // END OF CREATE

        // READ
        public List<Author> allAuthors() {
            return authorRepository.findAll();
        }

        public Author findAuthor(Long id) {
            Optional<Author> optionalAuthor = authorRepository.findById(id);
            if(optionalAuthor.isPresent()) {
                return optionalAuthor.get();
            } else {
                return null;
            }
        }
        // END OF READ

        // UPDATE
        public Author updateAuthor(Author b){
            return authorRepository.save(b);
        }
        // END OF UPDATE

        // DELETE
        public void deleteAuthor(Long id){
            authorRepository.deleteById(id);
        }
        // END OF DELETE
        
    // END OF CRUD METHODS
}