package com.diplomado.segundotrabajo.domain.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "users")
public class Users {

    @Id
    @SequenceGenerator(name = "user_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
    private Long id;

    private String  username;
    private String password;
    private  String email;
    @Column(name = "created_at", columnDefinition = "TIMESTAMP")
    private LocalDateTime createdAt;

    @OneToOne(mappedBy = "users", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    private UserDetail userDetail;




    public Users(String username, String password, String email, LocalDateTime createdAt) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.createdAt = createdAt;
    }
    public Users() {
    }


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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public UserDetail getUserDetail() {
        return userDetail;
    }

    public void setUserDetail(UserDetail userDetail) {
        this.userDetail = userDetail;
    }

}
