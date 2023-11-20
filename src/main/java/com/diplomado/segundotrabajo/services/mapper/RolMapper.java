package com.diplomado.segundotrabajo.services.mapper;

import com.diplomado.segundotrabajo.domain.entities.Rol;
import com.diplomado.segundotrabajo.dto.RolDTO;
import com.diplomado.segundotrabajo.dto.UsersDTO;
import org.springframework.stereotype.Component;

@Component
public class RolMapper implements CustomMapper<RolDTO, Rol>{

    @Override
    public RolDTO toDto(Rol rol) {
        RolDTO dto = new RolDTO();
        dto.setId(rol.getId());
        dto.setName(rol.getName());
        return dto;

    }

    @Override
    public Rol toEntity(RolDTO rolDTO) {
        Rol rol = new Rol();
        rol.setId(rolDTO.getId());
        rol.setName(rolDTO.getName());
        return rol;
    }
}
