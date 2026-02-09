package com.backend.backend.services.implementations;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.backend.backend.model.repositories.UserRepo;
import com.backend.backend.services.interfaces.UserService;
import com.backend.backend.web.dtos.answer.UserDTO;
import com.backend.backend.web.dtos.request.UserCreateDTO;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements  UserService {

    private final UserRepo userRepo;
    private final ModelMapper modelMapper;
    
}
