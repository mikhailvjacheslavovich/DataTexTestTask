package ru.datatex.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity()
@Table(name = "DISK")
public class Disk implements Serializable{

    private Long id;
    private Long owner;
    private String title;
    private String rating;
    private String description;
    private Set<Users> users = new HashSet<Users>();

    public Disk() {
    }

    public Disk(Long owner, String title, String rating, String description) {
        this.owner = owner;
        this.title = title;
        this.rating = rating;
        this.description = description;
    }

    public Disk(Long owner, String title, String rating, String description, Set<Users> users) {
        this.owner = owner;
        this.title = title;
        this.rating = rating;
        this.description = description;
        this.users = users;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id",unique = true, nullable = false)
    public Long getId() {
        return id;
    }

    @Column(name = "owner", nullable = false)
    public Long getOwner() {
        return owner;
    }

    public void setOwner(Long owner) {
        this.owner = owner;
    }

    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    @Column(name = "rating")
    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "TAKENITEMS", joinColumns = {@JoinColumn(name = "DISK_ID", nullable = false, updatable = false)}
            , inverseJoinColumns = {@JoinColumn(name = "USERS_ID",nullable = false, updatable = false)})
    @JsonManagedReference
    public Set<Users> getUsers() {
        return this.users;
    }

    public void setUsers(Set<Users> users) {
        this.users = users;
    }
}
