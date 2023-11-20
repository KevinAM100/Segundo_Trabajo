package com.diplomado.segundotrabajo.services;

import com.diplomado.segundotrabajo.dto.RolDTO;
import com.diplomado.segundotrabajo.dto.UserRolDTO;
import com.diplomado.segundotrabajo.dto.UsersDTO;

import java.util.List;
import java.util.Optional;

public interface RolService {
    List<RolDTO> listRols();
    RolDTO save(RolDTO dto);
    Optional<RolDTO> getRolsById(Integer id);
    void delete(Integer id);
}
