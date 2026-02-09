package com.backend.backend.web.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.backend.services.interfaces.UserService;
import com.backend.backend.web.dtos.answer.UserDTO;
import com.backend.backend.web.dtos.request.UserCreateDTO;
import com.backend.backend.web.dtos.request.UserLoginDTO;
import com.backend.backend.web.dtos.request.UserUpdateDTO;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
@CrossOrigin(origins="http://localhost:4200/")
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody UserCreateDTO userCreateDTO) {

        UserDTO userDTO = userService.createUser(userCreateDTO);

        return new ResponseEntity<>(userDTO, HttpStatus.CREATED);        
    }

    @GetMapping
    public  ResponseEntity<UserDTO> login(@RequestBody UserLoginDTO userLoginDTO) {
        
        UserDTO userDTO = userService.login(userLoginDTO);

        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }

    @PutMapping("/upload-username/{id}")
    public ResponseEntity<UserDTO> updateUsername(@PathVariable Long id, @RequestBody UserUpdateDTO userUpdateDTO) {
        
        UserDTO updatedUser = userService.updateUsername(id, userUpdateDTO);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }
    

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
}
