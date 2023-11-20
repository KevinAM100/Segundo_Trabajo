package com.diplomado.segundotrabajo.repositories;

import com.diplomado.segundotrabajo.domain.entities.UserRol;
import com.diplomado.segundotrabajo.dto.UserRolDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRolRepository extends JpaRepository<UserRol, Integer> {
    List<UserRol> findAllByUserID_IdOrderById(Long userID);
}
