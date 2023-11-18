package com.diplomado.segundotrabajo.services;

import com.diplomado.segundotrabajo.dto.UsersDTO;

import java.util.List;
import java.util.Optional;

public interface UsersService {

    List<UsersDTO> listUsers();
    List<UsersDTO> listUsersDetailed();
    UsersDTO save(UsersDTO dto);
    Optional<UsersDTO> getUsersById(Long id);
    void delete(Long id);
}
