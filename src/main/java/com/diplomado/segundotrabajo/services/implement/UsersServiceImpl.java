package com.diplomado.segundotrabajo.services.implement;

import com.diplomado.segundotrabajo.domain.entities.UserDetail;
import com.diplomado.segundotrabajo.domain.entities.Users;
import com.diplomado.segundotrabajo.dto.UsersDTO;
import com.diplomado.segundotrabajo.repositories.UserDetailRepository;
import com.diplomado.segundotrabajo.repositories.UsersRepository;
import com.diplomado.segundotrabajo.services.UsersService;
import com.diplomado.segundotrabajo.services.mapper.UsersMapper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class UsersServiceImpl implements UsersService {

    private final UsersRepository usersRepository;

    private final UsersMapper usersMapper;

    private final UserDetailRepository userDetailRepository;


    public UsersServiceImpl(UsersRepository usersRepository, UsersMapper usersMapper,
                            UserDetailRepository userDetailRepository) {
        this.usersRepository = usersRepository;
        this.usersMapper = usersMapper;
        this.userDetailRepository = userDetailRepository;
    }


    @Override
    @Transactional(readOnly = true)
    public List<UsersDTO> listUsers() {
        return usersRepository.findAll()
                .stream()
                .map(usersMapper::toDto).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<UsersDTO> listUsersDetailed() {
        return usersRepository.findAll()
                .stream()
                .map(usersMapper::toDtoDetailed).collect(Collectors.toList());
    }


    @Override
    public UsersDTO save(UsersDTO dto) {
        Users users = usersRepository.save(usersMapper.toEntity(dto));
        userDetailRepository
                .save(new UserDetail(dto.getFirstName(), dto.getLastName(),dto.getAge(),null,  users));
        return usersMapper.toDto(users);

    }


    @Override
    public UsersDTO edit(UsersDTO dto) {
        Users users = usersRepository.save(usersMapper.toEntity(dto));
        UserDetail existingUserDetail = userDetailRepository.findByUsersId(users.getId())
                .orElse(new UserDetail());
        existingUserDetail.setFirstName(dto.getFirstName());
        existingUserDetail.setLastName(dto.getLastName());
        existingUserDetail.setAge(dto.getAge());
        existingUserDetail.setUsers(users);
        userDetailRepository.save(existingUserDetail);
        return usersMapper.toDto(users);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<UsersDTO> getUsersById(Long id) {
        return usersRepository.findById(id).map(usersMapper::toDtoDetailed);
    }

    @Override
    public void delete(Long id) {
        Users userToDelete = usersRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("the user with id: " + id + "not found"));

        UserDetail userDetail = userDetailRepository.findByUsersId(id)
                .orElseThrow(() -> new EntityNotFoundException("the user_detail with id: " + id + "not found"));

        if (userDetail != null) {
            userDetailRepository.deleteById(userDetail.getId());
        }

        usersRepository.deleteById(id);
    }
}
