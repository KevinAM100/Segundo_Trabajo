package com.diplomado.segundotrabajo.services.mapper;

import com.diplomado.segundotrabajo.domain.entities.Users;
import com.diplomado.segundotrabajo.dto.UsersDTO;
import org.springframework.stereotype.Component;

@Component
public class UsersMapper implements CustomMapper<UsersDTO, Users>{

    @Override
    public UsersDTO toDto(Users users) {
        UsersDTO dto = new UsersDTO();
        dto.setId(users.getId());
        dto.setUsername(users.getUsername());
        dto.setPassword(users.getPassword());
        dto.setEmail(users.getEmail());
        dto.setCreatedAt(users.getCreatedAt());
        return dto;
    }

    public UsersDTO toDtoDetailed(Users users) {
        UsersDTO dto = new UsersDTO();
        dto.setId(users.getId());
        dto.setUsername(users.getUsername());
        dto.setPassword(users.getPassword());
        dto.setEmail(users.getEmail());
        dto.setCreatedAt(users.getCreatedAt());

        if (users.getUserDetail() != null) {
            dto.setFirstName(users.getUserDetail().getFirstName());
            dto.setLastName(users.getUserDetail().getLastName());
            dto.setAge(users.getUserDetail().getAge());
            dto.setBirthDay(users.getUserDetail().getBirthDay());
        } else {
            dto.setFirstName("Not assigned yet");
            dto.setLastName("Not assigned yet");
            dto.setAge(0);
            dto.setBirthDay(null);
        }


        return dto;
    }

    @Override
    public Users toEntity(UsersDTO usersDTO) {
        Users users = new Users();
        users.setId(usersDTO.getId());
        users.setUsername(usersDTO.getUsername());
        users.setPassword(usersDTO.getPassword());
        users.setEmail(usersDTO.getEmail());
        users.setCreatedAt(usersDTO.getCreatedAt());
        return users;
    }
}
