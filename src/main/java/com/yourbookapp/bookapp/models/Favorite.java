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
@Table(name="favorites") //You may need to rename me if this is the third table in a MANY TO MANY relationship...
public class Favorite {
    //PrimaryKey
    @Id
    //PrimaryKey AutoGeneration
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String status;

    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;

    //RELATIONSHIPS BETWEEN TABLES

    @ManyToOne(fetch = FetchType.LAZY) 
    @JoinColumn(name="user_id")
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne(fetch = FetchType.LAZY) 
    @JoinColumn(name="book_id")
    private Book book;

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    //END OF RELATIONSHIPS BETWEEN TABLES


    //GETTERS AND SETTERS

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
}

    //END OF GETTERS AND SETTERS


    // CONSTRUCTORS 
    public Favorite() { 
    } 
    // creates object 
    public Favorite(String status ){ 
        this.status = status; 
    } 

    // updates object
    public Favorite(Long id, String status ){ 
        this.id = id; 
        this.status = status; 
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
