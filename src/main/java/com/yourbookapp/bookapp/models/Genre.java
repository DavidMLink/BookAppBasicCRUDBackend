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
@Table(name="genres") //You may need to rename me if this is the third table in a MANY TO MANY relationship...
public class Genre {
    //PrimaryKey
    @Id
    //PrimaryKey AutoGeneration
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String genrecol;

    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;

    //RELATIONSHIPS BETWEEN TABLES

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "books_genres",
        joinColumns = @JoinColumn(name = "genre_id"),
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
    public String getGenrecol() {
        return genrecol;
    }
    public void setGenrecol(String genrecol) {
        this.genrecol = genrecol;
}

    //END OF GETTERS AND SETTERS


    // CONSTRUCTORS 
    public Genre() { 
    } 
    // creates object 
    public Genre(String genrecol ){ 
        this.genrecol = genrecol; 
    } 

    // updates object
    public Genre(Long id, String genrecol ){ 
        this.id = id; 
        this.genrecol = genrecol; 
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
