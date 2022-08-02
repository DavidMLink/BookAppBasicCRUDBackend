package com.yourbookapp.bookapp.services;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import com.yourbookapp.bookapp.models.Book;
import com.yourbookapp.bookapp.repositories.BookRepository;

@Service
public class BookService {
    // adding the Book repository as a dependency
    private final BookRepository bookRepository;
    
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // CRUD METHODS
    
        // CREATE
        public Book createBook(Book b) {
            return bookRepository.save(b);
        }
        // END OF CREATE

        // READ
        public List<Book> allBooks() {
            return bookRepository.findAll();
        }

        public Book findBook(Long id) {
            Optional<Book> optionalBook = bookRepository.findById(id);
            if(optionalBook.isPresent()) {
                return optionalBook.get();
            } else {
                return null;
            }
        }
        // END OF READ

        // UPDATE
        public Book updateBook(Book b){
            return bookRepository.save(b);
        }
        // END OF UPDATE

        // DELETE
        public void deleteBook(Long id){
            bookRepository.deleteById(id);
        }
        // END OF DELETE
        
    // END OF CRUD METHODS
}