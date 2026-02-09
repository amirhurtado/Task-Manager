package com.backend.backend.services.implementations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import com.backend.backend.model.entities.User;
import com.backend.backend.model.repositories.UserRepo;
import com.backend.backend.web.dtos.answer.UserDTO;
import com.backend.backend.web.dtos.request.UserCreateDTO;


@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {

    @Mock
    private UserRepo userRepo;

    @Spy
    private ModelMapper modelMapper;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    void testCreateUser() {
        UserCreateDTO dto = new UserCreateDTO("test@mail.com", "Test", "123");
        User userSaved = new User();
        userSaved.setId(1L);
        userSaved.setEmail("test@mail.com");

        when(userRepo.existsByEmail(any())).thenReturn(false);
        when(userRepo.save(any())).thenReturn(userSaved);

        UserDTO result = userService.createUser(dto);

        assertNotNull(result);
        verify(userRepo).save(any());
    }

    @Test
    void testDeleteUser() {
        User user = new User();
        user.setId(1L);
        
        when(userRepo.findById(1L)).thenReturn(Optional.of(user));
        
        userService.deleteUser(1L);
        
        verify(userRepo).delete(user);
    }

    @Test
    void testUpdateUsername() {
        User user = new User();
        user.setId(1L);
        user.setName("Old Name");

        when(userRepo.findById(1L)).thenReturn(Optional.of(user));
        
        UserDTO result = userService.updateUsername(1L, "New Name");

        assertEquals("New Name", result.getName());
    }
}