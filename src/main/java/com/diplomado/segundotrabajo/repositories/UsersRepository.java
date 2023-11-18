package com.diplomado.segundotrabajo.repositories;

import com.diplomado.segundotrabajo.domain.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Long> {

}
