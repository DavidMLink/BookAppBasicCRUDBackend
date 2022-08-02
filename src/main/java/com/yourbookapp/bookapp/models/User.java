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
@Table(name="users") //You may need to rename me if this is the third table in a MANY TO MANY relationship...
public class User {
    //PrimaryKey
    @Id
    //PrimaryKey AutoGeneration
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String username;

    private String password;

    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;

    //RELATIONSHIPS BETWEEN TABLES

    @OneToMany(mappedBy="user", fetch=FetchType.LAZY)
    private List<Favorite> favorites;

    public List<Favorite> getFavorites() {
        return favorites;
    }

    public void setFavorites(List<Favorite> favorites) {
        this.favorites = favorites;
    }


    @OneToMany(mappedBy="user", fetch=FetchType.LAZY)
    private List<Review> reviews;

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }


    //END OF RELATIONSHIPS BETWEEN TABLES


    //GETTERS AND SETTERS

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
}
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
}

    //END OF GETTERS AND SETTERS


    // CONSTRUCTORS 
    public User() { 
    } 
    // creates object 
    public User(String username,  String password ){ 
        this.username = username; 
        this.password = password; 
    } 

    // updates object
    public User(Long id, String username, String password ){ 
        this.id = id; 
        this.username = username; 
        this.password = password; 
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
