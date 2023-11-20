package com.diplomado.segundotrabajo.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "user_rol")
public class UserRol {

    @Id
    @SequenceGenerator(name = "user_rol_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_rol_sequence")
    private Integer id;

    private Boolean active;
    @Column(name = "created_at", columnDefinition = "TIMESTAMP")
    private LocalDateTime createdAt;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private Users userID;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "rol_id")
    private Rol rolID;

    public UserRol(Boolean active, LocalDateTime createdAt, Users userID, Rol rolID) {
        this.active = active;
        this.createdAt = createdAt;
        this.userID = userID;
        this.rolID = rolID;
    }

    public UserRol() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public LocalDateTime getCreated_at() {
        return createdAt;
    }

    public void setCreated_at(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Users getUserID() {
        return userID;
    }

    public void setUserID(Users userID) {
        this.userID = userID;
    }

    public Rol getRolID() {
        return rolID;
    }

    public void setRolID(Rol rolID) {
        this.rolID = rolID;
    }

    @Override
    public String toString() {
        return "UserRol{" +
                "id=" + id +
                ", active=" + active +
                ", created_at=" + createdAt +
                ", userID=" + userID +
                ", rolID=" + rolID +
                '}';
    }
}
