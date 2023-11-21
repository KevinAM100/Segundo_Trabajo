package com.diplomado.segundotrabajo.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
@ToString
public class RolDTO {

    private Integer id;

    @Size(min = 8, max = 20, message = "El nombre debe tener entre 8 y 20 caracteres")
    @NotEmpty(message = "El nombre no puede estar vacío")
    private String name;

    public RolDTO() {
    }
}
