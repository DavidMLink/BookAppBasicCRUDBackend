package com.yourbookapp.bookapp.repositories;

import com.yourbookapp.bookapp.models.Favorite;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavoriteRepository extends CrudRepository<Favorite, Long>{

    // CRUD METHODS

        // CREATE

        // END OF CREATE

        // READ
        
        List<Favorite> findAll();
        
        // List<Favorite> findByDescriptionContaining(String search);
        
        // Long countByTitleContaining(String search);
        
        // END OF READ

        // UPDATE

        // END OF UPDATE

        // DELETE

        // Long deleteByTitleStartingWith(String search);

        // this method deletes a Favorite by id
        List<Favorite> deleteById(long id);

        // END OF DELETE

    // END OF CRUD METHODS

}