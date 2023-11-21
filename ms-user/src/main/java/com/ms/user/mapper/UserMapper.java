package com.ms.user.mapper;

import com.ms.user.dto.UserDTO;
import com.ms.user.model.UserEntity;

public class UserMapper {

    public static UserEntity mapperUserDtoToEntity(UserDTO userDTO){

        return  UserEntity
                .builder()
                .email(userDTO.getEmail())
                .name(userDTO.getName())
                .document(userDTO.getDocument())
                .information(userDTO.getInformation())
                .build();
    }
}
