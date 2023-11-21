package com.ms.user.service;

import com.ms.user.dto.UserDTO;
import org.springframework.http.ResponseEntity;

public interface IUserService {

    ResponseEntity create(UserDTO userDTO);
}
