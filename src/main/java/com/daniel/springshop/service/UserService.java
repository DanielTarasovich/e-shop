package com.daniel.springshop.service;


import com.daniel.springshop.domain.User;
import com.daniel.springshop.dto.UserDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    boolean save(UserDTO userDTO);

    void save(User user);
    List<UserDTO> getAll();

    User findByName(String name);

   void updateProfile(UserDTO userDTO);
}
