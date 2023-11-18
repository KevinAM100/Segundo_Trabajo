package com.diplomado.segundotrabajo.web.res;

import com.diplomado.segundotrabajo.dto.UsersDTO;
import com.diplomado.segundotrabajo.services.UsersService;
import org.apache.catalina.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/v1/users")
public class UsersController {
    private final UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping
    public ResponseEntity<List<UsersDTO>> listStudents(@RequestParam(required = false, defaultValue = "false") boolean detailed) {
        if (detailed) {
            return ResponseEntity.ok().body(usersService.listUsersDetailed());
        } else {
            return ResponseEntity.ok().body(usersService.listUsersDetailed());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsersDTO> getStudentById(@PathVariable final Long id) {
        return ResponseEntity
                .ok()
                .body(usersService.getUsersById(id).orElseThrow(() -> new IllegalArgumentException("Resource not found exception for the id: " + id)));
    }

    @PostMapping
    public ResponseEntity<UsersDTO> create(@RequestBody final UsersDTO dto) throws URISyntaxException {
        if (dto.getId() != null) {
            throw new IllegalArgumentException("I new student cannot already have an id.");
        }
        dto.setCreatedAt(LocalDateTime.now());

        UsersDTO usersDB = usersService.save(dto);

        return ResponseEntity.created(new URI("/v1/students/" + usersDB.getId())).body(usersDB);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsersDTO> editCourse(@RequestBody final UsersDTO dto,
                                           @PathVariable final Long id) throws URISyntaxException {
        if (dto.getId() == null) {
            throw new IllegalArgumentException("Invalid user id, the value is null");
        }
        if (!Objects.equals(dto.getId(), id)) {
            throw new IllegalArgumentException("the user id do not exist");
        }
        dto.setCreatedAt(LocalDateTime.now());
        return ResponseEntity
                .ok()
                .body(this.usersService.save(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable final Long id) {
        usersService.delete(id);

        return ResponseEntity.noContent().build();
    }
}