package com.diplomado.segundotrabajo.web.res;

import com.diplomado.segundotrabajo.domain.entities.UserRol;
import com.diplomado.segundotrabajo.domain.entities.Users;
import com.diplomado.segundotrabajo.dto.UserRolDTO;
import com.diplomado.segundotrabajo.services.UserRolService;
import com.diplomado.segundotrabajo.services.UsersService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/v1/users/{userID}/userRol")
public class UserRolController {

    private final UserRolService userRolService;
    private final UsersService usersService;

    public UserRolController(UserRolService userRolService, UsersService usersService) {
        this.userRolService = userRolService;
        this.usersService = usersService;
    }

    @GetMapping
    public ResponseEntity<List<UserRolDTO>> listEnrollmentsByUser(@PathVariable final Long userID) {
        return ResponseEntity.ok().body(userRolService.getRolByUserID(userID));
    }

    @PostMapping
    public ResponseEntity<UserRolDTO> save(@RequestBody final UserRolDTO userRolDTO) throws URISyntaxException {

        if (userRolDTO.getId() != null) {
            throw new IllegalArgumentException("I new course cannot already have an id.");
        }

        userRolDTO.setCreated_at(LocalDateTime.now());
        UserRolDTO userRolDB = this.userRolService.save(userRolDTO);

        return ResponseEntity
                .created(new URI("/v1/users/"+ userRolDB.getUserID().getId() + "/user-rol/" + userRolDB.getId()))
                .body(userRolDB);

    }
}
