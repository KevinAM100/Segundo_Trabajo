package com.diplomado.segundotrabajo.dto;

import com.diplomado.segundotrabajo.domain.entities.Users;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;


@Getter
@Setter
@ToString
public class UserDetailDTO {

    private Long id;

    private String firstName;

    private String LastName;

    private Integer age;

    private LocalDate birthDay;

    private Users users;

    public UserDetailDTO() {
    }
}
