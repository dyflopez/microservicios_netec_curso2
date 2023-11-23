package com.ms.user.mapper;

import com.ms.user.dto.UserDTO;
import com.ms.user.model.UserEntity;

public class UserMapper {

    public static UserEntity getUserDtoToUserEntity(UserDTO userDTO){
        return UserEntity
                .builder()
                .name(userDTO.getName())
                .email(userDTO.getEmail())
                .information(userDTO.getInformation())
                .document(userDTO.getDocument())
                .build();
    }

    public static  UserEntity getUserEntityMapperUserDto(UserEntity userEntity,UserDTO userDTO){

        userEntity.setDocument(userDTO.getDocument());
        userEntity.setEmail(userDTO.getEmail());
        userEntity.setName(userDTO.getEmail());
        userEntity.setName(userDTO.getName());

        return userEntity;
    }
}
