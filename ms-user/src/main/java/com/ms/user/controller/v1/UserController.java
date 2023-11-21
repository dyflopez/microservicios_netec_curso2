package com.ms.user.controller.v1;

import com.ms.user.controller.v1.docs.UserDoc;
import com.ms.user.dto.UserDTO;
import com.ms.user.service.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController implements UserDoc {

    private  final IUserService iUserService;

    @Override
    @PostMapping
    public ResponseEntity create(UserDTO userDTO) {
        return iUserService.create(userDTO);
    }
}
