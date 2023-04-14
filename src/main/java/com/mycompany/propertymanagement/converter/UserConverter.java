package com.mycompany.propertymanagement.converter;

import com.mycompany.propertymanagement.entity.UserEntity;
import com.mycompany.propertymanagement.model.UserDTO;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    public UserEntity convertDtoToEntity(UserDTO userDTO){
        UserEntity userEntity = new UserEntity();

        userEntity.setId(userDTO.getId());
        userEntity.setOwnerEmail(userDTO.getOwnerEmail());
        userEntity.setOwnerName(userDTO.getOwnerName());
        userEntity.setUserName(userDTO.getUserName());
        userEntity.setPassword(userDTO.getPassword());
        userEntity.setPhoneNbr(userDTO.getPhoneNbr());

        return userEntity;
    }

    public UserDTO convertEntityToDto(UserEntity userEntity){
        UserDTO userDTO = new UserDTO();

        userDTO.setId(userEntity.getId());
        userDTO.setOwnerEmail(userEntity.getOwnerEmail());
        userDTO.setOwnerName(userEntity.getOwnerName());
        userDTO.setUserName(userEntity.getUserName());
        userDTO.setPassword(userEntity.getPassword());
        userDTO.setPhoneNbr(userEntity.getPhoneNbr());

        return userDTO;
    }
}
