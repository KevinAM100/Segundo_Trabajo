package com.diplomado.segundotrabajo.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class UsersDTO {
    private Long id;
    private String  username;
    private String password;
    private  String email;
    private LocalDateTime createdAt;

    private String firstName;
    private String LastName;
    private Integer age;
    private LocalDate birthDay;

    public UsersDTO() {
    }
}
