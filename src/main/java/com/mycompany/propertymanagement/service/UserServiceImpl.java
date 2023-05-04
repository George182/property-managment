package com.mycompany.propertymanagement.service;

import com.mycompany.propertymanagement.converter.UserConverter;
import com.mycompany.propertymanagement.entity.AddressEntity;
import com.mycompany.propertymanagement.entity.UserEntity;
import com.mycompany.propertymanagement.exception.BusinessException;
import com.mycompany.propertymanagement.exception.ErrorModel;
import com.mycompany.propertymanagement.model.UserDTO;
import com.mycompany.propertymanagement.repository.AddressRepository;
import com.mycompany.propertymanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserConverter userConverter;

    @Override
    public UserDTO register(UserDTO userDTO) {
        UserEntity userEntity = userConverter.convertDtoToEntity(userDTO);

        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setHouseNbr(userDTO.getHouseNbr());
        addressEntity.setCity(userDTO.getCity());
        addressEntity.setPostalCode(userDTO.getPostalCode());
        addressEntity.setStreet(userDTO.getStreet());
        addressEntity.setCountry(userDTO.getCountry());

        addressEntity.setUserEntity(userEntity);

        Optional<UserEntity> user =  userRepository.findByOwnerEmail(userDTO.getOwnerEmail());

        if(!user.isPresent()){
            userRepository.save(userEntity);
            addressRepository.save(addressEntity);
            userDTO = userConverter.convertEntityToDto(userEntity);
            return userDTO;
        }else {
            List<ErrorModel> errorModelList = new ArrayList<>();
            ErrorModel errorModel = new ErrorModel();
            errorModel.setCode("Email Address Already Exists");
            errorModel.setMessage("User already exists");
            errorModelList.add(errorModel);

            throw new BusinessException(errorModelList);
        }


    }

    @Override
    public UserDTO login(String email, String password) {
        UserDTO userDTO = null;
        Optional<UserEntity> optionalUserEntity = userRepository.findByOwnerEmailAndPassword(email, password);

        if(optionalUserEntity.isPresent()){
            userDTO = userConverter.convertEntityToDto(optionalUserEntity.get());
        }else {
            List<ErrorModel> errorModelList = new ArrayList<>();
            ErrorModel errorModel = new ErrorModel();
            errorModel.setCode("INVALID_LOGIN");
            errorModel.setMessage("Incorrect Email or Password");
            errorModelList.add(errorModel);

            throw new BusinessException(errorModelList);
        }
        return userDTO;
    }
}
