package com.backend.backend.services.interfaces;

import com.backend.backend.web.dtos.answer.UserDTO;
import com.backend.backend.web.dtos.request.UserCreateDTO;

public interface  UserService {
    UserDTO createUser(UserCreateDTO userCreateDTO);
}
