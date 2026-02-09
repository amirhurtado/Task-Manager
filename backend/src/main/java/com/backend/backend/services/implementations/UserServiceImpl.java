package com.backend.backend.services.implementations;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.backend.backend.model.repositories.UserRepo;
import com.backend.backend.services.interfaces.UserService;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements  UserService {

    private final UserRepo userRepo;
    private final ModelMapper modelMapper;
    
}
