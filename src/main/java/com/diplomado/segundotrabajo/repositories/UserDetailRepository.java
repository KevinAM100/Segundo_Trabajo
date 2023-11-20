package com.diplomado.segundotrabajo.repositories;

import com.diplomado.segundotrabajo.domain.entities.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserDetailRepository extends JpaRepository<UserDetail, Long> {
    Optional<UserDetail> findByUsersId(Long usersId);
}
