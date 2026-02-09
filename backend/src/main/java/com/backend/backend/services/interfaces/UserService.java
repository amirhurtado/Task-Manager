package com.backend.backend.services.interfaces;

import com.backend.backend.web.dtos.answer.UserDTO;
import com.backend.backend.web.dtos.request.UserCreateDTO;
import com.backend.backend.web.dtos.request.UserLoginDTO;

public interface  UserService {
    UserDTO createUser(UserCreateDTO userCreateDTO);
    UserDTO login(UserLoginDTO userLoginDTO);
    UserDTO updateUsername(Long userId, String newUsername);
    void deleteUser(Long userId);
}
