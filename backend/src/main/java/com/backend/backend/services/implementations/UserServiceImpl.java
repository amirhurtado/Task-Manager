package com.backend.backend.services.implementations;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.backend.backend.model.entities.User;
import com.backend.backend.model.repositories.UserRepo;
import com.backend.backend.services.interfaces.UserService;
import com.backend.backend.web.dtos.answer.UserDTO;
import com.backend.backend.web.dtos.request.UserCreateDTO;
import com.backend.backend.web.dtos.request.UserLoginDTO;
import com.backend.backend.web.dtos.request.UserUpdateDTO;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements  UserService {

    private final UserRepo userRepo;
    private final ModelMapper modelMapper;

    @Override
    public UserDTO createUser(UserCreateDTO userCreateDTO){
        User userToCreate = modelMapper.map(userCreateDTO, User.class);
        if(userRepo.existsByEmail(userToCreate.getEmail())){
            throw new RuntimeException("Email already exists");
        }

        User createdUser = userRepo.save(userToCreate);

        return modelMapper.map(createdUser, UserDTO.class);
    }

    @Override
    public  UserDTO login(UserLoginDTO userLoginDTO){

        User userTologin = modelMapper.map(userLoginDTO, User.class);

        User foundUser = userRepo.findByEmail(userTologin.getEmail())
            .orElseThrow(() -> new RuntimeException("The email does not exist"));

        if(!foundUser.getPassword().equals(userTologin.getPassword())){
            throw new RuntimeException("Incorrect password");
        }

        return modelMapper.map(foundUser, UserDTO.class);
        
    }



    @Override
    public UserDTO updateUsername(Long userId, UserUpdateDTO userUpdateDTO){

        User userToUpdate = userRepo.findById(userId)
            .orElseThrow(() -> new RuntimeException("User not found"));

            userToUpdate.setName(userUpdateDTO.getNewUsername());
            userRepo.save(userToUpdate);

            return modelMapper.map(userToUpdate, UserDTO.class);
    }

    @Override 
    public void deleteUser(Long userId){
        User userToDelete = userRepo.findById(userId)
            .orElseThrow(() -> new RuntimeException("User not found"));

            userRepo.delete(userToDelete);
    }


    
}
