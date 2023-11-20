package com.diplomado.segundotrabajo.services.mapper;

import com.diplomado.segundotrabajo.domain.entities.UserRol;
import com.diplomado.segundotrabajo.dto.UserRolDTO;
import org.springframework.stereotype.Component;

@Component
public class UserRolMapper implements CustomMapper<UserRolDTO, UserRol>{
    @Override
    public UserRolDTO toDto(UserRol userRol) {
        UserRolDTO dto = new UserRolDTO();
        dto.setId(userRol.getId());
        dto.setActive(userRol.getActive());
        dto.setCreated_at(userRol.getCreated_at());
        dto.setUserID(userRol.getUserID());
        dto.setRolID(userRol.getRolID());
        return dto;
    }


    public UserRolDTO toDtoList(UserRol userRol) {
        UserRolDTO dto = new UserRolDTO();
        dto.setId(userRol.getId());
        dto.setActive(userRol.getActive());
        dto.setCreated_at(userRol.getCreated_at());

        if (userRol.getUserID() != null && userRol.getRolID() != null) {
            dto.setLastName(userRol.getUserID().getUsername());
            dto.setFirstName(userRol.getUserID().getUserDetail().getLastName());
            dto.setRolName(userRol.getRolID().getName());
        } else {
            dto.setUserID(null);
            dto.setRolID(null);
        }
        return dto;
    }

    @Override
    public UserRol toEntity(UserRolDTO userRolDTO) {
        UserRol userRol = new UserRol();
        userRol.setId(userRolDTO.getId());
        userRol.setActive(userRolDTO.getActive());
        userRol.setCreated_at(userRolDTO.getCreated_at());
        userRol.setUserID(userRolDTO.getUserID());
        userRol.setRolID(userRolDTO.getRolID());
        return userRol;
    }
}
