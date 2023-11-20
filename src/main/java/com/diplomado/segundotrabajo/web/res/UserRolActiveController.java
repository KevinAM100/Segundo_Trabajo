package com.diplomado.segundotrabajo.web.res;


import com.diplomado.segundotrabajo.domain.entities.UserRol;
import com.diplomado.segundotrabajo.domain.entities.Users;
import com.diplomado.segundotrabajo.dto.UserRolDTO;
import com.diplomado.segundotrabajo.services.UserRolService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/v1/users/user-rol/active")
public class UserRolActiveController {

    private final UserRolService userRolService;

    public UserRolActiveController(UserRolService userRolService) {
        this.userRolService = userRolService;
    }


    @PatchMapping("{userRolID}")
    public ResponseEntity<UserRolDTO> editActive(@RequestBody final UserRolDTO userRolDTO,
                                                 @PathVariable final Integer userRolID ) throws URISyntaxException {

        Optional<UserRolDTO> existingUserRol = userRolService.findByID(userRolID);
        if (userRolDTO.getId() == null) {
            throw new IllegalArgumentException("Invalid user id, the value is null");
        }
        if (!Objects.equals(userRolDTO.getId(), userRolID)) {
            throw new IllegalArgumentException("the user id do not exist");
        }

        userRolDTO.setCreated_at(existingUserRol.get().getCreated_at());
        userRolDTO.setUserID(existingUserRol.get().getUserID());
        userRolDTO.setRolID(existingUserRol.get().getRolID());
        return ResponseEntity
                .ok()
                .body(this.userRolService.save(userRolDTO));

    }
}
