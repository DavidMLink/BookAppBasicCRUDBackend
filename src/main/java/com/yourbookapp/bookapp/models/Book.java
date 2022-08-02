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
@Table(name="books") //You may need to rename me if this is the third table in a MANY TO MANY relationship...
public class Book {
    //PrimaryKey
    @Id
    //PrimaryKey AutoGeneration
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;

    private String isbn;

    private String publisheddate;

    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;

    //RELATIONSHIPS BETWEEN TABLES

    @OneToMany(mappedBy="book", fetch=FetchType.LAZY)
    private List<Favorite> favorites;

    public List<Favorite> getFavorites() {
        return favorites;
    }

    public void setFavorites(List<Favorite> favorites) {
        this.favorites = favorites;
    }


    @OneToMany(mappedBy="book", fetch=FetchType.LAZY)
    private List<Review> reviews;

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "books_genres",
        joinColumns = @JoinColumn(name = "book_id"),
        inverseJoinColumns = @JoinColumn(name = "genre_id")
    )

    private List<Genre> genres;

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "books_authors",
        joinColumns = @JoinColumn(name = "book_id"),
        inverseJoinColumns = @JoinColumn(name = "author_id")
    )

    private List<Author> authors;

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
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
    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
}
    public String getPublisheddate() {
        return publisheddate;
    }
    public void setPublisheddate(String publisheddate) {
        this.publisheddate = publisheddate;
}

    //END OF GETTERS AND SETTERS


    // CONSTRUCTORS 
    public Book() { 
    } 
    // creates object 
    public Book(String name,  String isbn,  String publisheddate ){ 
        this.name = name; 
        this.isbn = isbn; 
        this.publisheddate = publisheddate; 
    } 

    // updates object
    public Book(Long id, String name, String isbn, String publisheddate ){ 
        this.id = id; 
        this.name = name; 
        this.isbn = isbn; 
        this.publisheddate = publisheddate; 
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
