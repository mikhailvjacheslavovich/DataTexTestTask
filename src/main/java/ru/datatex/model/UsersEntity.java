package ru.datatex.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "USERS")
public class UsersEntity implements Serializable {

    private Long id;
    private String name;
    private String surname;
    private Integer age;
    private String email;
    private String password;
    private Set<DiskEntity> disks = new HashSet<DiskEntity>(0);


    public UsersEntity() {
    }

    public UsersEntity(String name, String surname, Integer age, String email, String password) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.email = email;
        this.password = password;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public Long getId() {
        return id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "TAKENITEMS", joinColumns = {@JoinColumn(name = "USERS_ID", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "DISK_ID", nullable = false, updatable = false)})
    @JsonBackReference
    public Set<DiskEntity> getDisks() {
        return this.disks;
    }

    public void setDisks(Set<DiskEntity> disks) {
        this.disks = disks;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "surname")
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Column(name = "age")
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
