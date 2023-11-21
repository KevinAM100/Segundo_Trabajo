package com.diplomado.segundotrabajo.domain.entities;

import jakarta.persistence.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "rol")
public class Rol {

    @Id
    @SequenceGenerator(name = "rol_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rol_sequence")

    private Integer id;

    @Size(min = 8, max = 20, message = "El nombre debe tener entre 8 y 20 caracteres")
    @NotEmpty(message = "El nombre no puede estar vacío")
    private String name;


    public Rol(@Size(min = 8, max = 20, message = "El nombre debe tener entre 8 y 20 caracteres") String name) {
        this.name = name;
    }

    public Rol() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Rol{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
