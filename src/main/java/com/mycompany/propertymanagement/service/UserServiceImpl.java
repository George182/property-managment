package com.mycompany.propertymanagement.service;

import com.mycompany.propertymanagement.converter.UserConverter;
import com.mycompany.propertymanagement.entity.UserEntity;
import com.mycompany.propertymanagement.model.UserDTO;
import com.mycompany.propertymanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserConverter userConverter;

    @Override
    public UserDTO register(UserDTO userDTO) {
        UserEntity userEntity = userConverter.convertDtoToEntity(userDTO);
        userRepository.save(userEntity);
        userDTO = userConverter.convertEntityToDto(userEntity);
        return userDTO;
    }

    @Override
    public UserDTO login(String email, String password) {
        return null;
    }
}
