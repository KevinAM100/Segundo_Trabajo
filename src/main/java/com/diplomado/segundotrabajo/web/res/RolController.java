package com.diplomado.segundotrabajo.web.res;

import com.diplomado.segundotrabajo.dto.RolDTO;
import com.diplomado.segundotrabajo.dto.UsersDTO;
import com.diplomado.segundotrabajo.services.RolService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/v1/rols")
public class RolController {
    private final RolService rolService;

    public RolController(RolService rolService) {
        this.rolService = rolService;
    }

    @GetMapping
    public ResponseEntity<List<RolDTO>> listAllCourses() {
        return ResponseEntity.ok().body(rolService.listRols());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RolDTO> getRolsById(@PathVariable final Integer id) {
        return ResponseEntity
                .ok()
                .body(rolService.getRolsById(id).orElseThrow(() -> new IllegalArgumentException("Resource not found exception for the id: " + id)));
    }

    @PostMapping
    public ResponseEntity<RolDTO> save(@RequestBody final RolDTO dto) throws URISyntaxException {
        if (dto.getId() != null) {
            throw new IllegalArgumentException("I new course cannot already have an id.");
        }

        RolDTO rolDTO = this.rolService.save(dto);

        return ResponseEntity
                .created(new URI("/v1/courses/" + rolDTO.getId()))
                .body(rolDTO);
    }
    @PutMapping("/{id}")
    public ResponseEntity<RolDTO> editRol(@RequestBody final RolDTO dto,
                                                @PathVariable final Integer id) throws URISyntaxException {
        if (dto.getId() == null) {
            throw new IllegalArgumentException("Invalid rol id, the id roll is a null value");
        }
        if (!Objects.equals(dto.getId(), id)) {
            throw new IllegalArgumentException("the id rol do not exist");
        }

        return ResponseEntity
                .ok()
                .body(this.rolService.save(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRol(@PathVariable final Integer id) {
        rolService.delete(id);

        return ResponseEntity.noContent().build();
    }

}
