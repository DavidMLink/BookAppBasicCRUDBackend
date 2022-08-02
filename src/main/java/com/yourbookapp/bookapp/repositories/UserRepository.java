package com.yourbookapp.bookapp.repositories;

import com.yourbookapp.bookapp.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{

    // CRUD METHODS

        // CREATE

        // END OF CREATE

        // READ
        
        List<User> findAll();
        
        // List<User> findByDescriptionContaining(String search);
        
        // Long countByTitleContaining(String search);
        
        // END OF READ

        // UPDATE

        // END OF UPDATE

        // DELETE

        // Long deleteByTitleStartingWith(String search);

        // this method deletes a User by id
        List<User> deleteById(long id);

        // END OF DELETE

    // END OF CRUD METHODS

}