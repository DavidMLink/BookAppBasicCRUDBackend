package com.yourbookapp.bookapp.repositories;

import com.yourbookapp.bookapp.models.Genre;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GenreRepository extends CrudRepository<Genre, Long>{

    // CRUD METHODS

        // CREATE

        // END OF CREATE

        // READ
        
        List<Genre> findAll();
        
        // List<Genre> findByDescriptionContaining(String search);
        
        // Long countByTitleContaining(String search);
        
        // END OF READ

        // UPDATE

        // END OF UPDATE

        // DELETE

        // Long deleteByTitleStartingWith(String search);

        // this method deletes a Genre by id
        List<Genre> deleteById(long id);

        // END OF DELETE

    // END OF CRUD METHODS

}