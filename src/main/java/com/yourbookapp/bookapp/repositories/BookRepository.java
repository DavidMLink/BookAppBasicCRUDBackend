package com.yourbookapp.bookapp.repositories;

import com.yourbookapp.bookapp.models.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<Book, Long>{

    // CRUD METHODS

        // CREATE

        // END OF CREATE

        // READ
        
        List<Book> findAll();
        
        // List<Book> findByDescriptionContaining(String search);
        
        // Long countByTitleContaining(String search);
        
        // END OF READ

        // UPDATE

        // END OF UPDATE

        // DELETE

        // Long deleteByTitleStartingWith(String search);

        // this method deletes a Book by id
        List<Book> deleteById(long id);

        // END OF DELETE

    // END OF CRUD METHODS

}