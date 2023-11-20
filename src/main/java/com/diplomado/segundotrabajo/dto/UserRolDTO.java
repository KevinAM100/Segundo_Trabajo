package com.diplomado.segundotrabajo.dto;

import com.diplomado.segundotrabajo.domain.entities.Rol;
import com.diplomado.segundotrabajo.domain.entities.Users;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString

public class UserRolDTO {

    private Integer id;
    private Boolean active;
    private LocalDateTime created_at;
    private Users userID;
    private Rol rolID;

    private String firstName;
    private String LastName;
    private String rolName;

    public UserRolDTO() {
    }
}
