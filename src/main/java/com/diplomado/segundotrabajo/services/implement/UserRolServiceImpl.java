package com.diplomado.segundotrabajo.services.implement;

import com.diplomado.segundotrabajo.domain.entities.UserDetail;
import com.diplomado.segundotrabajo.domain.entities.UserRol;
import com.diplomado.segundotrabajo.domain.entities.Users;
import com.diplomado.segundotrabajo.dto.UserRolDTO;
import com.diplomado.segundotrabajo.repositories.UserRolRepository;
import com.diplomado.segundotrabajo.services.UserRolService;
import com.diplomado.segundotrabajo.services.mapper.UserRolMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserRolServiceImpl implements UserRolService {

    private final UserRolRepository userRolRepository;

    private final UserRolMapper userRolMapper;

    public UserRolServiceImpl(UserRolRepository userRolRepository, UserRolMapper userRolMapper) {
        this.userRolRepository = userRolRepository;
        this.userRolMapper = userRolMapper;
    }

    @Override
    public List<UserRolDTO> getRolByUserID(Long userID) {
        return userRolRepository.findAllByUserID_IdOrderById(userID)
                .stream()
                .map(userRolMapper::toDtoList).collect(Collectors.toList());
    }

    @Override
    public List<UserRolDTO> findAllByUserID(Long userID) {
        return userRolRepository.findAllByUserID_IdOrderById(userID)
                .stream()
                .map(userRolMapper::toDtoList).collect(Collectors.toList());
    }

    @Override
    public UserRolDTO save(UserRolDTO userRol) {
        UserRol userRolA = userRolRepository.save(userRolMapper.toEntity(userRol));
        return userRolMapper.toDto(userRolA);

    }




}
