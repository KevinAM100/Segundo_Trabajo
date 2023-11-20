package com.diplomado.segundotrabajo.services;

import com.diplomado.segundotrabajo.domain.entities.UserRol;
import com.diplomado.segundotrabajo.dto.UserRolDTO;

import java.util.List;
import java.util.Optional;

public interface UserRolService {
    List<UserRolDTO> getRolByUserID(Long userID);

    List<UserRolDTO> findAllByUserID(Long userID);

    Optional<UserRolDTO> findByID (Integer id);

    UserRolDTO save(UserRolDTO userRol);

    UserRolDTO inactivateUserRol(Integer userRolID);

    void delete(Integer id);

}
