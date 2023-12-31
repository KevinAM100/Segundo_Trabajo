package com.diplomado.segundotrabajo.services.implement;

import com.diplomado.segundotrabajo.domain.entities.UserDetail;
import com.diplomado.segundotrabajo.domain.entities.Users;
import com.diplomado.segundotrabajo.dto.UserRolDTO;
import com.diplomado.segundotrabajo.dto.UsersDTO;
import com.diplomado.segundotrabajo.error.LocalNotFoundException;
import com.diplomado.segundotrabajo.repositories.UserDetailRepository;
import com.diplomado.segundotrabajo.repositories.UserRolRepository;
import com.diplomado.segundotrabajo.repositories.UsersRepository;
import com.diplomado.segundotrabajo.services.UsersService;
import com.diplomado.segundotrabajo.services.mapper.UserRolMapper;
import com.diplomado.segundotrabajo.services.mapper.UsersMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class UsersServiceImpl implements UsersService {

    private final UsersRepository usersRepository;

    private final UsersMapper usersMapper;

    private final UserDetailRepository userDetailRepository;

    private final UserRolRepository userRolRepository;

    private final UserRolMapper userRolMapper;


    public UsersServiceImpl(UsersRepository usersRepository, UsersMapper usersMapper,
                            UserDetailRepository userDetailRepository, UserRolRepository userRolRepository, UserRolMapper userRolMapper) {
        this.usersRepository = usersRepository;
        this.usersMapper = usersMapper;
        this.userDetailRepository = userDetailRepository;
        this.userRolRepository = userRolRepository;
        this.userRolMapper = userRolMapper;
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
                .save(new UserDetail(dto.getFirstName(), dto.getLastName(),dto.getAge(), dto.getBirthDay(),  users));
        return usersMapper.toDto(users);

    }


    @Override
    public UsersDTO edit(UsersDTO dto) {
        Users users = usersRepository.save(usersMapper.toEntity(dto));
        UserDetail existingUserDetail = userDetailRepository.findByUsersId(users.getId())
                .orElse(new UserDetail());
        existingUserDetail.setId(dto.getUserDetailId());
        existingUserDetail.setFirstName(dto.getFirstName());
        existingUserDetail.setLastName(dto.getLastName());
        existingUserDetail.setAge(dto.getAge());
        existingUserDetail.setBirthDay(dto.getBirthDay());
        existingUserDetail.setUsers(users);
        userDetailRepository.save(existingUserDetail);
        return usersMapper.toDto(users);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<UsersDTO> getUsersById(Long id) throws LocalNotFoundException {

        Optional<UsersDTO> usersDTO = usersRepository.findById(id).map(usersMapper::toDtoDetailed);
        if(!usersDTO.isPresent()){
            throw new LocalNotFoundException("user is not available");
        }
        return usersDTO;
    }

    @Override
    public void delete(Long id) throws LocalNotFoundException{

        List<UserRolDTO> userRolToDelte = userRolRepository.findAllByUserID_IdOrderById(id).stream()
                .map(userRolMapper::toDto).collect(Collectors.toList());

        Users userToDelete = usersRepository.findById(id)
                .orElseThrow(() -> new LocalNotFoundException("the user with id: " + id + "not found"));

        UserDetail userDetail = userDetailRepository.findByUsersId(id)
                .orElseThrow(() -> new LocalNotFoundException("the user_detail with id: " + id + "not found"));


        for (UserRolDTO userRolDTO : userRolToDelte) {
            userRolRepository.deleteById(userRolDTO.getId());
        }

        usersRepository.deleteById(id);
    }
}
