package com.yourbookapp.bookapp.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import javax.persistence.JoinColumn;


@Entity
@Table(name="authors") //You may need to rename me if this is the third table in a MANY TO MANY relationship...
public class Author {
    //PrimaryKey
    @Id
    //PrimaryKey AutoGeneration
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;

    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;

    //RELATIONSHIPS BETWEEN TABLES

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "books_authors",
        joinColumns = @JoinColumn(name = "author_id"),
        inverseJoinColumns = @JoinColumn(name = "book_id")
    )

    private List<Book> books;

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }


    //END OF RELATIONSHIPS BETWEEN TABLES


    //GETTERS AND SETTERS

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
}

    //END OF GETTERS AND SETTERS


    // CONSTRUCTORS 
    public Author() { 
    } 
    // creates object 
    public Author(String name ){ 
        this.name = name; 
    } 

    // updates object
    public Author(Long id, String name ){ 
        this.id = id; 
        this.name = name; 
    } 

    //END OF CONSTRUCTORS 

    @PrePersist 
    protected void onCreate(){ 
        this.createdAt = new Date(); 
    } 
    @PreUpdate 
    protected void onUpdate(){ 
        this.updatedAt = new Date(); 
    } 
} 
