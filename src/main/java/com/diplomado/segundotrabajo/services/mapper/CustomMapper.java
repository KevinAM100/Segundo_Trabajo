package com.diplomado.segundotrabajo.services.mapper;

public interface CustomMapper<DTO, E> {
        DTO toDto(E e);
        E toEntity(DTO dto);

}
