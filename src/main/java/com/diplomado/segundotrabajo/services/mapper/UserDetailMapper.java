package com.diplomado.segundotrabajo.services.mapper;

import com.diplomado.segundotrabajo.domain.entities.UserDetail;
import org.springframework.stereotype.Component;

@Component
public class UserDetailMapper implements CustomMapper<UserDetailMapper, UserDetail>{
    @Override
    public UserDetailMapper toDto(UserDetail userDetail) {
        return null;
    }

    @Override
    public UserDetail toEntity(UserDetailMapper userDetailMapper) {
        return null;
    }
}
