package com.diplomado.segundotrabajo.services.implement;

import com.diplomado.segundotrabajo.dto.RolDTO;
import com.diplomado.segundotrabajo.repositories.RolRepository;
import com.diplomado.segundotrabajo.services.RolService;
import com.diplomado.segundotrabajo.services.mapper.RolMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RolServiceImpl implements RolService {

    private final RolRepository rolRepository;

    private final RolMapper rolMapper;

    public RolServiceImpl(RolRepository rolRepository, RolMapper rolMapper) {
        this.rolRepository = rolRepository;
        this.rolMapper = rolMapper;
    }

    @Override
    public List<RolDTO> listRols() {
        return rolRepository.findAll()
                .stream()
                .map(rolMapper::toDto).collect(Collectors.toList());
    }


    @Override
    public RolDTO save(RolDTO dto) {
        return this.rolMapper
                .toDto(rolRepository.save(this.rolMapper.toEntity(dto)));
    }


    @Override
    public Optional<RolDTO> getRolsById(Integer id) {
        return rolRepository.findById(id).map(rolMapper::toDto);
    }

    @Override
    public void delete(Integer id) {
        rolRepository.deleteById(id);
    }
}
