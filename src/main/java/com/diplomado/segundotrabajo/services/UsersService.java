package com.diplomado.segundotrabajo.services;

import com.diplomado.segundotrabajo.dto.UsersDTO;
import com.diplomado.segundotrabajo.error.LocalNotFoundException;

import java.util.List;
import java.util.Optional;

public interface UsersService {

    List<UsersDTO> listUsers();
    List<UsersDTO> listUsersDetailed();
    UsersDTO save(UsersDTO dto);

    UsersDTO edit(UsersDTO dto);

    Optional<UsersDTO> getUsersById(Long id) throws LocalNotFoundException;
    void delete(Long id) throws LocalNotFoundException;
}
