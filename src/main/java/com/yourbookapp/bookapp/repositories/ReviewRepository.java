package com.yourbookapp.bookapp.repositories;

import com.yourbookapp.bookapp.models.Review;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends CrudRepository<Review, Long>{

    // CRUD METHODS

        // CREATE

        // END OF CREATE

        // READ
        
        List<Review> findAll();
        
        // List<Review> findByDescriptionContaining(String search);
        
        // Long countByTitleContaining(String search);
        
        // END OF READ

        // UPDATE

        // END OF UPDATE

        // DELETE

        // Long deleteByTitleStartingWith(String search);

        // this method deletes a Review by id
        List<Review> deleteById(long id);

        // END OF DELETE

    // END OF CRUD METHODS

}