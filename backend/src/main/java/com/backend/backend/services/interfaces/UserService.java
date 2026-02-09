package com.backend.backend.services.interfaces;

import com.backend.backend.web.Dtos.answer.UserDTO;
import com.backend.backend.web.Dtos.request.UserCreateDTO;

public interface  UserService {
    UserDTO createUser(UserCreateDTO userCreateDTO);
}
