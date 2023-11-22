package com.ms.user.service.impl;

import com.ms.user.dto.UserDTO;
import com.ms.user.mapper.UserMapper;
import com.ms.user.model.UserEntity;
import com.ms.user.repository.UserRepository;
import com.ms.user.service.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class UserService implements IUserService {


    private final UserRepository userRepository;
    @Override
    public ResponseEntity create(UserDTO userDTO) {

        String uuid  = UUID.randomUUID().toString();

        UserEntity user = UserMapper.mapperUserDtoToEntity(userDTO);
        user.setId(uuid);

       var newUser=  userRepository.save(user);

       return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
    }

    @Override
    public ResponseEntity findAll() {

        var lista=   userRepository.findAll();
        return ResponseEntity.ok(lista);
    }
}
